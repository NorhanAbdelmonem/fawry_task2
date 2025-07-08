package org.example.taskk.books;

import org.example.taskk.services.ShippingService;

public class PaperBook extends Book implements ItemForSale {
private int stock;

    public PaperBook(String isbn, String title, int year, int publishYear,
                     double price, String author, int stock) {
        super(isbn, title, year, publishYear, price, author);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
}
public void reduceStock(int quantity) {
       if(quantity>stock)
           throw new IllegalArgumentException(" This quantity is greater than stock ");

        stock-=quantity;
}

    @Override
    public double buy(int quantity, String email, String address) throws Exception {

        reduceStock(quantity);

        ShippingService.sent(address);
        return  quantity * price;


    }

    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void printInfo() {
        System.out.println(" PaperBook :  " + title + " by " + author + " ("+publishYear+") "+" Price :"+price);
    }
}
