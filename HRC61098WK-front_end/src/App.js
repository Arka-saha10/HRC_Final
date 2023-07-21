import MainNavigation from './Components/MainNavigation';
import MenuBar from './Components/MenuBar';
import MainTable from './Components/MainTable';
import './App.css';
import React,{useState, useEffect} from 'react';
import axios from 'axios';
import Mainfooter from './Components/Mainfooter';
import './Components/modal.css'

function App() {
  //returning the MainNavigation
  return (
    <div className="App App-header">
      <MainNavigation />
      <Mainfooter/>
    </div>
  );
}

export default App;
