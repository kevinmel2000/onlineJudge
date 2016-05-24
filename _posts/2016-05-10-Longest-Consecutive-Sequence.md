---
layout: post
author: delbao
title: Longest Consecutive Sequence
tag: leetcode
---

弱智了，这题总以为有一遍扫描的方法。其实需要两遍扫描，第一遍存索引，第二遍计算最长。第二遍实际就是图遍历。
确实有一遍扫描的方法，思路类似union-find，只是这题作为同一个set的条件是检查neighbor是否在map中。而只需要更新左右边界的最高长度，因为之后落入集合内的元素是不考虑的，所以只有左右边界可能作为之后元素的neighbor。
错误点：
 
- index的计算：left和right表示不包括当前元素左右的长度，所以边界在cur-left和cur+right
- 需要更新cur的长度，否则如果有duplicate会fail，比如[5,7,6,6]，正确结果是3，但是如果不更新cur的长度，第二个6将+3+3，结果变成7
 
 
 {% gist bf99b99cf26d9a231936748c89f96b69 128 Longest Consecutive Sequence.py %}
 
