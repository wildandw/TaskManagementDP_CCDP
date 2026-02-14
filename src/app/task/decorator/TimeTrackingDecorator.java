package app.task.decorator;

public class TimeTrackingDecorator extends TaskDecorator {
    
    public TimeTrackingDecorator(TaskComponent decoratedTask) {
        super(decoratedTask);
    }
    
    @Override
    public String getDescription() {
        return decoratedTask.getDescription() + " [DENGAN PELACAKAN WAKTU]";
    }
    
    @Override
    public void execute() {
        long startTime = System.currentTimeMillis();
        
        System.out.println("⏱️  Pelacakan waktu dimulai...");
        decoratedTask.execute();
        
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        System.out.println("⏱️  Waktu yang dibutuhkan: " + duration + "ms");
    }
}