---
layout: post
author: delbao
title: Course Schedule I/II
tag: leetcode
---

要点：
 
- 有向图的topological sort，indegree方法需要图结构吗？需要，因为每层遍历是根据图得到连接关系更新indegree的
- 图的dfs方法，虽然可以在recursion call之前或者之后更新visited，但是最好统一，这样不会出错。对这题，
    - visited在call外判断，call内更新，
    - recStk在call内开始进，call内结束出
    - 注意res在call内结束入（因为深层的排前面），不pop
 
错误点：
 
- 一个非常tricky的错误是对邻接点先检查visited，然后检查是否在recStk。实际上如果有环，肯定另一端已经visited了，这样不会返回false，正确的方法应该先检查是否在recStk里
 
 {% gist bf99b99cf26d9a231936748c89f96b69 207 Course Schedule.py %}
 
 {% gist bf99b99cf26d9a231936748c89f96b69 210 Course Schedule II.py %}
