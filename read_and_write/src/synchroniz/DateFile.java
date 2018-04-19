package synchroniz;

public class DateFile {
    private int readerCount;
    private boolean doreading;
    private boolean dowriting;

    public DateFile() {
        readerCount=0;
        dowriting=false;
        doreading=false;
    }

    public void millis(int i) throws InterruptedException {
        Thread.sleep((int)i*1000);
    }

    public synchronized int startRead() {
        while(dowriting == true) {
            try {
                System.out.println("当前有写者在写，"+Thread.currentThread().getName()+"不可以读，等待……");
                wait();
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"开始读");
        readerCount++;
        if(readerCount==1) {
            doreading = true;
        }
        System.out.println("当前读者数"+readerCount);
        return readerCount;
    }
    public synchronized int endRead() {
        --readerCount;
        if(readerCount==0) {
            doreading = false;
        }
        System.out.println("当前读者数"+readerCount);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+"读完了！！！");
        return readerCount;
    }
    public synchronized void startWrite() {
        while(dowriting == true || doreading == true) {
            try {
                System.out.println("有人在读或写，"+Thread.currentThread().getName()+"不可以写");
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("写者"+Thread.currentThread().getName()+"开始写……");
        dowriting = true;
    }
    public synchronized void endWrite() {
        dowriting = false;
        notifyAll();
        System.out.println("写者"+Thread.currentThread().getName()+"写完了……");
    }

}
