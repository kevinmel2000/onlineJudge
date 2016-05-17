---
layout: post
author: delbao
title: Valid Number
tag: leetcode
---

要点：用几个boolean flag来区分状态：spa，exp，dot，num。为了简化程序，单向pass开始的空格和’+’/’-’。这些boolean状态flag只是在之后的main loop里标记状态
 
- spa：用来标记空格不在字符中出现，所以当遇到空格并且spa为False，ok，如果非空格但是spa为True，false。所以这里用if … elif ...来处理
- num: 一旦在num里，除了dot不能出现其他字符。另外num用来作为返回值和排除exp没有number的情况（“.”)
- exp：一旦在exp里，不能再出现dot，
- dot：exp和dot有一点不同，前者必须在num里，后者不用
- 再次出现’+’/‘-’：不一定是第二次，意思是在main loop里num之后，那么左边必须为exp

{% gist 8aa1e5a1186dbb4e991154dde3f6d146 %}
