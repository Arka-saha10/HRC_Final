import React from "react";
import classes from './MainNavigation.module.css';
import Box from "@mui/material/Box";
import AppBar from "@mui/material/AppBar";
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import icon1 from '../Images/logo3.svg';
import icon2 from '../Images/logo4.svg';
import MainTable from "./MainTable";

var classess = {
  logo: {
    margin: "auto",
    textAlign: "center",
    maxWidth: "50%",
    maxHeight: "70%"
  },
  logoHorizontallyCenter: {
    position: "absolute",
    left: "50%",
    top: "50%",
    transform: "translate(-50%, -50%)"
  }
};

function MainNavigation() {
  return (
    <div>
        <AppBar position="sticky" style={{ background: '#46566B', height: '2.5cm', paddingTop:'0.5cm'}} >
        <div class="logo-flex">
        <div class="logo-item">
        <img src={icon1}  alt="developer logo" align="left"/>
        </div>
        <div class="logo-item" style={classess.logoHorizontallyCenter}>
          <center>
            <img src={icon2} alt="company logo" align="centre"/> 
          </center>
        </div>
        <div class="invoice-list">
            
        </div>
       
    </div>
    
        
        </AppBar>
        
        <MainTable/>
        <div className={classes.header}>
    </div>
      
    </div>
  );
}

export default MainNavigation;