package ToDoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    
    private int nextId = 1;
    private List<Task> taskList = new ArrayList<>();

    public String getDate() {
        LocalDate today = LocalDate.now(); // gets today's date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return today.format(formatter);
    }

    public void addTask(String taskDescription) {
        String formattedId = String.format("%02d", nextId);
        String taskCreationDate = getDate(); // gets today's date
        Task task = new Task(formattedId, taskDescription, taskCreationDate);
        taskList.add(task);
        nextId++; // Increments next ID
    }
    
    public void removeTask(String taskId) {
        Task taskToRemove = getTaskById(taskId);
        if(taskToRemove != null) {
            taskList.remove(taskToRemove);
            System.out.println("Task "+taskId+" removed successfully");
        } else {
            System.out.println("Task "+taskId+" not found.");
        }
    }

    public void completeTask(String taskId) {
        Task taskToComplete = getTaskById(taskId);
        if(taskToComplete != null) {
            taskToComplete.setCompletion(true);
            System.out.println("Task marked as complete!");
        } else {
            System.out.println("Task "+taskId+" not found.");
        }
    }

    public void displayTasks() {
        for(Task task : taskList) {
            System.out.println("Task ID: "+task.getTaskId());
            System.out.println("Task Description: "+task.getDescription());
            System.out.println("Task Creation Date: "+task.getCreationDate());
            System.out.println("Task Status: "+(task.getCompletion() ?"Completed":"Incomplete"));
            System.out.println();
        }
    }

    public void clearTasks() {
        taskList.clear();
    }

    private Task getTaskById(String taskId) {
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }        
        // If the task couldn't be found
        return null;
    }

}
