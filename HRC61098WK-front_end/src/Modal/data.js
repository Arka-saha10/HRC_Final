import React from "react";
import axios from "axios";

export const BarChartData = async(data) =>{
    console.log("in data1",data);
    let url="http://localhost:8080/HRC61098WK-back_end/AnalyticsView?"+`&clear_date1=${data.clear_date1}&clear_date2=${data.clear_date2}&due_in_date1=${data.due_in_date1}&due_in_date2=${data.due_in_date2}&baseline_create_date1=${data.baseline_create_date1}&baseline_create_date2=${data.baseline_create_date2}&invoice_currency=${data.invoice_currency}`;
    console.log("in data url",url);
    let response = await axios.get(url);
    console.log("in data response",response)
    return response;

}

export const PieChartData = async(data) =>{
    console.log("in data1",data);
    let url="http://localhost:8080/HRC61098WK-back_end/PieData?"+`&clear_date1=${data.clear_date1}&clear_date2=${data.clear_date2}&due_in_date1=${data.due_in_date1}&due_in_date2=${data.due_in_date2}&baseline_create_date1=${data.baseline_create_date1}&baseline_create_date2=${data.baseline_create_date2}&invoice_currency=${data.invoice_currency}`;
    console.log("in data url",url);
    let response = await axios.get(url);
    console.log("in data response pie",response)
    return response;
}