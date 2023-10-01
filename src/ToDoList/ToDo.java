package ToDoList;

import java.util.Scanner;

public class ToDo {

    public static void main(String[] args) {
        
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayMenu();

            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 1:
                    System.out.println("Enter the task description:");
                    String taskDescription = scanner.nextLine();
                    taskManager.addTask(taskDescription);
                    System.out.println("Task added successfully!");
                    break;
                case 2:
                    System.out.println("Enter task ID to remove:");
                    String taskId = scanner.nextLine();
                    taskManager.removeTask(taskId);
                    break;
                case 3:
                    System.out.println("Here are all your tasks:");
                    taskManager.displayTasks();
                    break;
                case 4:
                    System.out.println("Enter task ID to mark as complete:");
                    String taskCompleteId = scanner.nextLine();
                    taskManager.completeTask(taskCompleteId);
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid function.");
            }
        }

    }

    private static void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Add task");
        System.out.println("2. Remove task");
        System.out.println("3. Display tasks");
        System.out.println("4. Complete task");
        System.out.println("5. Exit");
    }
    
}
