import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';
import { width } from '@mui/system';
import swal from 'sweetalert';
import DatePicker from "react-datepicker";

export default function FormDialog({open,handleClose}) {

  const [businessCode, setbusinessCode] = React.useState();
  const [custNumber, setcustNumber] = React.useState();
  const [clearDate, setclearDate] = React.useState(new Date());
  const [buisnessYear, setbuisnessYear] = React.useState();
  const [docId, setdocId] = React.useState();
  const [postingDate, setpostingDate] = React.useState(new Date());
  const [documentCreateDate, setdocumentCreateDate] = React.useState(new Date());
  const [dueInDate, setdueInDate] = React.useState(new Date());
  const [invoiceCurrency, setinvoiceCurrency] = React.useState();
  const [documentType, setdocumentType] = React.useState();
  const [postingId, setpostingId] = React.useState();
  const [totalOpenAmount, settotalOpenAmount] = React.useState();
  const [baselineCreateDate, setbaselineCreateDate] = React.useState(new Date());
  const [custPaymentTerms, setcustPaymentTerms] = React.useState();
  const [invoiceId, setinvoiceId] = React.useState();
  const [mess,setMess] = React.useState();


 




  function handleAdd(){

    //To send the parameter through url and add a row in the table
    fetch('http://localhost:8080/HRC61098WK-back_end/add?businessCode='+businessCode+'&custNumber='+custNumber+'&clearDate='+clearDate+'&buisnessYear='+buisnessYear+'&docId='+docId+'&postingDate='+postingDate+'&documentCreateDate='+documentCreateDate+'&dueInDate='+dueInDate+'&invoiceCurrency='+invoiceCurrency+'&documentType='+documentType+'&postingId='+postingId+'&totalOpenAmount='+totalOpenAmount+'&baselineCreateDate='+baselineCreateDate+'&custPaymentTerms='+custPaymentTerms+'&invoiceId='+invoiceId)
          .then(res => res.json())
          .then(result => setMess(result));
    handleClose();//close the close modal
  }
  

  
  return (
    <div >
      <div>
        <Dialog 
          open={open}
          onClose={handleClose}
          aria-labelledby="alert-dialog-title"
          aria-describedby="alert-dialog-description"
          maxWidth = "lg"
         //fullWidth
        >
          <DialogTitle id="alert-dialog-title" className='modalbackground' >
            <div style={{color : 'white'}}>
              {"ADD"}
            </div>
           
           
          </DialogTitle>
          <DialogContent className='modalbackground'>
          <div>
              <TextField
              label= "Business Code"
              onChange = {(event) =>{setbusinessCode(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              required
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Customer Number"
              onChange = {(event) =>{setcustNumber(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              

         
 

              <TextField
                onChange= {(event) =>{setclearDate(event.target.value)}}
                id="outlined-size-small"
                label="clear date"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={clearDate}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>

              &emsp;
              
              <TextField
              label= "Business Year"
              onChange = {(event) =>{setbuisnessYear(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
          </div>
          <br/>
          <br/>
          <div>
              <TextField
              label= "Document Id"
              onChange = {(event) =>{setdocId(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)",width: '7cm', borderRadius:'5px'}}
                           
              size="small"
              />
              &emsp;

                       
              <TextField
                onChange= {(event) =>{setpostingDate(event.target.value)}}
                id="outlined-size-small"
                label="Posting Date"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={postingDate}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>


              &emsp;



              <TextField
                onChange= {(event) =>{setdocumentCreateDate(event.target.value)}}
                id="outlined-size-small"
                label="Document Create Date"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={documentCreateDate}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
           

              &emsp;



         



              <TextField
                onChange= {(event) =>{setdueInDate(event.target.value)}}
                id="outlined-size-small"
                label="Due Date"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={dueInDate}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>
              
                         
              
          </div>
          <br/>
          <br/>
          <div>
              <TextField
              label= "Invoice Currency"
              onChange = {(event) =>{setinvoiceCurrency(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Document Type"
              onChange = {(event) =>{setdocumentType(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Posting Id"
              onChange = {(event) =>{setpostingId(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Total Open Amount"
              onChange = {(event) =>{settotalOpenAmount(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
          </div>
          <br/>
          <br/>
          <div>
          <TextField
                onChange= {(event) =>{setbaselineCreateDate(event.target.value)}}
                id="outlined-size-small"
                label="Baseline Create Date"
                type="date"
                variant='filled' 
                format={'DD/MM/YYYY'}
                value={baselineCreateDate}
                defaultValue="2011-04-02"
                style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
                size="small"
             
                InputLabelProps={{
                  shrink: true
                }}

/>



             
              &emsp;
              
              <TextField
              label= "Customer Payment Terms"
              onChange = {(event) =>{setcustPaymentTerms(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Invoice Id"
              onChange = {(event) =>{setinvoiceId(event.target.value)}}
              id="outlined-size-small"
              variant='filled'
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
            
          </div>
          <br/>


          
          </DialogContent>
          <DialogActions className='modalbackground' >

            <Button onClick={handleAdd} style={{color : 'white', width: '15cm', borderRadius:'5px'}} >ADD</Button>
            <Button onClick={handleClose} autoFocus style={{color : 'white', width: '15cm', borderRadius:'5px'}}>
              CANCEL
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    
    </div>
  );
  
}