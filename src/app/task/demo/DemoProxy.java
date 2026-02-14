package app.task.demo;

import app.task.proxy.*;

public class DemoProxy {
    public static void main(String[] args) {
        System.out.println("=== Demo Proxy pattern ===\n");
        
        // Contoh 1: Authentication Proxy dengan user valid
        System.out.println("--- Contoh 1: Authentication Proxy (User Valid) ---");
        TaskService authProxy1 = new AuthenticationProxy("john_doe", "ADMIN");
        authProxy1.executeTask("TASK-001");
        
        System.out.println("\n--- Contoh 2: Authentication Proxy (User Tidak Valid) ---");
        TaskService authProxy2 = new AuthenticationProxy("", "USER");
        authProxy2.executeTask("TASK-001");
        
        System.out.println("\n--- Contoh 3: Authentication Proxy (Update tanpa ADMIN) ---");
        TaskService authProxy3 = new AuthenticationProxy("jane_doe", "USER");
        authProxy3.updateTask("TASK-001", "Desain UI Dashboard - Revisi");
        
        System.out.println("\n--- Contoh 4: Caching Proxy ---");
        TaskService cachingProxy = new CachingProxy();
        System.out.println("Panggilan pertama:");
        String info1 = cachingProxy.getTaskInfo("TASK-002");
        System.out.println("Hasil: " + info1);
        
        System.out.println("\nPanggilan kedua (dari cache):");
        String info2 = cachingProxy.getTaskInfo("TASK-002");
        System.out.println("Hasil: " + info2);
        
        System.out.println("\n--- Contoh 5: Logging Proxy ---");
        TaskService loggingProxy = new LoggingProxy();
        loggingProxy.executeTask("TASK-003");
        
        System.out.println("\n--- Contoh 6: Lazy Loading Proxy ---");
        TaskService lazyProxy = new LazyLoadingProxy();
        System.out.println("Proxy dibuat, tapi RealTaskService belum diinisialisasi");
        System.out.println("Memanggil getTaskInfo pertama kali:");
        lazyProxy.getTaskInfo("TASK-001");
        System.out.println("\nMemanggil executeTask (RealTaskService sudah ada):");
        lazyProxy.executeTask("TASK-002");
    }
}