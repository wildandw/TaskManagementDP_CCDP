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
