package app.task.proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingProxy implements TaskService {
    private RealTaskService realTaskService;
    
    public LoggingProxy() {
        this.realTaskService = new RealTaskService();
    }
    
    @Override
    public void executeTask(String taskId) {
        logAction("EXECUTE", taskId);
        realTaskService.executeTask(taskId);
        logAction("EXECUTE_COMPLETE", taskId);
    }
    
    @Override
    public String getTaskInfo(String taskId) {
        logAction("GET_INFO", taskId);
        String result = realTaskService.getTaskInfo(taskId);
        logAction("GET_INFO_COMPLETE", taskId);
        return result;
    }
    
    @Override
    public void updateTask(String taskId, String newInfo) {
        logAction("UPDATE", taskId);
        realTaskService.updateTask(taskId, newInfo);
        logAction("UPDATE_COMPLETE", taskId);
    }
    
    private void logAction(String action, String taskId) {
        String timestamp = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );
        System.out.println("📝 [LogProxy " + timestamp + "] Aksi: " + action + " | Task: " + taskId);
    }
}