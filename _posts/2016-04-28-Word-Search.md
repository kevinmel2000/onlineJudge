---
layout: post
author: delbao
title: Word Search
tag: leetcode
---

要点：题目不难，但是dfs有很多要素，可以有很多方式组织实现，关键是如何固定实现从而使code的错误最小。
 
- visited要在dfs函数开头set，而在函数结尾reset。同理，当前字符的匹配也在开始
- 这样看出规律，都是在函数内检查pass-in参数的状况，这样是最精简的code
- 一般True的结束条件是超过边界，但是这题的特殊在于，如果超过border是不进一步dfs的，所以没机会返回True。因此，要在最后一个字符匹配后返回True。同样如果所有dfs都fail掉最终返回False
 
错误点：
 
- word的index和board的index是分开的，起始点word总是0，而board是i,j循环变量
- 如果用1d index，算法会很慢

{% gist 50bb572a27f18f8d706b2170fbb1d4a2 %}
