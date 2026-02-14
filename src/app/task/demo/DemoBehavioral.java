package app.task.demo;

import app.task.command.ChangeAssigneeCommand;
import app.task.command.Command;
import app.task.domain.Task;
import app.task.observer.TaskService;
import app.task.strategy.SortByPriority;
import app.task.strategy.SortStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DemoBehavioral {
    public static void main(String[] args) {
        // 1. Inisialisasi Data
        List<Task> myTasks = new ArrayList<>();
        myTasks.add(new Task("UML Diagram", "Budi", Task.Priority.LOW, LocalDate.now().plusDays(5)));
        myTasks.add(new Task("Modul Auth", "Azi", Task.Priority.HIGH, LocalDate.now().plusDays(2)));

        // 2. Observer: Set up notifikasi
        TaskService notifier = new TaskService();
        notifier.addObserver(msg -> System.out.println("[NOTIFIKASI]: " + msg));

        // 3. Strategy: Urutkan berdasarkan Prioritas
        System.out.println("--- Sebelum Sorting ---");
        myTasks.forEach(System.out::println);

        SortStrategy strategy = new SortByPriority();
        strategy.sort(myTasks);

        System.out.println("\n--- Sesudah Sorting (High to Low) ---");
        myTasks.forEach(System.out::println);

        // 4. Command: Ganti orang (Assignee) dengan fitur Undo
        Task targetTask = myTasks.get(1);
        Command changeCmd = new ChangeAssigneeCommand(targetTask, "Maulana");

        System.out.println("\n--- Mengubah Assignee ---");
        changeCmd.execute();
        notifier.notify("Tugas '" + targetTask.getTitle() + "' dipindahkan ke " + targetTask.getAssignee());
        System.out.println("Sekarang: " + targetTask);

        System.out.println("\n--- Melakukan Undo ---");
        changeCmd.undo();
        System.out.println("Setelah Undo: " + targetTask);
    }
}