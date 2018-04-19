package process_scheduling;

import java.util.PriorityQueue;


public class PCBRunnable implements Runnable{

    private PriorityQueue<PCB> queue;

    public PCBRunnable(PriorityQueue<PCB> queue) {
        this.queue = queue;
    }

    PCB p1 = new PCB("P1",2,1,"Ready");
    PCB p2 = new PCB("P2",3,10,"Ready");
    PCB p3 = new PCB("P3",1,6,"Ready");
    PCB p4 = new PCB("P4",2,9,"Ready");
    PCB p5 = new PCB("P5",4,4,"Ready");

    @Override
    public void run() {
        System.out.println("15计算机3班 238115307黄景琳 操作系统实验二 —— 进程调度");
        queue.add(p1);
        System.out.println(p1.getName() + " 开始排队...");
        queue.add(p2);
        System.out.println(p2.getName() + " 开始排队...");
        queue.add(p3);
        System.out.println(p3.getName() + " 开始排队...");
        queue.add(p4);
        System.out.println(p4.getName() + " 开始排队...");
        queue.add(p5);
        System.out.println(p5.getName() + " 开始排队...");

        System.out.println("现在时间是："+processSchedulingTest.nowtime);
        System.out.println("进程名 剩余时间    状态      优先级");

    }
}

