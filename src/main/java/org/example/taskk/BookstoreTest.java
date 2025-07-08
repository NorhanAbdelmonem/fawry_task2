package org.example.taskk;

import org.example.taskk.books.Book;
import org.example.taskk.books.EBook;
import org.example.taskk.books.PaperBook;
import org.example.taskk.books.ShowCaseBook;
import org.example.taskk.inventory.Inventory;

public class BookstoreTest {

    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();

        System.out.println("------- Test adding books to inventory --------");

        Book paperBook = new PaperBook("ISBN1", "Java Programming",
                5, 2018, 300, "John Carnell", 100);
        Book eBook = new EBook("ISBN2", "Spring in Action",
                3, 2021, 400.0, "Craig Walls", "PDF");
        Book showcaseBook = new ShowCaseBook("ISBN3", "Spring Start Here",
                4, 2005, 600, "Craig Walls");

        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(showcaseBook);

        System.out.println("\n------- All books in inventory-------- ");
        inventory.listAllBooks();

        System.out.println("\n---------Test removing outdated Books-------");
        inventory.removeOutdatedBooks(2025, 10);

        System.out.println("\n--------  after removing ---------");
        inventory.listAllBooks();

        System.out.println("\n--------  Buing ---------");
        double paperPaid = inventory.buyBook("ISBN1", 2, " norr@example.com", "Menof");
        System.out.println("Paid amount for Paper Book: " + paperPaid + " EGP");

        double eBookPaid = inventory.buyBook("ISBN2", 1, " nor@example.com", "Shebin");
        System.out.println("Paid amount for E-Book: " + eBookPaid + " EGP");

        try {
            inventory.buyBook("ISBN3", 1, " noor@example.com", "El-Menoufia");
        } catch (IllegalArgumentException ex) {
            System.out.println( ex.getMessage());
        }

    }
}
