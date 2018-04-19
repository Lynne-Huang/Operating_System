package read_and_write;

import java.util.concurrent.Semaphore;

public class demo implements Runnable {

    public static  int readCount=0;
    public static Semaphore wmutex;	//写信号量
    public static Semaphore rmutex;		//读信号量
    public static void main(String args[]) throws InterruptedException{
        rmutex = new Semaphore(1);
        wmutex = new Semaphore(1);
        writter w1 = new writter(1,  3, 5);
        writter w2 = new writter(2, 16, 5);
        reader r1 = new reader(3,5, 2);
        writter w3 = new writter(4, 6, 5);
        reader r2 = new reader(5,  4, 3);
        reader r3 = new reader(6, 11, 4);


        Thread a = new Thread(w1,"1");
        Thread b = new Thread(w2,"2");
        Thread c = new Thread(r1,"3");
        Thread d = new Thread(w3,"4");
        Thread e = new Thread(r2,"5");
        Thread f = new Thread(r3,"6");

        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();

    }
    @Override
    public void run() {
        // TODO Auto-generated method stub

    }


}