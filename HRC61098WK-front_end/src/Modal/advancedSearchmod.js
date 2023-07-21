import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import TextField from '@mui/material/TextField';

export default function FormadvSearch({open,handleClose,rows,setRows}) {
  
  function handleSearch(){
    console.log(documentId);
    console.log(invoiceId);
    console.log(custNumber);
    console.log(businessYr);
    var s = "";
    var flag = false;
    if(documentId != null){
      //handling the Document ID NULL exception
      if(flag){
        s = s + " and doc_id=" + documentId;

      }else{
   s = s + "doc_id=" + documentId;
        flag = true;
     }
  }

    if(invoiceId != null){
      //handling the Invoice ID NULL exception
      if(flag){
        s = s + " and invoice_id=" + invoiceId;
      }else{
   s = s + "invoice_id=" + invoiceId;
   flag = true;
      } 
    }

      if(custNumber != null){
        //handling the customer number NULL exception
        if(flag){
          s = s + " and cust_number=" + custNumber;
        }else{
     s = s + "cust_number=" + custNumber;
     flag = true;
        } 
}
if(businessYr != null){
  //handling the business year NULL exception
  if(flag){
    s = s + " and buisness_year=" + businessYr;

  }else{
    s = s + "buisness_year=" + businessYr;
    flag = true;
 }
}

//To fetch the search result by sending the query through URL
fetch('http://localhost:8080/HRC61098WK-back_end/advanceSearch?page=1&size=10&query='+s)
        .then(res => res.json())
        .then(result => setRows(result));
console.log (s);
handleClose();
}


  
  const [documentId, setdocumentId] = React.useState();
  const [invoiceId, setinvoiceId] = React.useState();
  const [custNumber, setcusNumber] = React.useState();
  const [businessYr, setbusinessYr] = React.useState();
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
              {"Advance Search"}
            </div>
          </DialogTitle>
          <DialogContent className='modalbackground' >
          <div>
              
              
              <TextField
              label= "Document ID"
              onChange = {(event) =>{setdocumentId(event.target.value)}}
              variant='filled'
              id="docId"
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Invoice Id"
              onChange = {(event) =>{setinvoiceId(event.target.value)}}
              variant='filled'
              id="outlined-size-small"
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
          </div>
          <br/>
          <br/>
          <div>
          <TextField
              label= "Customer Number"
              onChange = {(event) =>{setcusNumber(event.target.value)}}
              variant='filled'
              id="outlined-size-small"
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              
              size="small"
              />
              &emsp;
              
              <TextField
              label= "Business Year"
              onChange = {(event) =>{setbusinessYr(event.target.value)}}
              variant='filled'
              id="outlined-size-small"
              style={{background: "rgb(232, 241, 250)", width: '7cm', borderRadius:'5px'}}
              size="small"
              />
          </div>
          <br/>
        
          
          </DialogContent>
          <DialogActions className='modalbackground' >
            <Button color = 'inherit'  onClick={handleSearch} style={{color : 'white', width: '8cm', borderRadius:'5px'}}>SEARCH</Button>
            <Button color = 'inherit' onClick={handleClose} autoFocus style={{color : 'white', width: '8cm', borderRadius:'5px'}}>
              CANCEL
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    
    </div>
  );
  
}
