package ExpenseTracker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseList {

    private List<Expense> expenses = new ArrayList<>();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void addExpense(String description,String category,double cost,LocalDate date) {
        Expense expense = new Expense(description, category, cost, date);
        expenses.add(expense);
        System.out.println("Expense added successfully!");
        System.out.println();
    }

    public void displayExpenses() {
        for(Expense expense : expenses)  {
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("Cost: " + expense.getCost());
            System.out.println("Date: " + expense.getDate());
            System.out.println();
        }
    }

    public void displayExpensesForCategory(String category) {
        List<Expense> expensesInCategory = getExpenseByCategory(category);
        for(Expense expense : expensesInCategory) {
            System.out.println(expense);
            System.out.println();
        }
    }

    public void removeExpense(String description) {
        Expense expenseToRemove = getExpenseByDescription(description);
        if(expenseToRemove != null) {
            expenses.remove(expenseToRemove);
            System.out.println("Expense removed successfully!");
            System.out.println();
        } else {
            System.out.println(description + " expense could not be found.");
            System.out.println();
        }
    }

    public void clearExpenses() {
        expenses.clear();
        System.out.println("Expense list cleared successfully");
        System.out.println();
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

    private List<Expense> getExpenseByCategory(String category) {
        List<Expense> expensesInCategory = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                expensesInCategory.add(expense);
            }
        }
        return expensesInCategory;
    }
    private Expense getExpenseByDescription(String description) {
        for(Expense expense : expenses) {
            if(expense.getDescription().equals(description)) {
                return expense;
            }
        }
        return null;
    }
    
}
