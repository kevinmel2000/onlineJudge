---
layout: post
author: delbao
title: Remove Nth Node From End of List 
tag: leetcode
---

要点
 
- first和second指针的距离：n是从1开始计数的，所以second指向的node和被删的node之间共n个node（包括这两个边界node）。first指向被删node的前一个，这样才能进行list node的删除
- 根据上面的距离关系，first开始指向dummy，second要首先从head开始单独移动n-1步，之后移动second到最后一个node，这样first.next指向被删node。所以用second.next!=null作为循环条件

{% gist 95ad5b793634571e12712d5f12f2e562 %}
