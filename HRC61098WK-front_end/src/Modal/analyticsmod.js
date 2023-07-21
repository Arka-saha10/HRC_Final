import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import swal from 'sweetalert';

export default function Formanalytics({ open,handleClose}) {
  const [dueDate1, setdueDate1] = React.useState();
  const [dueDate2, setdueDate2] = React.useState();
  const [clearDate1, setclearDate1] = React.useState();
  const [clearDate2, setclearDate2] = React.useState();
  const [baselineCreateDate1, setbaselineCreateDate1] = React.useState();
  const [baselineCreateDate2, setbaselineCreateDate2] = React.useState();
  const [invoiceCurrency, setinvoiceCurrency] = React.useState();
  function handleEdit(){

    console.log(invoiceCurrency);
   
    
   
  }
  
  return (
    <div className='modalbackground'>
      <div>
        <Dialog 
          open={open}
          onClose={handleClose}
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
          maxWidth = "lg"
        >
          <DialogTitle id="alert-dialog-title" className='modalbackground' >
          <div style={{color : 'white'}}>
              {"Analytics View"}
            </div>
          </DialogTitle>
          <DialogContent className='modalbackground' >
        <br/>
        <br/>
        <br/>
        <br/>
        <div style={{color : 'white'}}>
          Clear Date
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &thinsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;   
        &emsp;
        &emsp;
        &emsp;
       
      
        Due Date

        </div>

        <br/>
              
              
        <TextField
                onChange= {(event) =>{setclearDate1(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={clearDate1}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
             &emsp;
             &emsp;
             &emsp;
             &emsp;
             
            
           
             
              
             <TextField
                onChange= {(event) =>{setdueDate1(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={dueDate1}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
          <br/>
          <br/>
         
       
              
              
          <TextField
                onChange= {(event) =>{setclearDate2(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={clearDate2}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
              &emsp;
              &emsp;
             &emsp;
             &emsp;

              
             <TextField
                onChange= {(event) =>{setdueDate2(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={dueDate2}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
         
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
          <br/>
         
          <div style={{color : 'white'}}>
          Baseline Clear Date
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &thinsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;
        &emsp;   
 
            
        Invoice Currency

        </div>

        <br/>
              
       
              
              
          <TextField
                onChange= {(event) =>{setbaselineCreateDate1(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={baselineCreateDate1}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
              &emsp;
             &emsp;
             &emsp;
             &emsp;
              
              <TextField
              label= "Invoice Currency"
              onChange = {(event) =>{setinvoiceCurrency(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
          
          <br/>
          <br/>
        
          <div>
              
              
          <TextField
                onChange= {(event) =>{setbaselineCreateDate2(event.target.value)}}
                id="outlined-size-small"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={baselineCreateDate2}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
              &emsp;
              
             
          </div>
        
          
          </DialogContent>
          <DialogActions className='modalbackground' >
            <Button onClick={handleEdit} style={{color : 'white', width: '8cm', borderRadius:'5px'}}>SUBMIT</Button>
            <Button onClick={handleClose} autoFocus style={{color : 'white', width: '8cm', borderRadius:'5px'}}>
              CANCEL
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    
    </div>
  );
  
}