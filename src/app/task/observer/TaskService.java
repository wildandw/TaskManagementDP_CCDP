package app.task.observer;

import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) { observers.add(observer); }
    public void notify(String message) {
        for (TaskObserver obs : observers) obs.onTaskUpdated(message);
    }
}