## 总结



## 默认GC 

内存较小时。发生GC的频率较高,随着堆内存变大，GC的次数会变少。另外肉眼可见的在xmx256m的情况下打印日志出现了内存溢出。但是没打印日志就没出现内存溢出。由此可见IO等用户线程条件对GC还是有很大影响的



## 串行GC 

随着堆内存的变大。虽然单次GC的时间变长了，但是
GC的效率变高了(GC的次数变少了)



## 并行GC

并行GC前期YoungGC会让老年代的数据不断增加。增加之后到达一定比例进行FullGC。FullGC会同时清除老年代和Eden区和存活区

去掉Xms第一次GC的时间会提前

并行GC的效率不一定比串行的高。在同样都Xmx512m的情况下。并行gc发生了叫多次的GC。且串行GC未发生FullGC



## CMS GC

每次GC暂停的时间较短。在大内存Xmx4g情况下使用ParNew进行了新生代的GC。。未出现CMS的六个步骤的GC,







## G1GC

在内存较大的情况下，比较有优势。GC的频率较少





## 使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar 示例

在windwos10 16G内存的机器中发现。默认的并行GC在大多数情况(xmx和xms任意配置)的并发都比CMS和G1要高。且并发数并不是随着堆内存的变大就一定变大

