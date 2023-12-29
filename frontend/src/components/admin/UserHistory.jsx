import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useState, useEffect } from "react";
import axios from 'axios';
import "./UserHistory.css";

const defaultTheme = createTheme();

export default function UserHistory() {


    const [selectedDrive, setSelectedDrive] = useState(null);
    const [drives, setDrives] = useState([]);
    const [showDetails, setShowDetails] = useState(false);
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

      const handleRowClick = (drive) => {
        setSelectedDrive(drive);
        setShowDetails(true);
      };
  
      const handleResetClick = () => {
        setSelectedDrive(null);
        setShowDetails(false);
      };

    
    const displayedDrives = selectedDrive ? [selectedDrive] : drives;

    return(
      <div>
      <h1>Drive History</h1>
      <table>
        <thead>
          <tr>
            <th>Departure</th>
            <th>Destination</th>
            <th>Total Price</th>
            <th>Date</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {displayedDrives.map((drive) => (
            <React.Fragment key={drive.id}>
              <tr>
                <td>{drive.polaziste}</td>
                <td>{drive.odrediste}</td>
                <td>{drive.ukupnaCena}</td>
                <td>{drive.datum}</td>
                <td>
                  <button onClick={() => handleRowClick(drive)}>
                    {showDetails ? 'Hide Details' : 'Show Details'}
                  </button>
                </td>
              </tr>
              {showDetails && (
                <tr>
                  <td colSpan="5">
                    Additional Details:
                    <ul>
                      <li>ID: {drive.id}</li>
                      <li>Start Time: {drive.pocetak}</li>
                      <li>End Time: {drive.kraj}</li>
                      <li>Baby Friendly: {drive.babyFriendly ? 'Yes' : 'No'}</li>
                      <li>Pet Friendly: {drive.petFriendly ? 'Yes' : 'No'}</li>
                      <li>Status: {drive.status}</li>
                    </ul>
                  </td>
                </tr>
              )}
            </React.Fragment>
          ))}
        </tbody>
      </table>
      {selectedDrive && (
        <div>
          <button onClick={handleResetClick}>Reset</button>
        </div>
      )}
    </div>

    );

}