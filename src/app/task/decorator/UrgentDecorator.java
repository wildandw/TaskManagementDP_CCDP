package app.task.decorator;

public class UrgentDecorator extends TaskDecorator {
    
    public UrgentDecorator(TaskComponent decoratedTask) {
        super(decoratedTask);
    }
    
    @Override
    public String getDescription() {
        return "🚨 MENDESAK! " + decoratedTask.getDescription();
    }
    
    @Override
    public void execute() {
        System.out.println("⚠️  TUGAS MENDESAK - PRIORITAS TINGGI!");
        decoratedTask.execute();
        System.out.println("⚠️  Harap selesaikan segera!");
    }
}