---
layout: post
author: delbao
title: number of islands 
tag: leetcode
---

错误点
 
- 没检查grid element是否为1，光想着边界检测和visited check了，总共是3个条件
- visited check时机？最好是在dfs外面，在dfs里面设为true
- 小错误：grid的值是字符

{% gist 22961072f76f96dacbe0429384536048 %}
