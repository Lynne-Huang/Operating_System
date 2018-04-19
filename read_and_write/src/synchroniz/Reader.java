package synchroniz;

public class Reader implements Runnable{
    private int num;
    private DateFile df;
    private int start;
    private int during;
    public Reader(int Num,DateFile df,int Start,int During) {
        this.num = Num;
        this.df = df;
        this.start = Start;
        this.during = During;
    }
    public void run() {
        try {
            System.out.println("reader "+this.num+" come here ！");
            df.millis(start);
            df.startRead();
            df.millis(during);
            df.endRead();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
