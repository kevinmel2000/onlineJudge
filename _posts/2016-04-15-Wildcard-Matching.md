---
layout: post
author: delbao
title: Wildcard Matching 
tag: leetcode
---

要点：基本code pattern是以待匹配string s为中心loop，一旦没有任何p的分支match，返回false。如果所有s匹配了，还要检查是不是p也exhausted，一种分支是剩下的p是’*’，这样也可以匹配。
错误点：
 
- star和ss：star对应的是’*’这点在pattern中的位置，ss对应的是在上次没有swallow的s点的位置。实际上是记录了可以restore的状态

{% gist d62b2231138b161a7b1d77c6bf087627 %}
