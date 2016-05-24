---
layout: post
author: delbao
title: Populating Next Right Pointers in Each Node I/II
tag: leetcode
---

要点：stack在traversal中的作用是回到root，这题只需要2层之间的关联。所以不需要stack来track。这题就归结为通过当前层连接下一层然后再到下一层。所以code pattern是
while root:
     while root:
第一个是track下一层的最左结点，第二层是本层链表的顺序访问。
I的连接范围局限在root，所以比较简单（只需要root.left连root.right，然后root.right连root.next的left）。而II因为不确定性，本质就是更新prev和next (初始为null)：next用来track头，prev用来track前一个。
 
 
{% gist bf99b99cf26d9a231936748c89f96b69  116 Populating Next Right Pointers in Each Node.py %}

{% gist bf99b99cf26d9a231936748c89f96b69 117 Populating Next Right Pointers in Each Node II.py %}
