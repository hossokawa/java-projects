package ExpenseTracker;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseTracker {

    public static void main(String[] args) {
        
        ExpenseList expenses = new ExpenseList();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();
            String description;
            String category;

            switch(choice) {
                case 1:
                    System.out.println("Enter expense description:");
                    description = scanner.nextLine();
                    System.out.println("Enter expense category:");
                    category = scanner.nextLine();
                    System.out.println("Enter expense amount:");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Enter expense date:\n(dd-MM-yyyy)");
                    String inputDate = scanner.nextLine();
                    LocalDate parsedDate = expenses.parseDate(inputDate);
                    expenses.addExpense(description, category, cost, parsedDate);
                    break;
                case 2:
                    System.out.println("Enter description of the expense to remove:");
                    description = scanner.nextLine();
                    expenses.removeExpense(description);
                    break;
                case 3:
                    System.out.println("Here are all your expenses:");
                    expenses.displayExpenses();
                    break;
                case 4:
                    System.out.println("Enter the category you want to see:");
                    category = scanner.nextLine();
                    expenses.displayExpensesForCategory(category);
                    break;
                case 5:
                    System.out.println("Are you sure you want to clear the expense list? (Y/N)");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("y")) {
                        expenses.clearExpenses();
                    } else {
                        return;
                    }
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }

        }

    }

    public static void displayMenu(){
        System.out.println("Main Menu");
        System.out.println("1. Add expense");
        System.out.println("2. Remove expense");
        System.out.println("3. View all expenses");
        System.out.println("4. View expenses for a category");
        System.out.println("5. Clear expense list");
        System.out.println("6. Exit");
    }

}
