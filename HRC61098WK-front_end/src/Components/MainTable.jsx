import { DataGrid } from '@mui/x-data-grid';
import React, { useState, useEffect } from 'react';
import Button from "@mui/material/Button";
import ButtonGroup from "@mui/material/ButtonGroup";
import TextField from '@mui/material/TextField';
import classes from './MenuBar.module.css';
import MenuBar from './MenuBar';


//Columns Shown in the main Table 
const columns = [
  { field: 'slNo', headerName: 'SL No' },
  { field: 'businessCode', headerName: 'Business Code', width: 130 },
  { field: 'custNumber', headerName: 'Customer Number', width: 130 },
  { field: 'clearDate', headerName: 'Clear Date', width: 130 },
  { field: 'buisnessYear', headerName: 'Business Year', width: 130 },
  { field: 'docId', headerName: 'Document ID', width: 130 },
  { field: 'postingDate', headerName: 'Posting Date', width: 130 },
  { field: 'documentCreateDate', headerName: 'Document Create Date', width: 160 },
  { field: 'dueInDate', headerName: 'Due Date', width: 130 },
  { field: 'invoiceCurrency', headerName: 'Invoice Currency', width: 130 },
  { field: 'documentType', headerName: 'Document Type', width: 130 },
  { field: 'postingId', headerName: 'Posting ID', width: 130 },
  { field: 'totalOpenAmount', headerName: 'Total Open Amount', width: 150 },
  { field: 'baselineCreateDate', headerName: 'Baseline Create Date', width: 160 },
  { field: 'custPaymentTerms', headerName: 'Customer Payment Terms', width: 180 },
  { field: 'invoiceId', headerName: 'Invoice Id', width: 130 },
  { field: 'agingBucket', headerName: 'Aging Bucket', width: 130 },
    
  ];


function MainTable() {
  
  const [rows, setRows] = useState([]);
  const [rowCount,setRowCount] = useState([]);
  const [pageSize, setPageSize] = React.useState(10);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);
  var [rowSelect,setRowSelect ] = useState([]);
  const [page, setPage] = React.useState(2);

  //To fetch the initial page after reload using initial pagesize=10
  useEffect(() => {
    fetch('http://localhost:8080/HRC61098WK-back_end/fetch?page=1&size='+pageSize)
      .then(res => res.json())
      .then(result => setRows(result));
  }, []);

// To fetch the total number of datas in the dataset
  useEffect(() => {
    fetch('http://localhost:8080/HRC61098WK-back_end/fetchCount?')
      .then(res => res.json())
      .then(result => setRowCount(result));
  }, []);

  //To fetch the next page using dynamic pagination
  function LoadPage(page,pageSize){
   
      fetch('http://localhost:8080/HRC61098WK-back_end/fetch?page='+page+'&size='+pageSize)
        .then(res => res.json())
        .then(result => setRows(result));
    
  
  }
  

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  return (
    <div style={{ height: 660, width: '100%', background: "#273D4A" }}>
      <br/>
      
      <MenuBar rowSelect = {rowSelect} setRowSelect={setRowSelect} rows = {rows} setRows = {setRows}/> 

    
        
        <DataGrid
          component="div"
          rows={rows}
          initialState = {{
            pagination:{page: 0}
          }}
          columns={columns}
          rowsPerPage={rowsPerPage}
          onRowsPerPageChange={handleChangeRowsPerPage}
          pageSize={pageSize}
          onPageSizeChange={(newPageSize) => {setPageSize(newPageSize);LoadPage(page-1,newPageSize)}}
          rowsPerPageOptions={[5,10,20,30,50]}
          checkboxSelection
          onSelectionModelChange={itm =>setRowSelect(itm)}
          style={{ color: "white" }} 
          sx={{ m : 2 }}
          paginationMode = 'server'
          rowCount = {rowCount}
          onPageChange = {(page)=>{
            LoadPage(page+1,pageSize);
            
          }}/>

   
        
      </div>
    
  );
}

export default MainTable;