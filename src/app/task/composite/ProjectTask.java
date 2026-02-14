package app.task.composite;

import java.util.ArrayList;
import java.util.List;

public class ProjectTask implements TaskComponent {
    private String projectName;
    private List<TaskComponent> tasks = new ArrayList<>();
    
    public ProjectTask(String projectName) {
        this.projectName = projectName;
    }
    
    public void addTask(TaskComponent task) {
        tasks.add(task);
    }
    
    @Override
    public void execute() {
        System.out.println("Menjalankan Proyek: " + projectName);
        for (TaskComponent task : tasks) {
            task.execute();
        }
    }
}