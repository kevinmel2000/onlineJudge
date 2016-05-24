---
layout: post
author: delbao
title: Reverse Linked List II
tag: leetcode
---

要点：和k-group类似，要点上唯一的区别是k-group那题如果不够k个结点，不reverse，所以不能one-pass，这题可以one-pass
 
- 已经多次见过了cur，cur.next的模式，cur是pre，cur.next是当前要处理的结点
- 计数：m：因为要落在开始结点的前一个，所以是从dummy开始，移动次数为m-1（这里记忆方法是移动次数+1是覆盖的结点数，而loop是移动次数>0），java中可以用--m>0来表示，python只能m先-1。n：这里的loop是要处理的结点个数，所以是n-m+1
- reverse两步走：结点组reverse：切记pre初始为null而不是前一个点，外部连接是分开进行的。对外部连接，只要记住是reverse的过程是不会自动连好外部结点就可以了。

{% gist bf99b99cf26d9a231936748c89f96b69 92 Reverse Linked List II.py %}
