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

{% gist bf99b99cf26d9a231936748c89f96b69 31 Next Permutation.py %}
