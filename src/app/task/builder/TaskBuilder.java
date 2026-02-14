package app.task.builder;

import app.task.domain.Task;
import java.time.LocalDate;

public class TaskBuilder {

    private String title;
    private String assignee = "Unassigned";
    private Task.Priority priority = Task.Priority.MEDIUM;
    private LocalDate dueDate = null;

    public TaskBuilder title(String title) {
        this.title = title;
        return this;
    }

    public TaskBuilder assignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    public TaskBuilder priority(Task.Priority priority) {
        this.priority = priority;
        return this;
    }

    public TaskBuilder dueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task build() {
        if (title == null || title.isBlank()) {
            throw new IllegalStateException("Title wajib diisi");
        }

        return new Task(title, assignee, priority, dueDate);
    }
}
