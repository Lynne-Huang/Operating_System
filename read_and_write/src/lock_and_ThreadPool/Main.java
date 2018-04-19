package lock_and_ThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final ReentrantLock lock;
    private static int readCount =0;
    private Semaphore wmutex;
    int time;
    public Main() {
        lock = new ReentrantLock();
        wmutex = new Semaphore(1);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main main = new Main();
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        service.scheduleAtFixedRate(main.new Writer(1, 5), 3, 1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(main.new Writer(2, 5), 16,1,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(main.new Reader(3, 2),5,1,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(main.new Writer(4, 5), 6,1,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(main.new Reader(5, 3), 4,1,TimeUnit.SECONDS);
        service.scheduleAtFixedRate(main.new Reader(6, 4),11,1,TimeUnit.SECONDS);
    }

    class Reader implements Runnable{
        private int num;
        private int during;

        public Reader(int Num,int During) {
            this.num = Num;
            this.during = During;
        }

        public void before() {
            final ReentrantLock l =lock;	//读之前要上锁
            l.lock();
            try {
                if(readCount==0) {
                    wmutex.acquire(1);
                }
                readCount++;
                System.out.println(this.num+"读者进来");
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                l.unlock();
            }
        }
        public void read() {
            while(during>0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("读者"+this.num+"正在读……");
                System.out.println("现在读者数"+readCount+"人");
                during--;
            }
            System.out.println("当前有"+readCount+"位读者");
        }
        public void after() {
            final ReentrantLock l = lock;
            l.lock();
            try {
                readCount--;
                System.out.println(this.num+"读者离开");
                if(readCount == 0)
                    wmutex.release(1);
            }finally {
                l.unlock();
            }
        }
        @SuppressWarnings("deprecation")
        public void run() {
            before();
            read();
            after();
            Thread.currentThread().stop();
        }
    }
    class Writer implements Runnable{
        private int num;
        private int during;
        //public int start;


        public Writer(int Num,int During) {
            this.num = Num;
            this.during = During;
        }
        @SuppressWarnings("deprecation")
        public void run() {
            final ReentrantLock l =lock;
            l.lock();
            try {
                try {
                    wmutex.acquire(1);
                    System.out.println("写者"+this.num+"开始写……");
                    while(during>0) {
                        Thread.sleep(1000);
                        System.out.println("读者"+this.num+"正在读……");
                        System.out.println("现在读者数"+readCount+"人");
                        during--;
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                l.unlock();
                Thread.currentThread().stop();
            }
        }
    }
}
