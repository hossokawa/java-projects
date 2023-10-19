package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String id;
    private List<Book> borrowedBooks;
    
    public User(String name,String id) {
        this.name = name;
        this.id = id;
        borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Library library,String title) {
        Book book = library.getBookByTitle(title);
        if(book != null) {
            if(book.isAvailable()) {
                borrowedBooks.add(book);
                book.setAvailable(false);
                System.out.println("Book borrowed successfully!");
                System.out.println();
            } else {
                System.out.println("Sorry, that book is currently unavailable.");
                System.out.println();
            }
       } else {
            System.out.println("Couldn't find a book titled '" + title + "'.");
            System.out.println();
       }
    }

    public void returnBook(Library library,String title) {
        List<Book> copy = new ArrayList<>(borrowedBooks);
        boolean bookFound = false;
        for(Book book : copy) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                borrowedBooks.remove(book);
                book.setAvailable(true);
                System.out.println("Book returned successfuly. Thank you for using our service!");
                System.out.println();
                bookFound = true;
                break;
            }
        }

        if(!bookFound) {
            System.out.println("Couldn't find a book title '"+title+"' in your borrowed books list.");
            System.out.println();
        }
    }

    public void viewBorrowedBooks(Library library) {
        for(Book book : borrowedBooks) {
            System.out.println(book.borrowedBooksToString());
        }
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
