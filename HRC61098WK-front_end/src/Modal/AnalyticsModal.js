import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import { UserData } from "./data";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogContentText from "@mui/material/DialogContentText";
import DialogTitle from "@mui/material/DialogTitle";
import BarChart from "./BarChart";
import PieChart from "./PieChart";
import { BarChartData, PieChartData } from "./data";
import { Dialog } from "@mui/material";

export default function AnalyticsModal(props) {
  // console.log("in modal",props.data);
  const [barRow, setBarRow] = React.useState([]);
  console.log("in row", barRow);
  const [pieRow, setPieRow] = React.useState([]);
  console.log("in row.1", pieRow);

  // console.
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => {
    setOpen(false);
  };
  const barData = {
    labels: barRow.map((data) => data.business_name),
    datasets: [
      {
        label: "No of customers",
        data: barRow.map((data) => data.cust_count),
        backgroundColor: ["#ffb0c1"],
        borderColor: "black",
        borderWidth: 2,
      },
      {
        label: "Total open amount",
        data: barRow.map((data) => data.total_amount),
        backgroundColor: ["#99d0f5"],
        borderColor: "black",
        borderWidth: 2,
      },
    ],
  };

  const pieData = {
    labels: pieRow.map((data) => data.invoice_currency),
    datasets: [
      {
        label: "Invoice Currency",
        data: pieRow.map((data) => data.count_currency),
        backgroundColor: ["#ffb0c1", "#99d0f5"],
        borderColor: "black",
        borderWidth: 2,
      },
    ],
  };

  const submitHandler = async (e) => {
    e.preventDefault();
    console.log("in submit1", props.data);
    let barResponse = await BarChartData(props.data);
    let pieResponse = await PieChartData(props.data); //change
    console.log("in submit2.0", barResponse.data.users);
    console.log("in submit2.1", pieResponse.data.users);
    setBarRow(barResponse.data.users);
    setPieRow(pieResponse.data.users);
    handleOpen();
  };

  return (
    <div>
      <Button
        variant="outlined"
        color="inherit"
        style={{ color: "white", width: "8cm", borderRadius: "5px" }}
        onClick={submitHandler}
      >
        SUBMIT
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
            <DialogContent className="modalbackground1">
              <div style={{ width: 700 }}>
                <BarChart chartData={barData} />
              </div>
              <div style={{ width: 700 }}>
                <PieChart chartData={pieData} />
              </div>
              <div className="btn">
                <Button
                  style={{ color: "black" }}
                  className="add"
                  variant="outlined"
                  onClick={handleClose}
                >
                  CLOSE
                </Button>
              </div>
            </DialogContent>
          </Dialog>
        </div>
      </div>
    </div>
  );
}