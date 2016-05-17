---
layout: post
author: delbao
title: Count of Smaller Numbers After Self
tag: leetcode
---

要点：先看清题，逆序（inversion number）意思是右边小。方法merge sort：统计逆序数piggyback到排序上。相关的data structure：nums（输入），index（对index的排序，值是在nums中的index），count（对应每个nums中的逆序数）。抛开表面上方法的复杂，本质上就是两个sorted arrays，已知单个array的逆序数，如何进一步update每个数的逆序数。
答疑：
 
- 为什么merge sort可行？原理就是一个数的逆序数可以从小范围到大范围累加
- 为什么不对输入nums排序而是要对index？因为要记录count，所以输入的元素在过程中是不能变位置的。所以加入index，这样可以从nums里得到值，同时可以记录在输入nums里的count
- 为什么每次merge只累加rightcount？基本规律是左边小update，右边小累加rightcount。这样做的意思是在当前位置如果right小，那么说明所有之后的left元素的逆序数里都会包括该right，所以之后的left按rightcont更新要+1。而right的元素是不用更新的，因为本来就位于原数组右边，内部早已经统计好了
- 为什么统计逆序，但是排序还是正向的？因为merge的作用就是update逆序数，只有subarray排好序了，上述rightcount的更新规律才适用（即后面的left都大于）
- 要记就记图像感

