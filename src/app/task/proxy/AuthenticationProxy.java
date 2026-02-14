package app.task.proxy;

public class AuthenticationProxy implements TaskService {
    private RealTaskService realTaskService;
    private String currentUser;
    private String userRole;
    
    public AuthenticationProxy(String currentUser, String userRole) {
        this.realTaskService = new RealTaskService();
        this.currentUser = currentUser;
        this.userRole = userRole;
    }
    
    @Override
    public void executeTask(String taskId) {
        System.out.println("🔐 [AuthProxy] Memeriksa hak akses untuk user: " + currentUser);
        
        if (authenticate()) {
            System.out.println("✅ [AuthProxy] Autentikasi berhasil!");
            realTaskService.executeTask(taskId);
        } else {
            System.out.println("❌ [AuthProxy] Akses ditolak! Anda tidak memiliki izin.");
        }
    }
    
    @Override
    public String getTaskInfo(String taskId) {
        System.out.println("🔐 [AuthProxy] Memeriksa hak akses untuk user: " + currentUser);
        
        if (authenticate()) {
            System.out.println("✅ [AuthProxy] Autentikasi berhasil!");
            return realTaskService.getTaskInfo(taskId);
        } else {
            return "❌ Akses ditolak!";
        }
    }
    
    @Override
    public void updateTask(String taskId, String newInfo) {
        System.out.println("🔐 [AuthProxy] Memeriksa hak akses untuk user: " + currentUser);
        
        if (authenticate() && userRole.equals("ADMIN")) {
            System.out.println("✅ [AuthProxy] Autentikasi berhasil!");
            realTaskService.updateTask(taskId, newInfo);
        } else {
            System.out.println("❌ [AuthProxy] Akses ditolak! Hanya ADMIN yang dapat memperbarui tugas.");
        }
    }
    
    private boolean authenticate() {
        // Simulasi autentikasi sederhana
        return currentUser != null && !currentUser.isEmpty();
    }
}