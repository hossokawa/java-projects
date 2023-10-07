package ReminderApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<Reminder> reminders;
    private int nextId = 1;

    public Calendar() {
        reminders = new ArrayList<>();
    }

    public void addReminder(String title,String description,LocalDate date,LocalTime time) {
        String formattedId = String.format("%d",nextId);
        Reminder reminder = new Reminder(formattedId,title,description,date,time);
        reminders.add(reminder);
        nextId++;
    }

    public void deleteReminder(String id) {
        Reminder reminderToRemove = getReminderById(id);
        if(reminderToRemove != null) {
            reminders.remove(reminderToRemove);
            System.out.println("Reminder " + id + " removed successfully");
        } else {
            System.out.println("Reminder " + id + " could not be found");
        }
        
    }

    public void showReminders() {
        for(Reminder reminder : reminders) {
            System.out.println(reminder.toString());
        }
    }

    private Reminder getReminderById(String id) {
        for(Reminder reminder : reminders) {
            if(reminder.getId().equals(id)) {
                return reminder;
            }
        }
        return null;
    }
    
}
