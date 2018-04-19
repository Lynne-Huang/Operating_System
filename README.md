# Operating_System
利用Java模拟操作系统经典问题和算法

# 利用Java模拟操作系统经典问题和算法
<br>
## 实验一——读者写者问题（3.26完成）
  *Test-and-set,这种方法无法控制读者同时读<br>
  *synchroniz 可以实现同步读，读写互斥，写写互斥，这种是最佳方案，利用synchroniz中的方法配合使用<br>
  *synchroniz 自己写的，配合notifyALL一起，没有系统的好<br>

## 实验二——进程调度（4.19完成）
 *利用PriorityQueue，实现优先级队列，完成进程调度<br>
 *始终保持只执行队首进程
 *包含
    *PCB设置进程属性
    *PriorityQueue队列排序
    *PCB进程运行的具体操作
    *测试demo
 *祥见process_scheduling
 
