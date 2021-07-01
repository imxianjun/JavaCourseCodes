# GCAnalysis

## 打印GC日志

```
java -XX:+PrintGCDetails GCLogAnalysis
```

```
java -XX:+PrintGCDetails -Xmx1g -Xms1g GCLogAnalysis
```

```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx1g -Xms1g GCLogAnalysis
```

```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc.demo.log -Xmx1g -Xms1g GCLogAnalysis
```

```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx512m -Xms512m GCLogAnalysis
```

```
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xmx256m -Xms256m GCLogAnalysis
```

## GC策略

### 串行 GC

```
-XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseSerialGC
```

#### 日志

```
正在执行...
2021-06-29T15:02:15.447-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.447-0800: [DefNew: 279616K->34944K(314560K), 0.0461833 secs] 279616K->83477K(1013632K), 0.0462162 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2021-06-29T15:02:15.533-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.533-0800: [DefNew: 313962K->34943K(314560K), 0.0507939 secs] 362495K->152470K(1013632K), 0.0508228 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2021-06-29T15:02:15.614-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.614-0800: [DefNew: 314559K->34943K(314560K), 0.0449724 secs] 432086K->231763K(1013632K), 0.0450040 secs] [Times: user=0.03 sys=0.02, real=0.04 secs] 
2021-06-29T15:02:15.694-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.694-0800: [DefNew: 314559K->34943K(314560K), 0.0451149 secs] 511379K->305267K(1013632K), 0.0451566 secs] [Times: user=0.02 sys=0.01, real=0.04 secs] 
2021-06-29T15:02:15.772-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.772-0800: [DefNew: 314559K->34943K(314560K), 0.0443751 secs] 584883K->387078K(1013632K), 0.0444058 secs] [Times: user=0.02 sys=0.02, real=0.04 secs] 
2021-06-29T15:02:15.847-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.847-0800: [DefNew: 314559K->34943K(314560K), 0.0479664 secs] 666694K->466411K(1013632K), 0.0479958 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2021-06-29T15:02:15.927-0800: [GC (Allocation Failure) 2021-06-29T15:02:15.927-0800: [DefNew: 314510K->34944K(314560K), 0.0508189 secs] 745978K->544024K(1013632K), 0.0508469 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2021-06-29T15:02:16.013-0800: [GC (Allocation Failure) 2021-06-29T15:02:16.013-0800: [DefNew: 314560K->34944K(314560K), 0.0584802 secs] 823640K->620068K(1013632K), 0.0585130 secs] [Times: user=0.03 sys=0.02, real=0.06 secs] 
2021-06-29T15:02:16.121-0800: [GC (Allocation Failure) 2021-06-29T15:02:16.121-0800: [DefNew: 314560K->34944K(314560K), 0.0639987 secs] 899684K->698326K(1013632K), 0.0640362 secs] [Times: user=0.03 sys=0.02, real=0.06 secs] 
2021-06-29T15:02:16.225-0800: [GC (Allocation Failure) 2021-06-29T15:02:16.225-0800: [DefNew: 314560K->314560K(314560K), 0.0000139 secs]2021-06-29T15:02:16.225-0800: [Tenured: 663382K->385938K(699072K), 0.0811198 secs] 977942K->385938K(1013632K), [Metaspace: 3368K->3368K(1056768K)], 0.0811813 secs] [Times: user=0.07 sys=0.00, real=0.08 secs] 
执行结束!共生成对象次数:10513
Heap
 def new generation   total 314560K, used 37401K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,  13% used [0x0000000780000000, 0x00000007824864b0, 0x0000000791110000)
  from space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
  to   space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)
 tenured generation   total 699072K, used 385938K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 699072K,  55% used [0x0000000795550000, 0x00000007ace34918, 0x00000007ace34a00, 0x00000007c0000000)
 Metaspace       used 3509K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 384K, capacity 388K, committed 512K, reserved 1048576K
```

### 并行 GC

```
-XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseParallelGC
```

#### 日志

```
正在执行...
2021-06-29T14:12:33.878-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43504K(305664K)] 262144K->79380K(1005056K), 0.0199603 secs] [Times: user=0.03 sys=0.06, real=0.02 secs] 
2021-06-29T14:12:33.935-0800: [GC (Allocation Failure) [PSYoungGen: 305648K->43511K(305664K)] 341524K->149958K(1005056K), 0.0322464 secs] [Times: user=0.05 sys=0.11, real=0.03 secs] 
2021-06-29T14:12:33.995-0800: [GC (Allocation Failure) [PSYoungGen: 305507K->43517K(305664K)] 411954K->229729K(1005056K), 0.0273559 secs] [Times: user=0.07 sys=0.09, real=0.03 secs] 
2021-06-29T14:12:34.051-0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43519K(305664K)] 491873K->300163K(1005056K), 0.0218397 secs] [Times: user=0.06 sys=0.07, real=0.02 secs] 
2021-06-29T14:12:34.101-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43517K(305664K)] 562307K->376888K(1005056K), 0.0233488 secs] [Times: user=0.06 sys=0.09, real=0.02 secs] 
2021-06-29T14:12:34.150-0800: [GC (Allocation Failure) [PSYoungGen: 305661K->43516K(305664K)] 639032K->460423K(1005056K), 0.0254058 secs] [Times: user=0.07 sys=0.08, real=0.02 secs] 
2021-06-29T14:12:34.211-0800: [GC (Allocation Failure) [PSYoungGen: 305660K->43509K(305664K)] 722567K->541507K(1005056K), 0.0247867 secs] [Times: user=0.07 sys=0.09, real=0.02 secs] 
2021-06-29T14:12:34.263-0800: [GC (Allocation Failure) [PSYoungGen: 305653K->43509K(305664K)] 803651K->612160K(1005056K), 0.0241824 secs] [Times: user=0.08 sys=0.10, real=0.02 secs] 
2021-06-29T14:12:34.315-0800: [GC (Allocation Failure) [PSYoungGen: 305653K->43511K(305664K)] 874304K->679148K(1005056K), 0.0226872 secs] [Times: user=0.07 sys=0.08, real=0.02 secs] 
2021-06-29T14:12:34.337-0800: [Full GC (Ergonomics) [PSYoungGen: 43511K->0K(305664K)] [ParOldGen: 635637K->335694K(699392K)] 679148K->335694K(1005056K), [Metaspace: 3370K->3370K(1056768K)], 0.0514307 secs] [Times: user=0.26 sys=0.02, real=0.05 secs] 
2021-06-29T14:12:34.428-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43507K(305664K)] 597838K->411988K(1005056K), 0.0082162 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2021-06-29T14:12:34.470-0800: [GC (Allocation Failure) [PSYoungGen: 305651K->43519K(305664K)] 674132K->481032K(1005056K), 0.0122450 secs] [Times: user=0.09 sys=0.00, real=0.01 secs] 
2021-06-29T14:12:34.517-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43508K(305664K)] 743176K->563010K(1005056K), 0.0130158 secs] [Times: user=0.10 sys=0.00, real=0.02 secs] 
2021-06-29T14:12:34.567-0800: [GC (Allocation Failure) [PSYoungGen: 305652K->43518K(305664K)] 825154K->642084K(1005056K), 0.0130148 secs] [Times: user=0.09 sys=0.00, real=0.02 secs] 
2021-06-29T14:12:34.580-0800: [Full GC (Ergonomics) [PSYoungGen: 43518K->0K(305664K)] [ParOldGen: 598566K->364527K(699392K)] 642084K->364527K(1005056K), [Metaspace: 3370K->3370K(1056768K)], 0.0428469 secs] [Times: user=0.26 sys=0.01, real=0.04 secs] 
2021-06-29T14:12:34.667-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43516K(305664K)] 626671K->445137K(1005056K), 0.0088270 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2021-06-29T14:12:34.713-0800: [GC (Allocation Failure) [PSYoungGen: 305660K->43518K(305664K)] 707281K->518661K(1005056K), 0.0140633 secs] [Times: user=0.08 sys=0.00, real=0.01 secs] 
执行结束!共生成对象次数:15070
Heap
 PSYoungGen      total 305664K, used 134439K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 262144K, 34% used [0x00000007aab00000,0x00000007b03ca648,0x00000007bab00000)
  from space 43520K, 99% used [0x00000007bab00000,0x00000007bd57f878,0x00000007bd580000)
  to   space 43520K, 0% used [0x00000007bd580000,0x00000007bd580000,0x00000007c0000000)
 ParOldGen       total 699392K, used 475143K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
  object space 699392K, 67% used [0x0000000780000000,0x000000079d001d60,0x00000007aab00000)
 Metaspace       used 3376K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 374K, capacity 388K, committed 512K, reserved 1048576K
```

### CMS GC

```
-XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseConcMarkSweepGC
```

#### 日志

```
正在执行...
2021-06-29T14:16:48.501-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.501-0800: [ParNew: 279616K->34944K(314560K), 0.0190054 secs] 279616K->77456K(1013632K), 0.0190537 secs] [Times: user=0.04 sys=0.06, real=0.02 secs] 
2021-06-29T14:16:48.555-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.555-0800: [ParNew: 314560K->34944K(314560K), 0.0326778 secs] 357072K->166609K(1013632K), 0.0327097 secs] [Times: user=0.08 sys=0.12, real=0.03 secs] 
2021-06-29T14:16:48.620-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.620-0800: [ParNew: 314560K->34943K(314560K), 0.0403663 secs] 446225K->238414K(1013632K), 0.0403989 secs] [Times: user=0.22 sys=0.02, real=0.04 secs] 
2021-06-29T14:16:48.692-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.692-0800: [ParNew: 314559K->34944K(314560K), 0.0429084 secs] 518030K->314831K(1013632K), 0.0429412 secs] [Times: user=0.27 sys=0.02, real=0.04 secs] 
2021-06-29T14:16:48.764-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.764-0800: [ParNew: 314560K->34944K(314560K), 0.0518062 secs] 594447K->400649K(1013632K), 0.0518409 secs] [Times: user=0.33 sys=0.03, real=0.05 secs] 
2021-06-29T14:16:48.816-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 365705K(699072K)] 400944K(1013632K), 0.0001908 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:48.816-0800: [CMS-concurrent-mark-start]
2021-06-29T14:16:48.819-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:48.819-0800: [CMS-concurrent-preclean-start]
2021-06-29T14:16:48.820-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2021-06-29T14:16:48.820-0800: [CMS-concurrent-abortable-preclean-start]
2021-06-29T14:16:48.851-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.851-0800: [ParNew: 314560K->34943K(314560K), 0.0415997 secs] 680265K->476219K(1013632K), 0.0416317 secs] [Times: user=0.26 sys=0.02, real=0.04 secs] 
2021-06-29T14:16:48.923-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.923-0800: [ParNew: 314559K->34942K(314560K), 0.0372545 secs] 755835K->543464K(1013632K), 0.0372861 secs] [Times: user=0.21 sys=0.02, real=0.04 secs] 
2021-06-29T14:16:48.991-0800: [GC (Allocation Failure) 2021-06-29T14:16:48.991-0800: [ParNew: 314558K->34942K(314560K), 0.0502068 secs] 823080K->622243K(1013632K), 0.0502396 secs] [Times: user=0.25 sys=0.03, real=0.05 secs] 
2021-06-29T14:16:49.072-0800: [GC (Allocation Failure) 2021-06-29T14:16:49.072-0800: [ParNew: 314558K->34942K(314560K), 0.0482338 secs] 901859K->708555K(1013632K), 0.0482667 secs] [Times: user=0.24 sys=0.03, real=0.05 secs] 
2021-06-29T14:16:49.120-0800: [CMS-concurrent-abortable-preclean: 0.007/0.301 secs] [Times: user=1.09 sys=0.10, real=0.30 secs] 
2021-06-29T14:16:49.120-0800: [GC (CMS Final Remark) [YG occupancy: 35527 K (314560 K)]2021-06-29T14:16:49.120-0800: [Rescan (parallel) , 0.0020093 secs]2021-06-29T14:16:49.122-0800: [weak refs processing, 0.0004197 secs]2021-06-29T14:16:49.123-0800: [class unloading, 0.0002727 secs]2021-06-29T14:16:49.123-0800: [scrub symbol table, 0.0003373 secs]2021-06-29T14:16:49.123-0800: [scrub string table, 0.0001481 secs][1 CMS-remark: 673612K(699072K)] 709139K(1013632K), 0.0032323 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.124-0800: [CMS-concurrent-sweep-start]
2021-06-29T14:16:49.125-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.125-0800: [CMS-concurrent-reset-start]
2021-06-29T14:16:49.127-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.155-0800: [GC (Allocation Failure) 2021-06-29T14:16:49.155-0800: [ParNew: 314558K->34943K(314560K), 0.0157769 secs] 866070K->659873K(1013632K), 0.0158138 secs] [Times: user=0.09 sys=0.00, real=0.02 secs] 
2021-06-29T14:16:49.171-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 624929K(699072K)] 660466K(1013632K), 0.0001959 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.171-0800: [CMS-concurrent-mark-start]
2021-06-29T14:16:49.173-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.173-0800: [CMS-concurrent-preclean-start]
2021-06-29T14:16:49.174-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2021-06-29T14:16:49.174-0800: [CMS-concurrent-abortable-preclean-start]
2021-06-29T14:16:49.202-0800: [GC (Allocation Failure) 2021-06-29T14:16:49.202-0800: [ParNew: 314559K->314559K(314560K), 0.0000167 secs]2021-06-29T14:16:49.202-0800: [CMS2021-06-29T14:16:49.202-0800: [CMS-concurrent-abortable-preclean: 0.001/0.028 secs] [Times: user=0.03 sys=0.00, real=0.03 secs] 
 (concurrent mode failure): 624929K->371096K(699072K), 0.0883300 secs] 939489K->371096K(1013632K), [Metaspace: 3369K->3369K(1056768K)], 0.0884522 secs] [Times: user=0.09 sys=0.00, real=0.09 secs] 
2021-06-29T14:16:49.347-0800: [GC (Allocation Failure) 2021-06-29T14:16:49.347-0800: [ParNew: 279616K->34943K(314560K), 0.0165084 secs] 650712K->452378K(1013632K), 0.0165490 secs] [Times: user=0.10 sys=0.00, real=0.02 secs] 
执行结束!共生成对象次数:12538
Heap
 par new generation   total 314560K, used 50052K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,   5% used [0x0000000780000000, 0x0000000780ec10f8, 0x0000000791110000)
  from space 34944K,  99% used [0x0000000793330000, 0x000000079554ff18, 0x0000000795550000)
  to   space 34944K,   0% used [0x0000000791110000, 0x0000000791110000, 0x0000000793330000)
 concurrent mark-sweep generation total 699072K, used 417434K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 3375K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 374K, capacity 388K, committed 512K, reserved 1048576K
```

#### 4G 内存参数

```
-XX:+PrintGCDetails -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC
```

#### 日志

```
正在执行...
2021-06-29T14:19:47.633-0800: [GC (Allocation Failure) 2021-06-29T14:19:47.633-0800: [ParNew: 545344K->68096K(613440K), 0.0370266 secs] 545344K->153120K(4126208K), 0.0370729 secs] [Times: user=0.10 sys=0.14, real=0.04 secs] 
2021-06-29T14:19:47.747-0800: [GC (Allocation Failure) 2021-06-29T14:19:47.747-0800: [ParNew: 613440K->68096K(613440K), 0.0553603 secs] 698464K->280681K(4126208K), 0.0553992 secs] [Times: user=0.10 sys=0.14, real=0.06 secs] 
2021-06-29T14:19:47.871-0800: [GC (Allocation Failure) 2021-06-29T14:19:47.871-0800: [ParNew: 613440K->68094K(613440K), 0.0829701 secs] 826025K->401880K(4126208K), 0.0830031 secs] [Times: user=0.48 sys=0.04, real=0.08 secs] 
2021-06-29T14:19:48.018-0800: [GC (Allocation Failure) 2021-06-29T14:19:48.018-0800: [ParNew: 613438K->68096K(613440K), 0.0920158 secs] 947224K->529231K(4126208K), 0.0920684 secs] [Times: user=0.45 sys=0.04, real=0.10 secs] 
2021-06-29T14:19:48.169-0800: [GC (Allocation Failure) 2021-06-29T14:19:48.169-0800: [ParNew: 613440K->68096K(613440K), 0.0872247 secs] 1074575K->663854K(4126208K), 0.0872562 secs] [Times: user=0.33 sys=0.04, real=0.09 secs] 
2021-06-29T14:19:48.326-0800: [GC (Allocation Failure) 2021-06-29T14:19:48.326-0800: [ParNew: 613440K->68094K(613440K), 0.0794389 secs] 1209198K->786854K(4126208K), 0.0794787 secs] [Times: user=0.33 sys=0.03, real=0.08 secs] 
执行结束!共生成对象次数:12367
Heap
 par new generation   total 613440K, used 100747K [0x00000006c0000000, 0x00000006e9990000, 0x00000006e9990000)
  eden space 545344K,   5% used [0x00000006c0000000, 0x00000006c1fe33b0, 0x00000006e1490000)
  from space 68096K,  99% used [0x00000006e1490000, 0x00000006e570f900, 0x00000006e5710000)
  to   space 68096K,   0% used [0x00000006e5710000, 0x00000006e5710000, 0x00000006e9990000)
 concurrent mark-sweep generation total 3512768K, used 718760K [0x00000006e9990000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 3379K, capacity 4500K, committed 4864K, reserved 1056768K
  class space    used 375K, capacity 388K, committed 512K, reserved 1048576K
```

### G1 GC

```
-XX:+PrintGC -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx1g -Xms1g -XX:+UseG1GC
```

#### 日志

```
正在执行...
2021-06-29T14:22:08.754-0800: [GC pause (G1 Evacuation Pause) (young) 61M->19M(1024M), 0.0051148 secs]
2021-06-29T14:22:08.774-0800: [GC pause (G1 Evacuation Pause) (young) 73M->38M(1024M), 0.0053382 secs]
2021-06-29T14:22:08.790-0800: [GC pause (G1 Evacuation Pause) (young) 96M->58M(1024M), 0.0044246 secs]
2021-06-29T14:22:08.824-0800: [GC pause (G1 Evacuation Pause) (young) 162M->98M(1024M), 0.0071097 secs]
2021-06-29T14:22:08.854-0800: [GC pause (G1 Evacuation Pause) (young) 205M->136M(1024M), 0.0092029 secs]
2021-06-29T14:22:08.897-0800: [GC pause (G1 Evacuation Pause) (young) 275M->175M(1024M), 0.0089313 secs]
2021-06-29T14:22:08.944-0800: [GC pause (G1 Evacuation Pause) (young) 345M->229M(1024M), 0.0122697 secs]
2021-06-29T14:22:09.001-0800: [GC pause (G1 Evacuation Pause) (young) 423M->282M(1024M), 0.0157939 secs]
2021-06-29T14:22:09.196-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 796M->388M(1024M), 0.0266886 secs]
2021-06-29T14:22:09.222-0800: [GC concurrent-root-region-scan-start]
2021-06-29T14:22:09.223-0800: [GC concurrent-root-region-scan-end, 0.0001763 secs]
2021-06-29T14:22:09.223-0800: [GC concurrent-mark-start]
2021-06-29T14:22:09.225-0800: [GC concurrent-mark-end, 0.0023590 secs]
2021-06-29T14:22:09.225-0800: [GC remark, 0.0009226 secs]
2021-06-29T14:22:09.226-0800: [GC cleanup 407M->395M(1024M), 0.0006417 secs]
2021-06-29T14:22:09.227-0800: [GC concurrent-cleanup-start]
2021-06-29T14:22:09.227-0800: [GC concurrent-cleanup-end, 0.0000167 secs]
2021-06-29T14:22:09.255-0800: [GC pause (G1 Evacuation Pause) (young) 573M->419M(1024M), 0.0165200 secs]
2021-06-29T14:22:09.277-0800: [GC pause (G1 Evacuation Pause) (mixed) 450M->366M(1024M), 0.0094233 secs]
2021-06-29T14:22:09.309-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 494M->400M(1024M), 0.0031451 secs]
2021-06-29T14:22:09.312-0800: [GC concurrent-root-region-scan-start]
2021-06-29T14:22:09.312-0800: [GC concurrent-root-region-scan-end, 0.0001127 secs]
2021-06-29T14:22:09.312-0800: [GC concurrent-mark-start]
2021-06-29T14:22:09.313-0800: [GC concurrent-mark-end, 0.0014241 secs]
2021-06-29T14:22:09.314-0800: [GC remark, 0.0017374 secs]
2021-06-29T14:22:09.315-0800: [GC cleanup 411M->408M(1024M), 0.0007124 secs]
2021-06-29T14:22:09.316-0800: [GC concurrent-cleanup-start]
2021-06-29T14:22:09.316-0800: [GC concurrent-cleanup-end, 0.0000104 secs]
2021-06-29T14:22:09.406-0800: [GC pause (G1 Evacuation Pause) (young)-- 862M->681M(1024M), 0.0115385 secs]
2021-06-29T14:22:09.419-0800: [GC pause (G1 Evacuation Pause) (mixed) 688M->628M(1024M), 0.0106352 secs]
2021-06-29T14:22:09.430-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 629M->629M(1024M), 0.0031665 secs]
2021-06-29T14:22:09.433-0800: [GC concurrent-root-region-scan-start]
2021-06-29T14:22:09.433-0800: [GC concurrent-root-region-scan-end, 0.0001184 secs]
2021-06-29T14:22:09.433-0800: [GC concurrent-mark-start]
2021-06-29T14:22:09.435-0800: [GC concurrent-mark-end, 0.0018866 secs]
2021-06-29T14:22:09.435-0800: [GC remark, 0.0023240 secs]
2021-06-29T14:22:09.438-0800: [GC cleanup 639M->635M(1024M), 0.0009117 secs]
2021-06-29T14:22:09.439-0800: [GC concurrent-cleanup-start]
2021-06-29T14:22:09.439-0800: [GC concurrent-cleanup-end, 0.0000191 secs]
2021-06-29T14:22:09.481-0800: [GC pause (G1 Evacuation Pause) (young) 850M->685M(1024M), 0.0102336 secs]
2021-06-29T14:22:09.503-0800: [GC pause (G1 Evacuation Pause) (mixed) 716M->594M(1024M), 0.0175399 secs]
2021-06-29T14:22:09.534-0800: [GC pause (G1 Evacuation Pause) (mixed) 648M->520M(1024M), 0.0050836 secs]
2021-06-29T14:22:09.549-0800: [GC pause (G1 Evacuation Pause) (mixed) 574M->457M(1024M), 0.0050068 secs]
2021-06-29T14:22:09.563-0800: [GC pause (G1 Evacuation Pause) (mixed) 512M->461M(1024M), 0.0031258 secs]
2021-06-29T14:22:09.567-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 465M->463M(1024M), 0.0010561 secs]
2021-06-29T14:22:09.568-0800: [GC concurrent-root-region-scan-start]
2021-06-29T14:22:09.568-0800: [GC concurrent-root-region-scan-end, 0.0000937 secs]
2021-06-29T14:22:09.568-0800: [GC concurrent-mark-start]
2021-06-29T14:22:09.569-0800: [GC concurrent-mark-end, 0.0013429 secs]
2021-06-29T14:22:09.569-0800: [GC remark, 0.0013415 secs]
2021-06-29T14:22:09.571-0800: [GC cleanup 474M->467M(1024M), 0.0007630 secs]
2021-06-29T14:22:09.572-0800: [GC concurrent-cleanup-start]
2021-06-29T14:22:09.572-0800: [GC concurrent-cleanup-end, 0.0000158 secs]
2021-06-29T14:22:09.643-0800: [GC pause (G1 Evacuation Pause) (young)-- 842M->565M(1024M), 0.0159237 secs]
2021-06-29T14:22:09.661-0800: [GC pause (G1 Evacuation Pause) (mixed) 578M->495M(1024M), 0.0148246 secs]
2021-06-29T14:22:09.692-0800: [GC pause (G1 Evacuation Pause) (mixed) 552M->497M(1024M), 0.0086109 secs]
2021-06-29T14:22:09.701-0800: [GC pause (G1 Humongous Allocation) (young) (initial-mark) 499M->497M(1024M), 0.0032625 secs]
2021-06-29T14:22:09.704-0800: [GC concurrent-root-region-scan-start]
2021-06-29T14:22:09.704-0800: [GC concurrent-root-region-scan-end, 0.0001466 secs]
2021-06-29T14:22:09.704-0800: [GC concurrent-mark-start]
2021-06-29T14:22:09.707-0800: [GC concurrent-mark-end, 0.0024392 secs]
2021-06-29T14:22:09.707-0800: [GC remark, 0.0025895 secs]
2021-06-29T14:22:09.710-0800: [GC cleanup 508M->504M(1024M), 0.0018495 secs]
2021-06-29T14:22:09.712-0800: [GC concurrent-cleanup-start]
2021-06-29T14:22:09.712-0800: [GC concurrent-cleanup-end, 0.0000217 secs]
执行结束!共生成对象次数:11296
```

#### 4G 内存参数

```
-XX:+PrintGC -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDateStamps -Xmx4g -Xms4g -XX:+UseG1GC
```