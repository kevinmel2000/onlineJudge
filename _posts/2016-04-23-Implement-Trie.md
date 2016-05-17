---
layout: post
author: delbao
title: Implement Trie (Prefix Tree)
tag: leetcode
---

要点：这题trie的特殊点在字符不是表示在root里，而是在边上。而边是每个树结点上的map<char, child>来表示的。所以结点是placeholder，所以比字符数应该多1个。
 
- insertion:
    - 如果用recursion来做，因为java和python是不支持pass-by-reference的，所以要在下一层call的外面判断是否结点不存在，并且如果不存在则创建结点。
    - 字符串结束的marker是在叶结点上，所以是在i==len(word)这层的call里。这是insert的中止条件，直接返回
    - 死记这条：insert的时候root是不会为null的
- search和startsWith:
    - 结束条件有多个可能：1. root为空，说明对应的字符不存在，返回False，2. i==len(word): code里这个判断在1.之后，所以root是不为null的，然后判断root.isLeaf
    - startsWith的code是类似的，除了不用判断isLeaf
 
 {% gist 9ba8aac8c6d1ef070ace99f3311834af %} 
