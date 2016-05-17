---
layout: post
author: delbao
title: Search a 2D Matrix
tag: leetcode
---

考点：方法很简单，对第0列和之后找到的行做两次2分，重点是用第一次二分后low和high的位置来确定行。对于二分没找到的情况：low这时候比high大1，low对应的是>target的元素，high对应的是<target的元素。对于这题，我们需要用high，因为行也是递增的。

{% gist 754743a16cc707b33f7ca78cb0dfd7ec %}
