package ToDoList;

public class Task {

    String taskId;
    String taskDescription;
    String taskCreationDate;
    boolean taskCompleted;


    // Constructor
    public Task(String taskId, String taskDescription, String taskCreationDate) {
        this.taskId = taskId;
        this.taskDescription = taskDescription;
        this.taskCreationDate = taskCreationDate;
        this.taskCompleted = false;
    }
    
    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return taskDescription;
    }

    public String getCreationDate() {
        return taskCreationDate;
    }

    public boolean getCompletion() {
        return taskCompleted;
    }

    // Setters
    public void setDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setCreatinDate(String taskCreationDate) {
        this.taskCreationDate = taskCreationDate;
    }

    public void setCompletion(boolean taskCompleted) {
        this.taskCompleted = true;
    }
}
