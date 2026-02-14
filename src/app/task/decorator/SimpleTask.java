package app.task.decorator;

import app.task.domain.Task;

public class SimpleTask implements TaskComponent {
    private final Task task;
    
    public SimpleTask(Task task) {
        this.task = task;
    }
    
    @Override
    public String getDescription() {
        return "Tugas: " + task.getTitle() + 
               " (Ditugaskan ke: " + task.getAssignee() + 
               ", Prioritas: " + task.getPriority() + 
               ", Tenggat: " + task.getDueDate() + ")";
    }
    
    @Override
    public void execute() {
        System.out.println("Menjalankan: " + task.getTitle());
    }
}