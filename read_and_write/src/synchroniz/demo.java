package synchroniz;

import read_and_write.writter;

public class demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        DateFile df = new DateFile();

        Writter w1 = new Writter(1, df, 3, 5);
        Writter w2 = new Writter(2, df, 16, 5);
        Reader r1 = new Reader(3, df, 5, 2);
        Writter w3 = new Writter(4, df, 6, 5);
        Reader r2 = new Reader(5, df, 4, 3);
        Reader r3 = new Reader(6, df, 11, 4);

        Thread a = new Thread(w1,"1");
        Thread b = new Thread(w2," 2");
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

}
