package app.task.decorator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingDecorator extends TaskDecorator {
    
    public LoggingDecorator(TaskComponent decoratedTask) {
        super(decoratedTask);
    }
    
    @Override
    public String getDescription() {
        return decoratedTask.getDescription() + " [DENGAN LOGGING]";
    }
    
    @Override
    public void execute() {
        logBefore();
        decoratedTask.execute();
        logAfter();
    }
    
    private void logBefore() {
        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
        System.out.println("[LOG " + timestamp + "] Tugas dimulai");
    }
    
    private void logAfter() {
        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
        System.out.println("[LOG " + timestamp + "] Tugas selesai");
    }
}