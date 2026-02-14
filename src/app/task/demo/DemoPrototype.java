package app.task.demo;

import app.task.domain.Task;
import app.task.prototype.TaskTemplate;

import java.time.LocalDate;

public class DemoPrototype {

    public static void main(String[] args) {

        TaskTemplate weeklyMeeting = new TaskTemplate(
                "Rapat Tim Mingguan",
                Task.Priority.MEDIUM,
                "FJ"
        );

        Task task1 = weeklyMeeting.copyWithDueDate(LocalDate.now().plusDays(2));
        Task task2 = weeklyMeeting.copyWithDueDate(LocalDate.now().plusDays(9));

        System.out.println(task1);
        System.out.println(task2);
    }
}
