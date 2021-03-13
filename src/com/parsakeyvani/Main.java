package com.parsakeyvani;

public class Main {

    public static void main(String[] args) {
	Products myProducts= new Products("Pencil", 2.33, 23);
	Products myProducts1= new Products("Binder", 4.33, 43);
	Products myProducts3= new Products("Pen", 4.33, 43);

	//System.out.println(myProducts);
	Store myStore = new Store();
	myStore.addProduct(myProducts.getId(),myProducts);
	myStore.addProduct(myProducts1.getId(),myProducts1);
	myStore.addProduct(myProducts3.getId(),myProducts3);
	myStore.modifyPrice(myProducts3.getId(), 1);
	myStore.sellProduct(myProducts3.getId(),15 );
	myStore.sellProduct(myProducts.getId(),20 );
	myStore.sellProduct(myProducts1.getId(),35 );
	myStore.addStock(myProducts.getId(),177 );

	System.out.println(myStore);
    }
}
