---
layout: post
author: delbao
title: Copy List with Random Pointer
tag: leetcode
---

思路很容易理解，这题连接完了cur.next是永远存在的，所以copy random link的时候不用特殊处理。break因为一轮包括4个结点，另外在list结尾有特殊情况，所以比较复杂


- 顺序：以当前（cur）和下一个（被copy结点）为中心，去连接这两个的next，然后只需要沿cur.next推进就可以
- 特殊情况：因为被copy结点的next是null，不能连接其下下个结点。所以最后一个copy.next是no-op即可
 

{% gist 9a66bbb9a56f3146eaaadfddaa74e55b %}
