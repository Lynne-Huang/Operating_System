
package process_scheduling;


import java.util.Comparator;
import java.util.PriorityQueue;
public class processSchedulingTest {
    public static int nowtime = 0;

    public static Comparator<PCB> pcbs=new Comparator<PCB>() {
        @Override
        public int compare(PCB o1, PCB o2) {
            return o2.getPriority()-o1.getPriority();
        }
    };
    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        PriorityQueue<PCB> queue = new PriorityQueue<PCB>(5, pcbs);
        //进入队列,排队
        Thread thread = new Thread(new PCBRunnable(queue));
        thread.start();
        thread.join();
        new Thread(new PCBRun(queue)).start();

    }
}