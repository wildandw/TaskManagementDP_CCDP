package app.task.decorator;

public class NotificationDecorator extends TaskDecorator {
    
    public NotificationDecorator(TaskComponent decoratedTask) {
        super(decoratedTask);
    }
    
    @Override
    public String getDescription() {
        return decoratedTask.getDescription() + " [DENGAN NOTIFIKASI]";
    }
    
    @Override
    public void execute() {
        sendNotificationBefore();
        decoratedTask.execute();
        sendNotificationAfter();
    }
    
    private void sendNotificationBefore() {
        System.out.println("📧 Notifikasi: Tugas akan segera dimulai...");
    }
    
    private void sendNotificationAfter() {
        System.out.println("📧 Notifikasi: Tugas telah selesai dikerjakan!");
    }
}