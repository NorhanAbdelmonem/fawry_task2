package org.example.taskk.books;

import org.example.taskk.services.MailService;

public class EBook extends Book implements ItemForSale {
   public String fileType;

    public EBook(String isbn, String title, int year,
                 int publishYear, double price, String author, String fileType) {

        super(isbn, title, year, publishYear, price, author);
        this.fileType = fileType;
    }

    @Override
    public boolean isForSale() {
        return true;
    }


    @Override
    public double buy(int quantity, String email, String address) throws Exception {
        //لو اشترينا نفس الكتاب بعدد اكتر من 1 هيرجع في الايميل نفس الكتاب  مبعوت كذا مرة
        if (quantity > 1) {
            throw new IllegalArgumentException("Err you will receive the same email many times");
        }
        MailService.sent(email);
        return price;

    }

    @Override
    public void printInfo() {
        System.out.println(" EBook: " + title + " by " + author + " (" + publishYear + ") "+ fileType + " Price :" + price);
    }
}
