package app.task.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxy implements TaskService {
    private RealTaskService realTaskService;
    private Map<String, String> cache;
    
    public CachingProxy() {
        this.realTaskService = new RealTaskService();
        this.cache = new HashMap<>();
    }
    
    @Override
    public void executeTask(String taskId) {
        System.out.println("💾 [CachingProxy] Meneruskan eksekusi tugas...");
        realTaskService.executeTask(taskId);
    }
    
    @Override
    public String getTaskInfo(String taskId) {
        if (cache.containsKey(taskId)) {
            System.out.println("💾 [CachingProxy] Mengambil data dari cache untuk: " + taskId);
            return cache.get(taskId);
        } else {
            System.out.println("💾 [CachingProxy] Data tidak ada di cache, mengambil dari service...");
            String taskInfo = realTaskService.getTaskInfo(taskId);
            cache.put(taskId, taskInfo);
            System.out.println("💾 [CachingProxy] Data disimpan ke cache");
            return taskInfo;
        }
    }
    
    @Override
    public void updateTask(String taskId, String newInfo) {
        System.out.println("💾 [CachingProxy] Memperbarui tugas dan menghapus cache...");
        realTaskService.updateTask(taskId, newInfo);
        cache.remove(taskId); // Hapus cache karena data sudah berubah
        System.out.println("💾 [CachingProxy] Cache dihapus untuk: " + taskId);
    }
}