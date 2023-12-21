import React, { useEffect, useState } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Paper from '@mui/material/Paper';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './UserPage.css';

const defaultTheme = createTheme();

export default function UserPage({ userId }){
    const [user, setUser] = useState(null);
    const navigate = useNavigate();
    const [showPassword, setShowPassword] = useState(false);

    useEffect(() => {
      const fetchUser = async () => {
        try {
          const response = await axios.get(`http://localhost:9090/api/passenger/${userId}`);
          setUser(response.data);
        } catch (error) {
          console.error('Error fetching user:', error);
        }
      };
  
      fetchUser();
    }, [userId]);
  

    const handleRedirect = () => {
        navigate('/editInfo')
    };

    const handleTogglePassword = () => {
        setShowPassword(!showPassword);
    };

      return (
        <div className="user-page-container">
          <h2>User Page</h2>
          {user ? (
            <div className="user-details">
              <div className="user-details-row">
                <p><strong>Name:</strong> {user.fname} {user.lname}</p>
                <p><strong>Email:</strong> {user.email}</p>
              </div>
              <div className="user-details-row">
                <p><strong>Phone Number:</strong> {user.phoneNumber}</p>
                <p><strong>Address:</strong> {user.address}</p>
              </div>
              <div className="user-details-row">
                <p><strong>Blocked:</strong> {user.blocked ? 'Yes' : 'No'}</p>
                <p><strong>Password:</strong> {showPassword ? user.password : '*'.repeat(user.password.length)}</p>
                <button className="reveal-button" onClick={handleTogglePassword}>
                    {showPassword ? 'Hide Password' : 'Reveal Password'}
                </button>
              </div>
              <div className="user-details-row">
                <img src={user.imgUrl} alt="Avatar" className="user-avatar" />
              </div>
              <button className="redirect-button" onClick={handleRedirect}>
                Edit user info
              </button>
              {/* Add more fields or buttons as needed */}
            </div>
          ) : (
            <p>Loading...</p>
          )}
        </div>
    );
  }