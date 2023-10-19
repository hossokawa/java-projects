package LibraryManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
   
        while(true) {
            displayMenu();
            String option = scanner.nextLine();
            String title;
            String author;
    
            switch(option) {
                case "1":
                    System.out.println("Welcome! Please enter your name to be registered:");
                    String name = scanner.nextLine();
                    library.registerUser(name);
                    break;
                case "2":
                    System.out.println("Enter the book's title:");
                    title = scanner.nextLine();
                    System.out.println("Enter the book's author:");
                    author = scanner.nextLine();
                    System.out.println("Enter the book's ISBN:");
                    String isbn = scanner.nextLine();
                    library.addBook(title, author, isbn, false);
                    break;
                case "3":
                    System.out.println("Enter the title for the book to remove:");
                    title = scanner.nextLine();
                    library.delBook(title);
                    break;
                case "4":
                    System.out.println();
                    System.out.println("Search Options");
                    System.out.println("1. Search by title");
                    System.out.println("2. Search by author");
                    System.out.println("3. Return");
                    String choice = scanner.nextLine();
                    library.searchBook(choice);
                    break;
                case "5":
                    library.viewBooks();
                    break;
                case "6":
                    System.out.println("Please enter your registered user ID:");
                    String id = scanner.nextLine();
                    User user = library.getUserById(id);
                    if(user == null) {
                        System.out.println("Invalid user ID. Please use a registered ID.");
                        System.out.println();
                    } else {
                        UserMenu(library, id);
                        String userOption = scanner.nextLine();
                        switch (userOption) {
                            case "1":
                                System.out.println("Enter title for the book you're looking for:");
                                title = scanner.nextLine();
                                user.borrowBook(library, title);
                                break;
                            case "2":
                                System.out.println("Enter title of the book you want to return:");
                                title = scanner.nextLine();
                                user.returnBook(library, title);
                                break;
                            case "3":
                                user.viewBorrowedBooks(library);
                                break;
                            case "4":
                                break;
                            default:
                                System.out.println("Invalid choice. Please select a valid option.");
                                System.out.println();
                        }
                    }
                    break;
                case "7":
                    System.out.println("Exiting system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    System.out.println();
            }
        }
    
    }
    
    public static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Register user");
        System.out.println("2. Add book");
        System.out.println("3. Remove book");
        System.out.println("4. Search for a book");
        System.out.println("5. View book list");
        System.out.println("6. View user menu");
        System.out.println("7. Exit");
    }

    public static void UserMenu(Library library,String id) {
        System.out.println("Hello, " + library.getNameById(id) + "!");
        System.out.println("1. Borrow a book");
        System.out.println("2. Return a book");
        System.out.println("3. View borrowed books list");
        System.out.println("4. Return");
    }    
}
