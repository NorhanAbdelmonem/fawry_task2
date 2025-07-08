package org.example.taskk.books;

public abstract class Book {
    public String isbn;
    public String title;
    public int year;
    public int publishYear;
    public double price;
    public String author;

    public Book(String isbn, String title, int year, int publishYear, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.publishYear = publishYear;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isOutdated(int currentYear, int maxYears) {
        return (currentYear - publishYear) > maxYears;
    }

    public abstract boolean isForSale();
    public abstract  void  printInfo();
}
