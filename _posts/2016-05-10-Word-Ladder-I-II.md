---
layout: post
author: delbao
title: Word Ladder I/II
tag: leetcode
---

网上著名的难题，一般被黑了都说自己被考了Word Ladder。其实这题I还好，II比较变态，不过知道答案了不难理解。
要点：
 
- 因为是最短长度，所以bfs找到的可以从字典里去掉。
- bfs从两头做最好，哪个方向集合元素少就作为下一轮的种子
 
google还考过扩展：减字符找最长路径。意思是一样的。
 

{% gist 28ea729f90e392554f1abee1779aa09c %}

{% gist 901230df47fbe3004987c5135a585dbd %}
