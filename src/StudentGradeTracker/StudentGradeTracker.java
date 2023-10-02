package StudentGradeTracker;

import java.util.Scanner;
import java.util.List;

public class StudentGradeTracker {

    public static void main(String[] args) {
        
        GradeTracker tracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayMenu();

            int option = scanner.nextInt();
            scanner.nextLine();
            String Id;
            //double grade;

            switch(option) {
                case 1:
                    System.out.println("Enter the student's name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the student's ID number:");
                    Id = scanner.nextLine();
                    tracker.addStudent(new Student(name, Id));
                    break;
                case 2:
                    System.out.println("Enter the ID number of the student you wish to remove:");
                    Id = scanner.nextLine();
                    tracker.removeStudentById(Id);
                    break;
                case 3:
                    System.out.println("Student List");
                    tracker.displayStudents();
                    break;
                case 4:
                    System.out.println("Type the ID number of the student:");
                    Id = scanner.nextLine();
                    System.out.println("Type the subject of the grade:");
                    String subject = scanner.nextLine();
                    System.out.println("Type the grade:");
                    double grade = Double.parseDouble(scanner.nextLine());
                    Grade newGrade = new Grade(Id,subject,grade);
                    tracker.addGrade(newGrade);
                    break;
                case 5:
                    System.out.println("Enter student ID:");
                    Id = scanner.nextLine();
                    List<Grade> matchingGrades = tracker.getGradesById(Id);
                    
                    if (matchingGrades.isEmpty()) {
                        System.out.println("No matching grades found for the student ID.");
                    } else {
                        System.out.println("Matching grades:");
                        for (int i = 0; i < matchingGrades.size(); i++) {
                            Grade grade2 = matchingGrades.get(i);
                            System.out.println((i + 1) + ". Subject: " + grade2.getSubject() + ", Grade: " + grade2.getGrade());
                        }
                    
                        System.out.println("Enter the number of the grade you wish to remove:");
                        int choice = Integer.parseInt(scanner.nextLine());
                    
                        if (choice >= 1 && choice <= matchingGrades.size()) {
                            Grade gradeToRemove = matchingGrades.get(choice - 1);
                            matchingGrades.remove(gradeToRemove);
                            System.out.println("Grade removed.");
                        } else {
                            System.out.println("Invalid choice. No grade removed.");
                        }
                    }
                    break;
                case 6:
                    tracker.displayGrades();
                    break;
                case 7:
                    System.out.println("Enter student ID to calculate average grade:");
                    Id = scanner.nextLine();
                    double avg = tracker.calcAvg(Id);
                    System.out.println("The average grade for student "+ Id +" is: " + avg);
                    break;
                case 8:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose a valid option.");

            }
        }
    }

    private static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. View students");
        System.out.println("4. Add grade");
        System.out.println("5. Remove grade");
        System.out.println("6. View grades");
        System.out.println("7. Display student average grade");
        System.out.println("8. Exit");
    }
    
}
