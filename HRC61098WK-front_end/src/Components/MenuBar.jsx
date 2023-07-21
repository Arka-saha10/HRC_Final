import React from 'react'
import Button from "@mui/material/Button";
import ButtonGroup from "@mui/material/ButtonGroup";
import TextField from '@mui/material/TextField';
import classes from './MenuBar.module.css';
import FormDialog from '../Modal/addmod'
import Formedit from '../Modal/editmod'
import swal from 'sweetalert';
import Formedel from '../Modal/deletemod';
import Formeadvance from '../Modal/advancedSearchmod';
import RefreshIcon from '@mui/icons-material/Refresh';
import axios from "axios";
import CreateAnalyticModal from "../Modal/AnalyticView";


function MenuBar({rowSelect, setRowSelect,rows, setRows}) {
  const [open, setOpen] = React.useState(false);
  const [openEdit, setOpenEdit] = React.useState(false);
  const [openDelete, setOpenDelete] = React.useState(false);
  const [openAdvance, setOpenAdvance] = React.useState(false);
  const [openAnalytics, setopenAnalytics] = React.useState(false);
  const [docId, setDocId] = React.useState([]);

  //Response to the Refresh Button
  function handleRef(){
    window.location.reload();
  }

  //To Search rows using Customer Number. Enter key sensitive
  const handlesearch = (event) => {
    if (event.key === 'Enter') {
      console.log(typeof event.target.value);
      fetch('http://localhost:8080/HRC61098WK-back_end/search?custNumber='+event.target.value)
          .then(res => res.json())
          .then(result => {setRows(result);console.log('hello',result)});
    }

  }

  const handleAnalyticsOpen = () => {
    setopenAnalytics(true);
   
  };

  const handleAnalyticsClose = () => {
    setopenAnalytics(false);
  };

  const handleClickOpen = () => {
    setOpen(true);
    
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleClickeditOpen = () => {
    
    if(rowSelect.length===1){
        //Edit response when only 1 Row is selected
        setOpenEdit(true);
    }
    if(rowSelect.length===0){
      //Edit when No rows are selected 
      swal({
        
        title: "PLEASE SELECT A ROW!!",
        icon: "warning",
      
      });
    }
      else if(rowSelect.length > 1){
        //Edit when more than one rows are selected
      swal({
        
        title: "KINDLY SELECT ANY ONE ROW!!",
        icon: "warning",
      
      });
    }
    
  };

  const handleeditClose = () => {
    setOpenEdit(false);
  };

  const handleClickeddelOpen = () => {
    
    if(rowSelect.length===0){
      //
      swal({
        
        title: "KINDLY SELECT THE ROW YOU WANT TO DELETE!!",
        icon: "warning",
      
      });
    }
    else{
     
      setOpenDelete(true);
    }
    
  };

  const handledelClose = () => {
    setOpenDelete(false);
  };

  const handleClickeadvOpen = () => {
    setOpenAdvance(true);
   
  };

  const handleadvClose = () => {
    setOpenAdvance(false);
  };

  const handlePredict = async () => {
    let l;
    if(rowSelect.length===0){
      //if no row(s) are selected, Exception ocuurs
      swal({
        
        title: "SELECT ROW[S] TO PREDICT !!",
        icon: "warning",
      
      });
    }
    else{

       l = String(rowSelect);
      console.log(l);
      console.log("len",l.length);
      console.log(typeof l);

      //fetch the docid of the selected rows for prediction
      await fetch('http://localhost:8080/HRC61098WK-back_end/predict?slNo='+l)
          .then(res => res.json())
          .then(result => {predict(result,l)});
 
          
          
    }
    

    
}

  async function predict(docId,slNo){
    var docArray=[];
    console.log(docId);
    docId.forEach(e=>docArray.push(e));

    //To fetch the aging bucket from integration.py
    let response = await axios.post("http://127.0.0.1:5000/get_prediction",{data: docId},{headers: {'Content-Type': 'application/json'}});
    
    let i;
    for(i=0;i<docId.length;i++) {
      //var a=response.data[i].doc_id.length;
      var check=parseInt(response.data[i].doc_id);
      console.log(typeof docArray);
      console.log("abc",docId,check);
      //updating the aging bucket in the table
      if(docArray.includes(check)){
      let data = "agingBucket="+response.data[i].aging_bucket+"&docId="+check;
        fetch("http://localhost:8080/HRC61098WK-back_end/EditAgingBucket?"+data)
        .then(res => res.json())
        .then(result => console.log("abc",result));
      }
      window.location.reload();
  }
}

  return (
    <div className={classes.header}>
      <ButtonGroup aria-label="outlined  button group" >
        <Button variant='contained' style={{color : 'white', width : '5cm',borderRadius: "5px"}} onClick={handlePredict}>PREDICT</Button>
        <CreateAnalyticModal
          open={openAnalytics}
          handleClose={handleAnalyticsClose}
        />
        <Button style={{color : 'white', width : '5cm',borderRadius: "5px"}} onClick={handleClickeadvOpen}>ADVANCE SEARCH</Button>
        <Formeadvance  open = {openAdvance} handleClose={handleadvClose} rows = {rows} setRows = {setRows}/>
        <Button style={{color : 'white', width : '2cm',borderRadius: "5px"}} onClick={handleRef}><RefreshIcon/></Button>
        </ButtonGroup>
       
        <TextField
          label= "Search Customer Id"
          id="outlined-size-small"
          style={{background: "rgb(232, 241, 250)" ,borderRadius: "5px"}}
          size="small"
          variant='filled'
          height = '40cm'
          onKeyDown = {handlesearch}
      
        />
        
        <ButtonGroup aria-label="outlined  button group" >
        
          <Button style={{color : 'white', width : '5cm',borderRadius: "5px"}} onClick={handleClickOpen} >ADD</Button>
          <FormDialog open = {open} handleClose={handleClose} />
        
          <Button style={{color : 'white', width : '5cm'}} onClick={handleClickeditOpen}>EDIT</Button>
          <Formedit rowSelect = {rowSelect} setRowSelect = {setRowSelect} open = {openEdit} handleClose={handleeditClose}/>
        
        <Button style={{color : 'white', width : '5cm',borderRadius: "5px"}} onClick={handleClickeddelOpen}>DELETE</Button>
        <Formedel rowSelect = {rowSelect} setRowSelect = {setRowSelect} open = {openDelete} handleClose={handledelClose} />
      </ButtonGroup>
     
    </div>
   
  )
}

export default MenuBar;