package StudentGradeTracker;

import java.util.ArrayList;
import java.util.List;

public class GradeTracker {

    private List<Student> students;
    private List<Grade> grades;

    public GradeTracker() {
        students = new ArrayList<>();
        grades = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void removeStudentById(String Id) {
        Student studentToRemove = getStudentById(Id);
        if(studentToRemove != null) {
            students.remove(studentToRemove);
            grades.removeIf(grade -> grade.getId().equals(Id)); // Removes grades associated with student
            System.out.println("Student and grades associated have been removed succesfully.");
        } else {
            System.out.println("No students matched the provided ID number.");
        }
    }
    /*
    public void removeGrade(String Id,double grade) {
        
    }
    */
    public void displayStudents() {
        for(Student student : students) {
            System.out.println("Student name: " + student.getName());
            System.out.println("Student ID:" + student.getId());
            System.out.println();
        }
    }

    public void displayGrades() {
        for(Grade grade : grades) {
            System.out.println("Student ID: " + grade.getId());
            System.out.println("Subject: " + grade.getSubject());
            System.out.println("Grade: "+ grade.getGrade());
            System.out.println();
        }
    }

    public double calcAvg(String Id) {
        double sum = 0.0;
        int n = 0;

        for(Grade grade : grades) {
            if (grade.getId().equals(Id)) {
                sum += grade.getGrade();
                n++;
            }
        }
        return n == 0 ? 0 : sum/n;
    }

    public List<Grade> getGradesById(String Id) {
        List<Grade> matchingGrades = new ArrayList<>();

        for(Grade grade : grades) {
            if(grade.getId().equals(Id)) {
                matchingGrades.add(grade);
            }
        }
        return matchingGrades;
    }

    private Student getStudentById(String Id) {
        for(Student student : students) {
            if(student.getId().equals(Id)) {
                return student;
            }
        }
        // If no matching ID was found
        return null;
    }
    
}
