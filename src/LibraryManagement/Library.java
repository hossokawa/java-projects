package LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books;
    Scanner scanner = new Scanner(System.in);

    public void addBook(String title,String author,String isbn,boolean available) {
        available = true;
        Book book = new Book(title,author,isbn,available);
        books.add(book);
        System.out.println(title + " added successfully!");
        System.out.println();
    }
   
    public void delBook(String title) {
        Book bookToRemove = getBookByTitle(title);
        if(bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println(title + " removed successfuly.");
            System.out.println();
        } else {
            System.out.println("Couldn't find book titled" + title + ".");
            System.out.println();
        }
    }

    public void searchBook(String choice) {
        System.out.println("1. Search by title");
        System.out.println("2. Search by author");
        System.out.println("3. Cancel");
        switch(choice) {
            case "1":
                System.out.println("Enter book title:");
                String title = scanner.nextLine();
                Book bookToSearch = getBookByTitle(title);
                if(bookToSearch != null) {
                    System.out.println(bookToSearch);
                    System.out.println();
                } else {
                    System.out.println(title + "Could not be found");
                    System.out.println();
                }
                break;
            case "2":
                System.out.println("Enter author name:");
                String author = scanner.nextLine();
                System.out.println(getBookByAuthor(author));
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
   
    public void viewBooks() {
        System.out.println("Here are all books in our inventory:");
        System.out.println();
        System.out.println(books);
    }

    private Book getBookByTitle(String title) {
        for(Book book : books) {
            if(book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    private List<Book> getBookByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for(Book book : books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}
