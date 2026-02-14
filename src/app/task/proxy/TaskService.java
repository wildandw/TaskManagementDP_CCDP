package app.task.proxy;

public interface TaskService {
    void executeTask(String taskId);
    String getTaskInfo(String taskId);
    void updateTask(String taskId, String newInfo);
}