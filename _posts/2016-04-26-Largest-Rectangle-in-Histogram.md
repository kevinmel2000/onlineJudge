---
layout: post
author: delbao
title: Largest Rectangle in Histogram
tag: leetcode
---

这题就是背吧，实际考的概率比较小，考的时候千万别装逼，直说自己见过。
如何背？
 
- 画面感要强
- 先递增入栈 => 一个低的卡在那，先出栈作为高度，然后栈头作为left => 卡在那的知道又递增了再入栈
- 最后以n做右边界重复上面低的卡在那的逻辑

{% gist bf99b99cf26d9a231936748c89f96b69  84 Largest Rectangle in Histogram.py %}

