package StudentGradeTracker;

public class Student {

    private String name;
    private String Id;

    // Constructor
    public Student(String name, String Id) {
        this.name = name;
        this.Id = Id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return Id;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName;
    }

    public void setId(String newId) {
        this.Id = newId;
    }
    
}
