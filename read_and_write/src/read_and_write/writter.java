package read_and_write;

import java.util.concurrent.Semaphore;

public class writter implements Runnable{
    private int num;
    private int during;
    public int start;

    long Time;
    boolean flag=true;
    public writter(int Num,int Start,int During) {
        this.num = Num;
        this.during = During;
        this.start = Start;

    }
    @Override
    public void run()  {
        try {
            System.out.println("写者"+this.num+"已经进入图书馆……");
            Thread.sleep(start*1000);

            if(demo.wmutex.availablePermits()>0)	System.out.println("写者"+this.num+"可以写");
            else System.out.println("有人在读或写，写者"+this.num+"不可以写");
            while(flag) {

                demo.wmutex.acquire();
                System.out.println("写者"+this.num+"开始写……");
                System.out.println("写者"+this.num+"正在写");
                Thread.sleep(during*1000);
                flag=false;
                System.out.println("写者"+this.num+"已经写完了");
                demo.wmutex.release();
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
