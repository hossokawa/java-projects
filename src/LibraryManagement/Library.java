package LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    private int nextId = 1;

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
                System.out.println("Insert the number correspoding to your desired option.");
        }
    }
   
    public void viewBooks() {
        System.out.println("Here are all books in our inventory:");
        System.out.println();
        for(Book book : books) {
            System.out.println(book.toString());
        }
    }

    public Book getBookByTitle(String title) {
        for(Book book : books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void registerUser(String name) {
        if(name == null || name.isEmpty()) {
            System.out.println("Error: user name cannot be empty.");
            return;
        }
        String formattedId = generateNextUserId();
        User user = new User(name, formattedId);
        if(users.add(user)) {
            System.out.println("User registration successful. User ID:" + formattedId);
            System.out.println();
            incrementNextUserId();
        } else {
            System.out.println("Error: user registration failed. Try again.");
            System.out.println();
        }
        
    }

    public User getUserById(String id) {
        for(User user : users) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void getBorrowedBooksById(Library library,String id) {
        User user = getUserById(id);
        if(user != null) {
            System.out.println(user.getName()+"'s borrowed books:");
            user.viewBorrowedBooks(library);
        } else {
            System.out.println("User with ID "+id+" couldn't be found.");
            System.out.println();
        }
    }

    public String getNameById(String id) {
        User user = getUserById(id);
        if(user != null) {
            return user.getName();
        } else {
            return "User not found.";
        }
    }

    private String generateNextUserId() {
        return String.format("%d", nextId);
    }

    private void incrementNextUserId() {
        nextId++;
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
