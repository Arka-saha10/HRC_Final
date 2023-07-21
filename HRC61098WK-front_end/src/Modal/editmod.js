import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import swal from 'sweetalert';

export default function Formedit({ rowSelect, setRowSelect ,open,handleClose}) {
  const [invoiceCurrency, setInvoiceCurrency] = React.useState();
  const [custPayt, setPayt] = React.useState();
  function handleEdit(){

    console.log(invoiceCurrency);
    console.log(custPayt);
    let row = String(rowSelect);
    console.log(row);
    console.log(typeof row);
    //editing a row's invoice currency and customer payment terms by its slno
    fetch('http://localhost:8080/HRC61098WK-back_end/edit?slNo='+row+'&invoiceCurrency='+invoiceCurrency+'&custPaymentTerms='+custPayt)
          .then(res => res.json())
          .then(result => console.log(result));
    handleClose();
    
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
          <DialogTitle id="alert-dialog-title" className='modalbackground' >
          <div style={{color : 'white'}}>
              {"EDIT"}
            </div>
          </DialogTitle>
          <DialogContent className='modalbackground' >
          <div>
              
              
              <TextField
              label= "Invoice Currency"
              onChange = {(event) =>{setInvoiceCurrency(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Customer Payment Terms"
              onChange = {(event) =>{setPayt(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
          </div>
          <br/>
        
          
          </DialogContent>
          <DialogActions className='modalbackground' >
            <Button onClick={handleEdit} style={{color : 'white', width: '8cm', borderRadius:'5px'}}>Edit</Button>
            <Button onClick={handleClose} autoFocus style={{color : 'white', width: '8cm', borderRadius:'5px'}}>
              Cancel
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    
    </div>
  );
  
}
