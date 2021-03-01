package com.gtech.foodipspartner.Models;

public class CreateNewOreder {

    String Billno, Amount, CustomerName, CustomerNumber, DateTime;

    public CreateNewOreder(String billno, String amount, String customerName, String customerNumber, String dateTime) {
        Billno = billno;
        Amount = amount;
        CustomerName = customerName;
        CustomerNumber = customerNumber;
        DateTime = dateTime;
    }

    public String getBillno() {
        return Billno;
    }

    public void setBillno(String billno) {
        Billno = billno;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String amount) {
        Amount = amount;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}
