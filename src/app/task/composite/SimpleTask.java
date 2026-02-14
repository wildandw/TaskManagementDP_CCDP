package app.task.composite;

import app.task.domain.Task;

public class SimpleTask implements TaskComponent {
    private final Task task;
    
    public SimpleTask(Task task) {
        this.task = task;
    }
    
    @Override
    public void execute() {
        System.out.println("  - Menjalankan Tugas: " + task.getTitle() + 
                         " | Ditugaskan ke: " + task.getAssignee() + 
                         " | Prioritas: " + task.getPriority() + 
                         " | Tenggat: " + task.getDueDate());
    }
}