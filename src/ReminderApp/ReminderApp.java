package ReminderApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ReminderApp {

    public static void main(String[] args) {
        
        Calendar calendar = new Calendar();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayMenu();

            int option = scanner.nextInt();
            scanner.nextLine();
            String id;

            switch(option) {
                case 1:
                    System.out.println("Enter title for your reminder:");
                    String title = scanner.nextLine();
                    System.out.println("Enter description for your reminder:");
                    String description = scanner.nextLine();
                    System.out.println("Enter date for your reminder:");
                    String inputDate = scanner.nextLine();
                    LocalDate parsedDate = calendar.parseDate(inputDate);
                    System.out.println("Enter time for your reminder:");
                    String inputTime = scanner.nextLine();
                    LocalTime parsedTime = calendar.parseTime(inputTime);
                    calendar.addReminder(title, description, parsedDate, parsedTime);
                    break;
                case 2:
                    System.out.println("Enter the ID of the reminder you wish to remove:");
                    id = scanner.nextLine();
                    calendar.deleteReminder(id);
                    break;
                case 3:
                    System.out.println("Here's a list of your reminders:");
                    calendar.showReminders();
                    break;
                case 4:
                    System.out.println("Enter the ID of the reminder you wish to edit:");
                    id = scanner.nextLine();
                    calendar.editReminder(id);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid function.");
            }
        }

    }

    private static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add reminder");
        System.out.println("2. Delete reminder");
        System.out.println("3. View reminders");
        System.out.println("4. Edit a reminder");
        System.out.println("5. Exit");
    }
    
}
