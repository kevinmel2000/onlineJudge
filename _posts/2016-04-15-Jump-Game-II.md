---
layout: post
author: delbao
title: Jump Game II 
tag: leetcode
---

要点：dp比较容易想，但更好的办法是1d bfs，因为每一步可以走任何小于步长上限的步数。对应的边界是连续扩大的。所以如果边界超过终点，就能得到步数。
start和end的关系：end表示上一轮能reach到的点，内循环的start将走到上上一轮end，也就是已经检查过的点。因为start和end中间任何一个点已经可以reach到了，在本轮，start将走到end，来检查是否某个点可以继续扩大reach到下一轮。注意start是不根据轮数重置的，因为每个点都要检查。
错误点
 
- 根据上面的要点，下一轮的start是old end+1，而不是new end+1
- step初始为0，所以invariant是end<n-1（注意到达最后一个点而非超过也算）。step++在循环内哪里都可以因为没有提前的return
 
 {% gist bf99b99cf26d9a231936748c89f96b69 45 Jump Game II.py %}
