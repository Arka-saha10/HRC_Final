import React, { useState, useEffect } from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import '../Components/modal.css'
import swal from 'sweetalert';

export default function Formedel({rowSelect,setRowSelect,open,handleClose}) {
  //var[ delRows , setDelRows ] = useState(false);
  
  function handleDelete(){
      console.log(rowSelect);
      let l = String(rowSelect);
      console.log(l);
      console.log(typeof l);
      //To delete one or multiple row(s) in the table
      fetch('http://localhost:8080/HRC61098WK-back_end/delete?slNo='+l)
          .then(res => res.json())
          .then(result => console.log(result));
      handleClose();//Close the modal
      swal( {
        title: "The selected row [s] has been deleted!",
        icon: "success",
      });
    }
  

  
  return (
    <div className='modalbackground'>
      <div>
        <Dialog 
          open={open}
          onClose={handleClose}
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
        >
          <DialogTitle id="alert-dialog-title" style={{backgroundColor:"#2A3E4C"}}>
            <div style={{color : 'white'}}>
            {"Delete Records ?"}
            </div>
          </DialogTitle>
          <DialogContent style={{backgroundColor:"#2A3E4C"}}>
          <div style={{color:"white"}}>
              
              <h2>Are you sure you want to delete these record[s] ?</h2>
              
          </div>
          
          
          </DialogContent>
          <DialogActions style={{backgroundColor:"#2A3E4C"}}>
            <Button onClick={handleClose} style={{color : 'white', width : '7cm'}}>CANCEL</Button>
            <Button onClick={handleDelete} style={{color : 'white', width : '7cm'}} autoFocus>
              DELETE
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    
    </div>
  );
  
}