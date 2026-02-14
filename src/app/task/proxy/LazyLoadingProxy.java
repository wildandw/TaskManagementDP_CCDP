package app.task.proxy;

public class LazyLoadingProxy implements TaskService {
    private RealTaskService realTaskService;
    
    // RealTaskService hanya dibuat ketika benar-benar dibutuhkan
    private RealTaskService getRealTaskService() {
        if (realTaskService == null) {
            System.out.println("🔄 [LazyProxy] Menginisialisasi RealTaskService untuk pertama kali...");
            realTaskService = new RealTaskService();
        }
        return realTaskService;
    }
    
    @Override
    public void executeTask(String taskId) {
        System.out.println("🔄 [LazyProxy] Meminta eksekusi tugas...");
        getRealTaskService().executeTask(taskId);
    }
    
    @Override
    public String getTaskInfo(String taskId) {
        System.out.println("🔄 [LazyProxy] Meminta info tugas...");
        return getRealTaskService().getTaskInfo(taskId);
    }
    
    @Override
    public void updateTask(String taskId, String newInfo) {
        System.out.println("🔄 [LazyProxy] Meminta pembaruan tugas...");
        getRealTaskService().updateTask(taskId, newInfo);
    }
}