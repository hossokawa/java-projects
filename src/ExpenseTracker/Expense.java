package ExpenseTracker;

import java.time.LocalDate;

public class Expense {

    private String description;
    private String category;
    private double cost;
    private LocalDate date;
    
    public Expense(String description,String category,double cost, LocalDate date) {
        this.description = description;
        this.category = category;
        this.cost = cost;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Description: " + getDescription() + 
               "\nCategory: " + getCategory() + 
               "\nCost: " + getCost() + 
               "\nDate: " + getDate() + "\n";
    }
    
}
