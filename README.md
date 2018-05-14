# Operating_System
利用Java模拟操作系统经典问题和算法

## 实验一——读者写者问题（3.26完成）<br>
 *  Test-and-set,这种方法无法控制读者同时读<br>
 *  synchroniz 可以实现同步读，读写互斥，写写互斥，这种是最佳方案，利用synchroniz中的方法配合使用<br>
 *  synchroniz 自己写的，配合notifyALL一起，没有系统的好<br>

## 实验二——进程调度（4.19完成）<br>
 * 利用PriorityQueue，实现优先级队列，完成进程调度<br>
 * 始终保持只执行队首进程<br>
   * 包含<br>
        *  PCB设置进程属性<br>
        *  PriorityQueue队列排序<br>
        *  PCB进程运行的具体操作<br>
        *  测试demo<br>
 * 祥见process_scheduling<br>
 ## 实验三——可变分区管理。（4.29完成）<br>
 * 实验题目。<br>
   * 模拟主存储器空间的分配和回收。<br>
 * 实验内容。<br>
  * 在可变分区管理方式下采用循环首次适应算法实现主存分配和实现主存回收。。<br>
  1.可变分区方式是按作业需要的主存空间大小来分割分区的。当要装入一个作业时，根据作业需要的主存量查看是否有足够的空闲空间，若有，则按需要量分割一个分区分配给该作业；若无，则作业不能装入。随着作业的装入、撤离，主存空间被分成许多个分区，有的分区被作业占用，而有的分区是空闲的。<br>
 ![主存分区情况](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/QQ%E6%88%AA%E5%9B%BE20180514144112.png"主存分区情况")<br>
  ![分区情况](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/QQ%E6%88%AA%E5%9B%BE20180514144156.png"分区情况")<br>
  其中，起址——指出一个空闲区的主存起始地址。<br>
      长度——指出从起始地址开始的一个连续空闲的长度。<br>
      状态——有两种状态，一种是“未分配”状态，指出对应的由起址指出的某个长度的区域是空闲区；另一种是“空表目”状态，表示表中对应的登记项目是空白（无效），可用来登记新的空闲区（例如，作业撤离后，它所占的区域就成了空闲区，应找一个“空表目”栏登记归还区的起址和长度且修改状态）。由于分区的个数不定，所以空闲区说明表中应有适量的状态为“空表目”的登记栏目，否则造成表格“溢出”无法登记。<br>
      ![首次适应算法](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/%E9%A6%96%E6%AC%A1%E9%80%82%E5%BA%94%E7%AE%97%E6%B3%95.png"首次适应算法")<br>
  2.采用循环首次适应算法分配主存空间。<br>
该算法是首次适应算法的变种。在分配内存空间时，不是每次从表头（链首）开始查找，而是从上次找到空闲区的下一个空闲开始查找，直到找到第一个能满足要求的的空闲区为止，并从中划出一块与请求大小相等的内存空间分配给作业。该算法能使内存中的空闲区分布得较均匀。<br>
    ![循环首次适应算法](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/%E5%BE%AA%E7%8E%AF%E9%A6%96%E6%AC%A1%E9%80%82%E5%BA%94%E7%AE%97%E6%B3%95.png"循环首次适应算法")<br>
  3.当一个作业执行结束撤离时，作业所占的区域应该归还，归还的区域如果与其它空闲区相邻，则应合成一个较大的空闲区，登记在空闲区说明表中。<br>
## 程序运行结果分析
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/1.png"运行结果")<br>
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/2.png"运行结果")<br>
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/3.png"运行结果")<br>
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/4.png"运行结果")<br>
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/5.png"运行结果")<br>
![运行结果](https://github.com/Lynne-Huang/Operating_System/blob/master/Memory_dynamic_partition/6.png"运行结果")<br>
  本次实验实现了内存首次适应算法和循环首次适应算法，还有内存的回收。代码详见：[Memory_dynamic_partition](https://github.com/Lynne-Huang/Operating_System/tree/master/Memory_dynamic_partition/src "项目地址") 
