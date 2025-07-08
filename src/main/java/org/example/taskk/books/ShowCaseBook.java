package org.example.taskk.books;

public class ShowCaseBook extends Book  {
    public ShowCaseBook(String isbn, String title, int year, int publishYear, double price, String author) {
        super(isbn, title, year, publishYear, price, author);
    }


    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public void printInfo() {
        System.out.println(
                " Showcase Book: " + title + " by " + author + " (" + publishYear + ")");
    }
}
