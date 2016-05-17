---
layout: post
author: delbao
title: Minimum Depth of Binary Tree
tag: leetcode
---

同理，这题用preorder iterative搞定。注意即使是preorder一个高度变量是不够的。因为在同一高度同时入栈左右，左边出栈后并不知道当前栈内的是右子树还是上一层。这样就没法用同一个变量track height了

{% gist 1eead13ee080a02a3f09c7528e107f75 %}
