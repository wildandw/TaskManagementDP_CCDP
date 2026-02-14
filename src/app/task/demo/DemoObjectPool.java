package app.task.demo;

import app.task.objectpool.ObjectPool;
import app.task.objectpool.ReportGenerator;

public class DemoObjectPool {

    public static void main(String[] args) {

        ObjectPool<ReportGenerator> pool =
                new ObjectPool<>(ReportGenerator::new, 3);

        long start = System.currentTimeMillis();

        ReportGenerator g1 = pool.acquire();
        System.out.println(g1.generate("laporan task minggu 1"));
        pool.release(g1);

        ReportGenerator g2 = pool.acquire();
        System.out.println(g2.generate("laporan task minggu 2"));
        pool.release(g2);

        ReportGenerator g3 = pool.acquire();
        System.out.println(g3.generate("laporan task minggu 3"));
        pool.release(g3);

        long end = System.currentTimeMillis();

        System.out.println("Pool available: " + pool.availableCount());
        System.out.println("Total time: " + (end - start) + " ms");
    }
}
