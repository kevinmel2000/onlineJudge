---
layout: post
author: delbao
title: Substring with Concatenation of All Words 
tag: leetcode
---

要点：用map对words计数，founds表示已经匹配的，patterns表示总共的。从左边words长度内的每一个点作为开始点，用sliding window来找到符合条件的串（记录start，根据当前的匹配情况移动start）。用总共匹配的word数目就可以判断是否找到匹配，而不需要比较每一个word的occurance。
错误点：
 
- 当找到一个匹配后，不需要移动start来重置。因为这时候founds里面全等于patterns，下一个word将会根据情况重置start
- inner while loop：在检查当前word的时候，inner loop的条件是founds[cw]==patterns[cw]。注意==的条件，因为当前word还没有加入，需要去掉至少一个cw（同时还有所有左边从start开始的其他words)。另外不可能founds里的个数>patterns。当然最终因为founds[cw]<patterns[cw]，需要在loop外面+1
 
 {% gist bf99b99cf26d9a231936748c89f96b69 30 Substring with Concatenation of All Words.py %}
