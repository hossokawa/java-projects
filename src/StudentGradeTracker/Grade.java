package StudentGradeTracker;

public class Grade {

    private String Id;
    private String subject;
    private double grade;

    // Constructor
    public Grade(String Id,String subject, double grade) {
        this.Id = Id;
        this.subject = subject;
        this.grade = grade;
    }

    // Getters
    public String getId() {
        return Id;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }

    // Setters
    public void setSubject(String newSubject) {
        this.subject = newSubject;
    }

    public void setGrade(double newGrade) {
        this.grade = newGrade;
    }
    
}
