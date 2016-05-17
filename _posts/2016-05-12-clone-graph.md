---
layout: post
author: delbao
title: Clone Graph
tag: leetcode
---

dfs或者bfs都可以做，这题的要点是hashmap有两个作用：一是图遍历中的visited，另一个是存copy的结点来连接边。这里visited表示已经结点展开了，所以如果已经在hashmap中存在，就可以返回了。但是如果是其他结点连过来的，还要把copy的neighbor连上。对于bfs，如果不存在于hashmap中要先创建结点，否则直接连接，对dfs，可以先递归，返回copy结点再连接。

{% gist 3196cb85de51db0325c68aaefe1392bf %}
