---
layout: post
author: delbao
title: Minimum Window Substring
tag: leetcode
---

要点：同一思路的还有Substring with Concatenation of All Words, Longest Substring with At Most K Distinct Characters。基本要素是found map来记录当前sliding window中已经有的个数，用pattern map来记录满足pattern需要的个数。另外一个count变量就能知道是否当前sliding window和pattern匹配。
Substring with Concatenation of All Words这题sliding window是固定的，所以found中某元素只要个数超过了就要移动左边界来重新match。而本题超过了found个数也+1，但count保持不变。这样，每次重新移动调整左边界的内循环里也是去除无关或者超过的元素，从而保持sliding window中永远是match的，而是否sliding window中有超过pattern的字符是无所谓的。
错误点：
 
- pattern和found别搞混，这里很容易typo
- 因为只有match的情况才更新minLen，所以对不match要特殊处理

{% gist bf99b99cf26d9a231936748c89f96b69 76 Minimum Window Substring.py %}
