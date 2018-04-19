package synchroniz;

public class Writter implements Runnable {
    private int num;
    private DateFile df;
    private int start;
    private int during;
    public Writter(int Num,DateFile df,int Start,int During) {
        this.num = Num;
        this.df = df;
        this.start = Start;
        this.during = During;
    }
    public void run() {
        try {
            System.out.println("writer "+this.num+" come here ！");
            df.millis(start);
            df.startWrite();
            df.millis(during);
            df.endWrite();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
