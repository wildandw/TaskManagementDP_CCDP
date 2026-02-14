package app.task.proxy;

import java.util.HashMap;
import java.util.Map;

public class RealTaskService implements TaskService {
    private Map<String, String> taskDatabase;
    
    public RealTaskService() {
        taskDatabase = new HashMap<>();
        // Inisialisasi beberapa data tugas
        taskDatabase.put("TASK-001", "Desain UI Dashboard");
        taskDatabase.put("TASK-002", "Implementasi API Backend");
        taskDatabase.put("TASK-003", "Testing Fitur Login");
    }
    
    @Override
    public void executeTask(String taskId) {
        System.out.println("   [RealTaskService] Menjalankan tugas: " + taskId);
        if (taskDatabase.containsKey(taskId)) {
            System.out.println("   [RealTaskService] Tugas '" + taskDatabase.get(taskId) + "' sedang diproses...");
            // Simulasi proses yang memakan waktu
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("   [RealTaskService] Tugas selesai!");
        } else {
            System.out.println("   [RealTaskService] Tugas tidak ditemukan!");
        }
    }
    
    @Override
    public String getTaskInfo(String taskId) {
        System.out.println("   [RealTaskService] Mengambil info tugas: " + taskId);
        return taskDatabase.getOrDefault(taskId, "Tugas tidak ditemukan");
    }
    
    @Override
    public void updateTask(String taskId, String newInfo) {
        System.out.println("   [RealTaskService] Memperbarui tugas: " + taskId);
        taskDatabase.put(taskId, newInfo);
        System.out.println("   [RealTaskService] Tugas berhasil diperbarui!");
    }
}