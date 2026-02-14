package app.task.prototype;

import app.task.builder.TaskBuilder;
import app.task.domain.Task;

import java.time.LocalDate;

public class TaskTemplate implements Prototype<Task> {

    private final String title;
    private final Task.Priority priority;
    private final String assignee;

    public TaskTemplate(String title, Task.Priority priority, String assignee) {
        this.title = title;
        this.priority = priority;
        this.assignee = assignee;
    }

    @Override
    public Task copy() {
        // clone standar (tanpa dueDate)
        return new TaskBuilder()
                .title(title)
                .priority(priority)
                .assignee(assignee)
                .build();
    }

    public Task copyWithDueDate(LocalDate dueDate) {
        // clone + modifikasi dueDate
        return new TaskBuilder()
                .title(title)
                .priority(priority)
                .assignee(assignee)
                .dueDate(dueDate)
                .build();
    }
}
