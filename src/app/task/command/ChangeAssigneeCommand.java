package app.task.command;

import app.task.domain.Task;

public class ChangeAssigneeCommand implements Command {

    private Task task;
    private String newAssignee;
    private String oldAssignee;

    public ChangeAssigneeCommand(Task task, String newAssignee) {
        this.task = task;
        this.newAssignee = newAssignee;
        this.oldAssignee = task.getAssignee();
    }

    @Override
    public void execute() { task.setAssignee(newAssignee); }

    @Override
    public void undo() { task.setAssignee(oldAssignee); }
}
