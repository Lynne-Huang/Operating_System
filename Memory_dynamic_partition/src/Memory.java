import java.util.LinkedList;
import java.util.Scanner;
/**
 * 目前问题，循环首次优先，还有加入的顺序有问题
 */

/**
 *  @author Lynne
 */
public class Memory {   //一个进程

    private int size;                       //内存大小
    private LinkedList<Zone> zones;         //内存分区
    private static final int MIN_SIZE = 5;  //最小剩余分区大小
    private int pointer;                    //上次分配的空闲区位置

    class Zone{
        private int size;                   //分区大小
        private  int head;                  //起始地址
        private Boolean isFree;             //是否被使用
        private String name;                    //进程名称
        public Zone(int Head, int Size,String name){
            this.name = name;
            this.head = Head;
            this.size = Size;
            this.isFree = true;
        }

    }
    public Memory(){
        this.size = 128;
        this.pointer = 0;
        this.zones = new LinkedList<>();
        zones.add(new Zone(0,size,""));
    }
    public Memory(String Name,int Length){

        this.size = Length;
        this.pointer = getPointer()+Length;
        this.zones = new LinkedList<>();
        zones.add(new Zone(pointer,Length,Name));
    }

    public LinkedList<Zone> getZones() {
        return zones;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
}

    public int getPointer() {
        return pointer;
    }

    public int getSize() {
        return size;
    }
    /**
     * 展示存储空间分配情况
     */
    public void showMemory() {
        System.out.println("------------------------------------");
        System.out.println("作业名字\t分区大小\t");
        System.out.println("------------------------------------");
        for (pointer = 0; pointer < zones.size(); pointer++) {
            Zone tmp = zones.get(pointer);
            if (tmp.isFree) tmp.name = "空闲区";
            System.out.println(tmp.name + "\t" + tmp.size + "\t\t");
        }
        System.out.println("------------------------------------");
    }
    /**
     * 展示内存分区状况
     */
    public void showZones(){
        System.out.println("------------------------------------");
        System.out.println("分区编号\t分区始址\t分区大小\t空闲状态\t");
        System.out.println("------------------------------------");
        for (pointer = 0; pointer < zones.size(); pointer++){
            Zone tmp = zones.get(pointer);
            if(tmp.isFree)  tmp.name = "空闲区";
            System.out.println(pointer + "\t\t" + tmp.head + "\t\t" +
                    tmp.size + "\t\t" + tmp.isFree);
        }
        System.out.println("------------------------------------");
    }
    Scanner in = new Scanner(System.in);
    /**
     * 执行分配
     * @param size 申请大小
     * @param location 当前可用分区位置
     * @param tmp 可用空闲区
     * @param Name  分区名字
     */
    public void doAllocation(int size,int location, Zone tmp, String Name){
        //
        if(tmp.size - size <= MIN_SIZE) {
            zones.add(location,tmp);
            tmp.name = Name;
            tmp.isFree = false;
        }
        else{
            Zone split = new Zone(tmp.head+size,tmp.size-size,Name);
            zones.add(location+1,split);
            tmp.size = size;
            tmp.name = Name;
            tmp.isFree = false;
        }
        System.out.println("成功分配"+Name+"\t"+size+"KB内存！");
    }
    /**
     * 内存回收
     */
    public void collection(){
        System.out.print("输入要回收的分区号:");
        int id = in.nextInt();
        if (id >= zones.size()){
            System.out.println("无此分区编号!");
            return;
        }
        Zone tmp = zones.get(id);
        int size = tmp.size;
        if (tmp.isFree) {
            System.out.println("指定分区未被分配, 无需回收");
            return;
        }
        //如果回收分区不是尾分区且后一个分区为空闲, 则与后一个分区合并
        if (id < zones.size() - 1 && zones.get(id + 1).isFree){
            Zone next = zones.get(id + 1);
            tmp.size += next.size;
            zones.remove(next);
        }
        //如果回收分区不是首分区且前一个分区为空闲, 则与前一个分区合并
        if (id > 0 && zones.get(id - 1).isFree){
            Zone previous = zones.get(id - 1);
            previous.size += tmp.size;
            zones.remove(id);
            id--;
        }
        zones.get(id).isFree = true;
        System.out.println("内存回收成功!, 本次回收了 " + size + "KB 空间!");
    }
    /**
      *首次适应算法
     */
    public void firstFit() {
        String name;
        int size;
//        int head;
        System.out.print("请输入分配进程的名称：");
        name = in.next();
//        System.out.print("请输入分配内存的始址：");
//        head = in.nextInt();
        System.out.print("请输入分配内存的大小：");
        size = in.nextInt();

        Memory memory = new Memory(name, size);


        for (pointer = 0; pointer < zones.size(); pointer++) {
            Zone tmp = zones.get(pointer);
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size,pointer,tmp,name);
                return;
            }
        }
        System.out.println("剩余空间不足，无法分配");
    }
    /**
     * 循环首次适应算法
     */
    public void nextFit(){
        //从上次分配空闲区位置开始遍历链表
        String name;
        int size;

        System.out.print("请输入分配进程的名称：");
        name = in.next();
        System.out.print("请输入分配内存的大小：");
        size = in.nextInt();

        Memory memory = new Memory(name, size);
        Zone tmp = zones.get(pointer);
        if (tmp.isFree && (tmp.size > size)){
            doAllocation(size,pointer,tmp,name);
            return;
        }
        int len = zones.size();
        int i = (pointer + 1) % len;
        for(;i != pointer; i = (i+1)%len){
            tmp = zones.get(i);
            if (tmp.isFree && (tmp.size > size)){
                doAllocation(size,i,tmp,name);
                return;
            }
        }
        //遍历结束后未找到可用分区, 则内存分配失败
        System.out.println("剩余空间不足，无法分配!");
    }
}
