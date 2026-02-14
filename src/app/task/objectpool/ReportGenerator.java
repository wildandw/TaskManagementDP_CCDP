package app.task.objectpool;

public class ReportGenerator {

    public ReportGenerator() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException ignored) {}
    }

    public String generate(String input) {
        return "REPORT: " + input.toUpperCase();
    }
}
