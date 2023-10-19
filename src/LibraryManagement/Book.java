package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private String isbn;
    private boolean available;
    private List<User> borrowers = new ArrayList<>();

    public Book(String title,String author,String isbn,boolean available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    public void addBorrower(User user) {
        borrowers.add(user);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return  "Title: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nISBN: " + getIsbn() +
                "\nAvailable: " + isAvailable() + "\n";
    }

    public String borrowedBooksToString() {
        return  "Title: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nISBN: " + getIsbn() +"\n";
    }

}
