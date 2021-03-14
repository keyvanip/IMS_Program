package com.parsakeyvani;

import java.util.LinkedHashMap;


public class Store {
    private  LinkedHashMap<Integer, Products> store = new LinkedHashMap<Integer, Products>();


    public void addProduct(int ID, Products description){
        store.put(ID,description);

    }

    public void modifyPrice(int ID, double newPrice){
        if (store.containsKey(ID)){
            store.get(ID).setPrice(newPrice);
            store.get(ID).resetValue();
        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }

    public void modifyName(int ID, String newName){
        if (store.containsKey(ID)){
            store.get(ID).setProductName(newName);
        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }


    public void addStock(int ID, int Stocks){
        if (store.containsKey(ID)){
            store.get(ID).setStock(store.get(ID).getStock()+Stocks);
            store.get(ID).resetValue();
        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }

    public void resetStock(int ID, int newStock){
        if (store.containsKey(ID)){
            store.get(ID).setStock(newStock);
            store.get(ID).resetValue();
        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }

    public void removeProduct(int ID){
        if (store.containsKey(ID)){
            store.remove(ID);
        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }

    public void sellProduct(int ID, int quantityToSell){
        if (store.containsKey(ID)){
            int currentStock= store.get(ID).getStock();
            if(currentStock >= quantityToSell){
                store.get(ID).setStock(currentStock-quantityToSell);
                store.get(ID).resetValue();
                store.get(ID).setNumSold(quantityToSell);
                store.get(ID).setRevenue();
                System.out.println(quantityToSell + " units of " + store.get(ID).getProductName() + " was successfully sold!");

            }
            else{
                System.out.println("insufficient stock! Your transaction was unsuccessful!");
            }

        }
        else{
            throw new NullPointerException("No product was found with the given ID.");
        }
    }

    private double totalRevenue(){
        double totalRevenue = 0;
        for (int key: store.keySet()){
            totalRevenue += store.get(key).getRevenue();
        }
        return totalRevenue;
        }


    public String toString(){
        String toReturn= "############################################### INVENTORY DATA ###############################################\n";
        toReturn+= store.values()+"\n";
        toReturn+= "                                               Total Revenue:$"+ totalRevenue();
        return toReturn;
    }




}
