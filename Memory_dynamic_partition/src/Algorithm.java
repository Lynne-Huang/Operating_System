
import java.util.Scanner;

public class Algorithm {

    public static void main(String[] args){
        Memory memory = new Memory();
        int choice0;
        int choice1;
        int choice2;
        while(true){
            System.out.println("请选择：内存分配方式");
            System.out.println("1.首次适应算法");
            System.out.println("2.最佳适应算法");
            System.out.println("3.退出");
            System.out.print("请选择：");
            Scanner in = new Scanner(System.in);
            choice0 = in.nextInt();
            switch (choice0) {
                case 0: break;
                case 1:
                    do{
                        System.out.println("0.返回上一层");
                        System.out.println("1.分配内存");
                        System.out.println("2.回收内存");
                        System.out.println("3.查看分区");
                        System.out.println("4.查看存储空间分配情况");
                        System.out.print("请选择：");
                        choice1 = in.nextInt();
                        switch (choice1) {
                            case 0: break;
                            case 1:
                                do {
                                    memory.firstFit();
                                    System.out.print("是否要继续分配内存？Y[1]N[0]");
                                    choice2 = in.nextInt();
                                }while(choice2!=0);
                                break;
                            case 2:
                                memory.collection();
                                memory.showZones();
                                break;
                            case 3:
                                memory.showZones();
                                break;
                            case 4:
                                memory.showMemory();
                                break;
                            default:
                                System.out.println("请正确输入");
                                break;
                        }
                    }while (choice1 != 0);break;
                case 2:
                    do{
                        System.out.println("0.返回上一层");
                        System.out.println("1.分配内存");
                        System.out.println("2.回收内存");
                        System.out.println("3.查看内存");
                        System.out.println("4.查看存储空间分配情况");
                        System.out.print("请选择：");
                        choice1 = in.nextInt();
                        switch (choice1) {
                            case 0:
                            break;
                            case 1:
                                do {
                                    memory.nextFit();
                                    System.out.print("是否要继续分配内存？Y[1]N[0]");
                                    choice2 = in.nextInt();
                                }while(choice2!=0);
                                break;
                            case 2:
                                memory.collection();
                                memory.showZones();
                                break;
                            case 3:
                                memory.showZones();
                                break;
                            case 4:
                                memory.showMemory();
                                break;
                            default:
                                System.out.println("请正确输入");
                                break;
                        }
                    }while (choice1!=0);break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("请正确输入：");
            }
        }
    }
}
