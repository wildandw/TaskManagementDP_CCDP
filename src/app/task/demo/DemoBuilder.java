package app.task.demo;

import app.task.builder.TaskBuilder;
import app.task.domain.Task;
import java.time.LocalDate;

public class DemoBuilder {

    public static void main(String[] args) {

        Task task = new TaskBuilder()
                .title("Kerjakan Tugas Besar")
                .assignee("FJ")
                .priority(Task.Priority.HIGH)
                .dueDate(LocalDate.now().plusDays(5))
                .build();

        System.out.println(task);
    }
}
