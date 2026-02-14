package app.task.command;

public interface Command {
    void execute();
    void undo();
}