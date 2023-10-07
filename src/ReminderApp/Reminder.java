package ReminderApp;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reminder {

    String id;
    private String title;
    private String description;
    private LocalDate date;
    private LocalTime time;

    public Reminder(String id,String title,String description,LocalDate date,LocalTime time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public void setTime(LocalTime newTime) {
        this.time = newTime;
    }

    @Override
    public String toString() {
        return "Reminder ID: " + id + 
               "\nTitle: " + title + 
               "\nDescription: " + description + 
               "\nDate: " + date + 
               "\nTime: " + time + "\n";
    }
    
}
