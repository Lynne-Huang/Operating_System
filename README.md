# Operating_System
利用Java模拟操作系统经典问题和算法

## 实验一——读者写者问题（3.26完成）<br>
 *  Test-and-set,这种方法无法控制读者同时读<br>
 *  synchroniz 可以实现同步读，读写互斥，写写互斥，这种是最佳方案，利用synchroniz中的方法配合使用<br>
 *  synchroniz 自己写的，配合notifyALL一起，没有系统的好<br>
 * 祥见[read_and_write](https://github.com/Lynne-Huang/Operating_System/tree/master/read_and_write "项目地址") <br>
 
## 实验二——进程调度（4.19完成）<br>
 * 利用PriorityQueue，实现优先级队列，完成进程调度<br>
 * 始终保持只执行队首进程<br>
   * 包含<br>
        *  PCB设置进程属性<br>
        *  PriorityQueue队列排序<br>
        *  PCB进程运行的具体操作<br>
        *  测试demo<br>
 * 祥见[process_scheduling](https://github.com/Lynne-Huang/Operating_System/tree/master/process_scheduling "项目地址") <br>
 
 ## 实验三——可变分区管理。4.29完成）<br>
 * 实验题目<br>
   * 模拟主存储器空间的分配和回收。<br>
 * 实验内容<br>
  * 在可变分区管理方式下采用循环首次适应算法实现主存分配和实现主存回收。<br>
  1.可变分区方式是按作业需要的主存空间大小来分割分区的。当要装入一个作业时，根据作业需要的主存量查看是否有足够的空闲空间，若有，则按需要量分割一个分区分配给该作业；若无，则作业不能装入。随着作业的装入、撤离，主存空间被分成许多个分区，有的分区被作业占用，而有的分区是空闲的。<br>
        ![主存分区情况](/Memory_dynamic_partition/QQ截图20180514144112.png "主存分区情况")<br>
![分区情况](/Memory_dynamic_partition/QQ截图20180514144156.png "分区情况")<br>
  其中，起址——指出一个空闲区的主存起始地址。<br>
      长度——指出从起始地址开始的一个连续空闲的长度。<br>
      状态——有两种状态，一种是“未分配”状态，指出对应的由起址指出的某个长度的区域是空闲区；另一种是“空表目”状态，表示表中对应的登记项目是空白（无效），可用来登记新的空闲区（例如，作业撤离后，它所占的区域就成了空闲区，应找一个“空表目”栏登记归还区的起址和长度且修改状态）。由于分区的个数不定，所以空闲区说明表中应有适量的状态为“空表目”的登记栏目，否则造成表格“溢出”无法登记。<br>
![首次适应算法](/Memory_dynamic_partition/QQ图片20180514153931.png "首次适应算法")<br>
                                首次适应算法<br>
![主存回收算法](/Memory_dynamic_partition/QQ图片20180514154005.png "主存回收算法")<br>
                               主存回收算法<br>
  2.采用循环首次适应算法分配主存空间。<br>
该算法是首次适应算法的变种。在分配内存空间时，不是每次从表头（链首）开始查找，而是从上次找到空闲区的下一个空闲开始查找，直到找到第一个能满足要求的的空闲区为止，并从中划出一块与请求大小相等的内存空间分配给作业。该算法能使内存中的空闲区分布得较均匀。<br>
  3.当一个作业执行结束撤离时，作业所占的区域应该归还，归还的区域如果与其它空闲区相邻，则应合成一个较大的空闲区，登记在空闲区说明表中。<br>
## 程序运行结果分析
![运行结果1](/Memory_dynamic_partition/1.png "运行结果1")<br>
![运行结果2](/Memory_dynamic_partition/2.png "运行结果2")<br>
![运行结果3](/Memory_dynamic_partition/3.png "运行结果3")<br>
![运行结果4](/Memory_dynamic_partition/4.png "运行结果4")<br>
![运行结果5](/Memory_dynamic_partition/5.png "运行结果5")<br>
![运行结果6](/Memory_dynamic_partition/6.png "运行结果6")<br>
  本次实验实现了内存首次适应算法和循环首次适应算法，还有内存的回收。代码详见：[Memory_dynamic_partition](https://github.com/Lynne-Huang/Operating_System/tree/master/Memory_dynamic_partition/src "项目地址") <br>
## 实验四 文件操作（5.20完成）<br>
 * 实验题目<br>
   * 文件操作<br>
 * 实验目的<br>
    * 熟悉流式文件的读写操作<br>
 * 实验内容<br>
    * 设有一个含‘AB’字符串的流式文件“readme.txt”，请设计一个程序将“readme.txt”中所有的“AB”字符串删除并生成一个新的文件“new\readme2.txt”.<br>
 * 思路<br>
  1.将文件内容读入字符串数组<br>
  2.用正则表达式将字符串内容切割<br>
  3.将字符串内容保存到目标文件中<br>
 * 实验结果<br>
  1.运行程序前先创建readme.txt文件<br>
   ![运行结果1](/file_operation/1.png "运行结果1")<br>
  2.运行程序前先创建weiteme.txt文件<br>
   ![运行结果2](/file_operation/2.png "运行结果2")<br>
  3.运行程序 <br>
   ![运行结果3](/file_operation/3.png "运行结果3")<br>
  4创建了一个writem.txt文件<br>
   ![运行结果4](/file_operation/4.png "运行结果4")<br>
  5.删除AB后的文本也保存在目标文件中 <br>
   ![运行结果5](/file_operation/5.png "运行结果5")<br>

 

 
