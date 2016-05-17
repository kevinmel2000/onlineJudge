---
layout: post
author: delbao
title: Convert Sorted List to Binary Search Tree
tag: leetcode
---

只能顺序访问链表结点，所以不能像array那样preorder的方式建树。而是inorder，因为inorder的顺序和有序的。
 
- 每次访问完左子树，这时候的head指向的是当前的root。这时再移动链表指针。
- 因为python是pass-by-value，而recursion的返回值为子树的root，所以只能用global variable表示当前指针（如果c++可以用pass-by-reference update链表指针）
 
 {% gist 3587277e10c7683266a858ac821815dd %}
