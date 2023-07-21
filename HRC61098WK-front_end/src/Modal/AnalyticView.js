import React, { useState } from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import Dialog from "@mui/material/Dialog";

import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import { Typography, TextField } from "@mui/material";
import AnalyticsModal from "./AnalyticsModal";
import classes from "../Components/MainTable.module.css";
import BasicDatePicker from './datePicker';

export default function CreateAnalyticModal() {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => {
    setRow({
      clear_date1: null,
      clear_date2: null,
      due_in_date1: null,
      due_in_date2: null,
      invoice_currency: null,
      baseline_create_date1: null,
      baseline_create_date2: null,
    });
    setOpen(false);
  };

  const [row, setRow] = React.useState({
    clear_date1: null,
    clear_date2: null,
    due_in_date1: null,
    due_in_date2: null,
    invoice_currency: null,
    baseline_create_date1: null,
    baseline_create_date2: null,
  });

  const changeHandler = async (e) => {
    const { name, value } = e.target;
    setRow({ ...row, [name]: value });
  };

  const dateHandler = async (e) => {
    console.log(e);
    const { name, value } = e;
    setRow({ ...row, [name]: value });
  };

  return (
    <>
      <Button
        style={{ color: "white", height: "2.8rem", width: "13rem" }}
        onClick={handleOpen}
      >
        ANALYTICS VIEW
      </Button>
      <div className="modalbackground">
        <div>
          <Dialog
            open={open}
            onClose={handleClose}
            aria-labelledby="alert-dialog-title"
            aria-describedby="alert-dialog-description"
            maxWidth="lg"
          >
            <DialogTitle id="alert-dialog-title" className="modalbackground">
              <div style={{ color: "white" }}>{"Analytics View"}</div>
            </DialogTitle>
            <DialogContent className="modalbackground">
              <br />
              <br />
              <br />
              <br />

              <div className={classes.analyticdiv}>
                <div className={classes.analyticsview}>
                  <div className={classes.analyticdiv}>
                    <Typography color="common.white">Clear Date</Typography>

                    <BasicDatePicker variant="filled" name= "clear_date1" value={row.clear_date1} onChanged={dateHandler} />
                    <br/>
                    <BasicDatePicker variant="filled" name= "clear_date2" value={row.clear_date2} onChanged={dateHandler} />
                  </div>
                  &emsp; &emsp; &emsp;
                  <div className={classes.analyticdiv}>
                    <Typography color="common.white">Due Date</Typography>
                    <BasicDatePicker variant="filled" name= "due_in_date1" value={row.due_in_date1} onChanged={dateHandler} />
                   <br/>
                    <BasicDatePicker variant="filled" name= "due_in_date2" value={row.due_in_date2} onChanged={dateHandler} />
                  </div>
                </div>
                <br />
                <br />
                <br />
                <div className={classes.analyticsview}>
                  <div className={classes.analyticdiv}>
                    <Typography color="common.white">
                      Baseline Create Date
                    </Typography>
                    <BasicDatePicker variant="filled" name= "baseline_create_date1"  value={row.baseline_create_date1} onChanged={dateHandler} />
                    <br/>
                    <BasicDatePicker variant="filled" name= "baseline_create_date2" value={row.baseline_create_date2} onChanged={dateHandler} />



                   </div>
                  &emsp; &emsp; &emsp;
                  <div>
                    <div className={classes.analyticdiv}>
                      <Typography color="common.white">
                        Invoice Currency
                      </Typography>
                      <TextField
                        label="Invoice Currency"
                        name="invoice_currency"
                        value={row.invoice_currency}
                        onChange={changeHandler}
                        id="outlined-size-small"
                        variant="filled"
                        style={{
                          background: "rgb(232, 241, 250)",
                          width: "7cm",
                          borderRadius: "5px",
                        }}
                        size="small"
                      />
                    </div>
                  </div>
                </div>
              </div>
            </DialogContent>
            <DialogActions className="modalbackground">
              <AnalyticsModal data={row} />

              <Button
                color="inherit"
                onClick={handleClose}
                autoFocus
                style={{ color: "white", width: "8cm", borderRadius: "5px" }}
              >
                CANCEL
              </Button>
            </DialogActions>
          </Dialog>
        </div>
      </div>
    </>
  );
}