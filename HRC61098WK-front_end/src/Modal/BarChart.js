import React from "react";
import { Bar } from "react-chartjs-2";
import {chart as chartJS} from "chart.js/auto";
import Button from '@mui/material/Button';

export default function BarChart(props){ 
    return (
        <Bar data={props.chartData}/>
    );

}