package app.task.strategy;

import app.task.domain.Task;

import java.util.List;

public interface SortStrategy {
    void sort(List<Task> tasks);
}