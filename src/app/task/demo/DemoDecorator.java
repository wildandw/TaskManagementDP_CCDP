package app.task.demo;

import app.task.decorator.*;
import app.task.domain.Task;
import java.time.LocalDate;

public class DemoDecorator {
    public static void main(String[] args) {
        System.out.println("=== Demo Pola Decorator ===\n");
        
        // Buat tugas dasar
        Task task1 = new Task(
            "Perbaiki Bug Kritis",
            "Developer A",
            Task.Priority.HIGH,
            LocalDate.now().plusDays(1)
        );
        
        Task task2 = new Task(
            "Perbarui Dokumentasi",
            "Developer B",
            Task.Priority.MEDIUM,
            LocalDate.now().plusDays(5)
        );
        
        // Contoh 1: Tugas sederhana tanpa dekorasi
        System.out.println("--- Contoh 1: Tugas Sederhana ---");
        TaskComponent simpleTask = new SimpleTask(task1);
        System.out.println(simpleTask.getDescription());
        simpleTask.execute();
        
        System.out.println("\n--- Contoh 2: Tugas dengan Logging ---");
        TaskComponent loggedTask = new LoggingDecorator(new SimpleTask(task1));
        System.out.println(loggedTask.getDescription());
        loggedTask.execute();
        
        System.out.println("\n--- Contoh 3: Tugas dengan Notifikasi ---");
        TaskComponent notifiedTask = new NotificationDecorator(new SimpleTask(task2));
        System.out.println(notifiedTask.getDescription());
        notifiedTask.execute();
        
        System.out.println("\n--- Contoh 4: Tugas Mendesak ---");
        TaskComponent urgentTask = new UrgentDecorator(new SimpleTask(task1));
        System.out.println(urgentTask.getDescription());
        urgentTask.execute();
        
        System.out.println("\n--- Contoh 5: Beberapa Dekorator (Bertumpuk) ---");
        TaskComponent fullyDecoratedTask = new TimeTrackingDecorator(
            new LoggingDecorator(
                new NotificationDecorator(
                    new UrgentDecorator(
                        new SimpleTask(task1)
                    )
                )
            )
        );
        System.out.println(fullyDecoratedTask.getDescription());
        fullyDecoratedTask.execute();
    }
}