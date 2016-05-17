---
layout: post
author: delbao
title: leetcode 70天刷一遍
tag: leetcode
---

## 恼人的median of two sorted arrays

前几年google的必考题，现在考的比较少了，思路就是binary search，具体来说，

* 如果是一个array，因为是sorted，找到第k个元素是trivial。如果2个array，可以把一个array B作为pivot而搜索另一个array A是否有第k个。因为已知array A中第ith，找array B中(k-i)th也是trivial的。
* 如果在array A中没找到，再交换两个array重新搜索。
* 这题恶心在corner cases。找到的条件是A的第ith在B中k-1-i-1和k-1-i之间。另外两种情况是<B[k-1-i-1]和>B[k-1-i]。具体见code，建议大致明白三种情况后死记binary search的条件，反正过不久就忘了，呵呵。

![4.Median of Two Sorted Arrays]({{ site.github.url }}/images/4-Median-of-Two-Sorted-Arrays.png)

google曾经的面试题是这个的简单扩展：如果给定两个数组中的某一个数，找到离这个数第k近的数。直接用binary search找到这个数后确定次序k’，然后用上面的方法找到第(k+k’)th

{% gist 63284430 %}
