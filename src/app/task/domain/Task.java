package app.task.domain;

import java.time.LocalDate;

public class Task {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    private String title;
    private String assignee;
    private Priority priority;
    private LocalDate dueDate;

    public Task(String title,
                String assignee,
                Priority priority,
                LocalDate dueDate) {
        this.title = title;
        this.assignee = assignee;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Tambahkan getter methods ini
    public String getTitle() {
        return title;
    }

    public String getAssignee() {
        return assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                '}';
    }
}