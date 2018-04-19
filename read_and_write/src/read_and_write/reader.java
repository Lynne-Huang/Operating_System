package read_and_write;
import java.util.concurrent.Semaphore;
public class reader implements Runnable{
    private int num;
    private int during;
    public int start;

    private boolean flag=true;
    long Time;
    public reader(int Num,int Start,int During) {
        this.num = Num;
        this.during = During;
        this.start = Start;
    }
    //读者优先
    public void run() {

//		// TODO Auto-generated method stub
        flag=true;
        try {
            System.out.println("读者"+this.num+"已经进入图书馆……");
            Thread.sleep(start*1000);
            if(demo.wmutex.availablePermits()>0)	System.out.println("读者"+this.num+"可以读……");
            else	System.out.println("有写者在写，读者"+this.num+"不可以读");
            while(flag) {

                demo.rmutex.acquire();
                if(demo.readCount==0)	//读者=0时，写者不能写
                    demo.wmutex.acquire();
                demo.readCount ++;
                demo.rmutex.release();
                System.out.println("当前者数："+demo.readCount);
                System.out.println("读者"+this.num+"可以读……");
                System.out.println("读者"+this.num+"开始读");


                Thread.sleep(during*1000);

                flag=false;

                demo.rmutex.acquire();
                System.out.println("读者"+this.num+"读完了……");
                demo.readCount--;
                System.out.println("当前剩余读者数："+demo.readCount);
                if(demo.readCount==0)
                    demo.wmutex.release();
                demo.rmutex.release();
            }
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
