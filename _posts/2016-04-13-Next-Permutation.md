---
layout: post
author: delbao
title: Next Permutation 
tag: leetcode
---

要点：从后向前逆序列中第一个正序，然后找到逆序列中比这个数大的下一个来交换
错误点：
 
- python的bisect需要正向sorted的array，所以先reverse再binary search
- 最后一个permutation的下一个是正向第一个，只做reverse不用交换

{% gist 65b9fcd6ee3ace89649a6cc59c3af4ad %}
