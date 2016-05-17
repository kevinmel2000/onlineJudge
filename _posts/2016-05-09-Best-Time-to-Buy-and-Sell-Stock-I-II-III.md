---
layout: post
author: delbao
title: Best Time to Buy and Sell Stock I/II/III
tag: leetcode
---

IV是k的解，可以特殊化到2的。有趣的问题是III的左右两遍扫描解法和IV的关联性。其实在从左向右扫描的时候就是更新global[i][1]，从右向左扫描是更新global[i][2]（基于global[i][1]）。为什么IV中要maintain local而III没有还没有理解透，现在的想法是实际上每次计算global的时候已经包含了local的计算，因为local的主要目的是从k-1次交易构建第k次交易。
 
还有一个细节就是在当天是可以同时买卖的，这样在计算2次交易profit的时候（III），是左右同一天的profit加和。而IV，local也是用的前一天的卖的情况（所以前一天可以再买回来今天再卖）
 
 
{% gist 676eb47a47c0ab74f5c375bd744b7936  %}
 
{% gist 69e4c1e1f734755aa82a7727320e59dc  %}

{% gist 69dc800c04d8a2fa3914b0b9cd2966e7 %}
