---
layout: post
author: delbao
title: happy number 
tag: leetcode
---

错误点
 
- loop中什么时候加入set？check之后update：loop invariant==check，加入set==update。所以一定要在loop中首先加入set

{% gist 36e605a6bdeacc063f6b02dccf80b9d5 %}
