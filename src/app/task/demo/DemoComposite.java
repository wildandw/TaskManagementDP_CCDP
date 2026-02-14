package app.task.demo;

import app.task.composite.ProjectTask;
import app.task.composite.SimpleTask;
import app.task.composite.TaskComponent;
import app.task.domain.Task;
import java.time.LocalDate;

public class DemoComposite {
    public static void main(String[] args) {
        Task task1 = new Task(
                "Desain UI",
                "FJ",
                Task.Priority.HIGH,
                LocalDate.now().plusDays(3)
        );
        Task task2 = new Task(
                "Implementasi Backend",
                "Tim Dev",
                Task.Priority.MEDIUM,
                LocalDate.now().plusDays(7)
        );
        
        TaskComponent simpleTask1 = new SimpleTask(task1);
        TaskComponent simpleTask2 = new SimpleTask(task2);
        
        ProjectTask project = new ProjectTask("Proyek Manajemen Tugas");
        project.addTask(simpleTask1);
        project.addTask(simpleTask2);
        
        System.out.println("=== Demo Composite Pattern ===\n");
        project.execute();
    }
}