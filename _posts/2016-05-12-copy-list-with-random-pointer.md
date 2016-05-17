---
layout: post
author: delbao
title: Copy List with Random Pointer
tag: leetcode
---

思路很容易理解，这题连接完了cur.next是永远存在的，所以copy random link的时候不用特殊处理。break因为一轮包括4个结点，另外在list结尾有特殊情况，所以比较复杂

{% gist 9a66bbb9a56f3146eaaadfddaa74e55b %}
