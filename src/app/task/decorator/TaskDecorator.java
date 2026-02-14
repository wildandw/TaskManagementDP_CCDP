package app.task.decorator;

public abstract class TaskDecorator implements TaskComponent {
    protected TaskComponent decoratedTask;
    
    public TaskDecorator(TaskComponent decoratedTask) {
        this.decoratedTask = decoratedTask;
    }
    
    @Override
    public String getDescription() {
        return decoratedTask.getDescription();
    }
    
    @Override
    public void execute() {
        decoratedTask.execute();
    }
}