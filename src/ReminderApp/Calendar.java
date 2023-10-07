package ReminderApp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Calendar {

    private List<Reminder> reminders;
    private int nextId = 1;
    Scanner scanner = new Scanner(System.in);
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public Calendar() {
        reminders = new ArrayList<>();
    }

    public void addReminder(String title,String description,LocalDate date,LocalTime time) {
        String formattedId = String.format("%d",nextId);
        Reminder reminder = new Reminder(formattedId,title,description,date,time);
        reminders.add(reminder);
        System.out.println();
        System.out.println("Reminder added successfully!");
        System.out.println();
        nextId++;
    }

    public void deleteReminder(String id) {
        Reminder reminderToRemove = getReminderById(id);
        if(reminderToRemove != null) {
            reminders.remove(reminderToRemove);
            System.out.println();
            System.out.println("Reminder " + id + " removed successfully");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Reminder " + id + " could not be found");
            System.out.println();
        }
        
    }

    public void showReminders() {
        for(Reminder reminder : reminders) {
            System.out.println(reminder.toString());
        }
    }

    public boolean editReminder(String id) {
        Reminder reminderToEdit = getReminderById(id);
        if(reminderToEdit != null) {
            System.out.println("What do you want to edit?\nType title, description, date or time");
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("title")) {
                System.out.println("Insert new title:");
                String newTitle = scanner.nextLine();
                reminderToEdit.setTitle(newTitle);
                System.out.println();
                System.out.println("Title updated successfully.");
                return true;
            } else if(choice.equalsIgnoreCase("description")) {
                System.out.println("Insert new description:");
                String newDescription = scanner.nextLine();
                reminderToEdit.setDescription(newDescription);
                System.out.println();
                System.out.println("Description updated successfully.");
                return true;
            } else if(choice.equalsIgnoreCase("date")) {
                System.out.println("Insert new date (dd-MM-yyyy):");
                String dateInput = scanner.nextLine();
                try {
                    LocalDate newDate = LocalDate.parse(dateInput, dateFormatter);
                    reminderToEdit.setDate(newDate);
                    System.out.println();
                    System.out.println("Date updated successfully.");
                    return true;
                } catch(DateTimeParseException e) {
                    System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
                }
            } else if(choice.equalsIgnoreCase("time")) {
                System.out.println("Insert new time (HH:mm):");
                String timeInput = scanner.nextLine();
                try {
                    LocalTime newTime = LocalTime.parse(timeInput, timeFormatter);
                    reminderToEdit.setTime(newTime);
                    System.out.println();
                    System.out.println("Time updated successfully.");
                    return true;
                } catch(DateTimeParseException e) {
                    System.out.println("Invalid time format. Please enter in HH:mm format.");
                }
            } else {
                System.out.println("Please choose a valid option.");
            }
        }
        return false;
    }

    public LocalDate parseDate(String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString, dateFormatter);
            return date;
        } catch(DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter in dd-MM-yyyy format.");
            return null;
        }
    }

    public LocalTime parseTime(String timeString) {
        try {
            LocalTime time = LocalTime.parse(timeString, timeFormatter);
            return time;
        } catch(DateTimeParseException e) {
            System.out.println("Invalid time format. Please enter in HH:mm format.");
            return null;
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
