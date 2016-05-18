---
layout: post
author: delbao
title: Reverse Nodes in k-Group 
tag: leetcode
---

思路：这题最主要是犁清对每组操作的时更新链表指针的顺序。对每个group要记录pre，cur，tail。一种错误的记忆是仿照reverse把cur.next=pre。实际中只有group内reverse，对group外（i.e., pre和tail.next), 想象成做rotation: pre要链接原来的tail，而原来的head去链接tail.next。
k-Group内循环移动几步？这里思维的要点是counter表示的是移动的步数而不是结点数。当前group head移动k步，就会移到下一组的head

{% gist d448e3e99b0d841fd005b5c2fa46861e %}
