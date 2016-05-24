---
layout: post
author: delbao
title: Bitwise AND of Numbers Range 
tag: leetcode
---

思路: range内的数增量的特点是低位变化，高位不变直到进位。另外只要有变化，必然是1和0之间，所以AND肯定为0。所以只有在某个位左边的高位全相同的情况下才可能有AND为1的情况。
细节：只需要比较边界的2个数即可，根据变化规律，中间的数高位都是相同的。
 
这题可以扩展到XOR：如果低位是全域，那么XOR的值为全0

{% gist bf99b99cf26d9a231936748c89f96b69 201 Bitwise AND of Numbers Range.py %}
