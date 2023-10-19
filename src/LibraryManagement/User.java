package LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String id;
    private List<Book> borrowedBooks;
    private int nextId = 1;
    private List<User> users = new ArrayList<>();
    
    public User(String name,String id) {
        this.name = name;
        this.id = id;
        borrowedBooks = new ArrayList<>();
    }

    public void registerUser(String name,String id) {
        String formattedId = String.format("%d", nextId);
        User user = new User(name, formattedId);
        users.add(user);
        nextId++;
    }

    public void borrowBook() {
        
    }
}
