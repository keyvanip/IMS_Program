package com.parsakeyvani;

import java.util.Random;


public class Products {
    private String productName;
    private int ID;
    private double price;
    private int stock;
    private int value;
    private final int UPPERBOUND = 50000;
    private final int LOWERBOUND = 10000;
    private int numSold = 0;
    private double revenue = 0;

    public Products(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.ID = generate_ID();
        value = (int) ((int)stock*price);
    }

    private int generate_ID(){
        Random rand = new Random();
        int value = rand.nextInt((UPPERBOUND - LOWERBOUND +1))+ LOWERBOUND;
        return value;
    }

    public String getProductName() {
        return productName;
    }

    public int getId() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getValue() {
        return value;
    }

    public void resetValue() {
        value = (int) ((int)stock*price);
    }

    public int getNumSold() {
        return numSold;
    }

    public void setNumSold(int numSold) {
        this.numSold = numSold;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue() {
        revenue= numSold*price;
    }

    public String toString(){
        String toReturn = "\nID:"+getId()+"\t Product:"+getProductName()+"\t    Price:" +"$"+getPrice()+"\t   Stock:"+getStock()+" units"+"\tStock-Value:$"+getValue()+"   \tSold:"+getNumSold()+" units"+ "\tRevenue:$"+ getRevenue()+"\n";
        return toReturn;
    }

}
