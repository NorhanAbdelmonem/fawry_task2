package org.example.taskk.inventory;

import org.example.taskk.books.ItemForSale;
import org.example.taskk.books.Book;

import java.util.*;

public class Inventory {

    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println(" We added " + book.getTitle());
    }

    public void removeOutdatedBooks(int currentYear, int maxYears) {
        books.entrySet().removeIf(entry -> {
            Book book = entry.getValue();
            boolean outdated = book.isOutdated(currentYear, maxYears);
            if (outdated) {
                System.out.println("We removed " + book.getTitle());
            }
            return outdated;
        });
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = books.get(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (!(book instanceof ItemForSale)) {
            throw new IllegalArgumentException("This book is not for sale.");
        }

        ItemForSale itemForSale = (ItemForSale) book;
        return itemForSale.buy(quantity, email, address);
    }

    public void listAllBooks() {
        for (Book bookk : books.values()) {
            bookk.printInfo();
        }
    }
}
