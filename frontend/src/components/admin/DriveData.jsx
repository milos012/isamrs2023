import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from "react";
import axios from 'axios';
import "./UserHistory.css";
import { BarChart, Bar, XAxis, YAxis, Tooltip, Legend, CartesianGrid,LineChart, Line } from 'recharts';


const defaultTheme = createTheme();

export default function DriveData() {


    const [drives, setDrives] = useState([]);
    useEffect(() => {
        const fetchDrives = async () => {
          try {
            const response = await axios.get('http://localhost:9090/api/drive/all');
            const responseData = response.data;

            setDrives(responseData);
            console.log(drives);
          } catch (error) {
            console.error('Error fetching drives:', error);
          }
        };
    
        // Call the fetchDrives function when the component mounts
        fetchDrives();
      }, []);


      const generateChartData = (drivesData) => {
        const dates = drivesData.map((drive) => drive.datum);
        const uniqueDates = Array.from(new Set(dates));
        const driveCounts = uniqueDates.map(
          (date) => drivesData.filter((drive) => drive.datum === date).length
        );
    
        return uniqueDates.map((date, index) => ({
          date,
          drives: driveCounts[index],
          totalPrice: drivesData
            .filter((drive) => drive.datum === date)
            .reduce((total, drive) => total + drive.ukupnaCena, 0),
        }));
      };
    
      const chartData = generateChartData(drives);


    return(
      <div className="container">
        <h1>Drive Data</h1>
        <div style={{ marginTop: '20px' }}>
            <h2>Number of Drives by Date</h2>
            <BarChart width={600} height={300} data={chartData} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
            <XAxis dataKey="date" />
            <YAxis />
            <CartesianGrid strokeDasharray="3 3" />
            <Tooltip />
            <Legend />
            <Bar dataKey="drives" fill="rgba(75,192,192,0.6)" name="Number of Drives" />
            </BarChart>
        </div>
        <div style={{ marginTop: '20px' }}>
        <h2>Total Price by Date</h2>
        <LineChart width={600} height={300} data={chartData} margin={{ top: 20, right: 30, left: 20, bottom: 5 }}>
          <XAxis dataKey="date" />
          <YAxis />
          <CartesianGrid strokeDasharray="3 3" />
          <Tooltip />
          <Legend />
          <Line type="monotone" dataKey="totalPrice" stroke="#8884d8" name="Total Price" />
        </LineChart>
        </div>
      </div>

    );

}

