package app.task.strategy;

import app.task.domain.Task;

import java.util.Comparator;
import java.util.List;

public class SortByPriority implements SortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }
}