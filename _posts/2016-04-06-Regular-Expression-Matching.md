---
layout: post
author: delbao
title: Regular Expression Matching 
tag: leetcode
---

及变形
 
fb的常考题, uber也考过.
 
思路: recursion是基本的结构: 假设s为待匹配string, p为pattern. 当前要匹配si和pi位置的char. 因为有*的存在, 自然分成两种case: 就是有*和没有*.  如果不是*, 只比较当前2个字符. 如果遇到*, 需要loop si当前位置所有向右(recursion)或者向左(dp)的相同char. 每一个会产生一个新的递归分支. 注意skip当前字符也是一个分支.
 
recursion:
base condition: 因为递归是向右, 所以如果pi超过pattern, 递归结束.
因为*是和左边的字符关联的, 递归向右的情况, 其条件是p[pi+1]=='*'.
 
dp:
base condition: p向右移动
以当前字符是否为*作为条件
 
扩展:
yelp的面经上见过,
 
{% gist bf99b99cf26d9a231936748c89f96b69 10 Regular Expression Matching.py %}
