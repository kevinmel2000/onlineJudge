---
layout: post
author: delbao
title: Search in Rotated Sorted Array 
tag: leetcode
---

基本思路：根据mid的位置可以把rotated array分成两部分：顺序的和保持rotated，然后判断target的位置。target落入顺序部分的边界条件很简单，所以作为if部分
错误点:
 
- 虽然Search in Rotated Sorted Array是没有duplicate的，但是边界条件仍然有可能相等：
    - 判断是否是顺序的时候，如果只有2个元素，mid和low会是同一个元素，这时可能仍要继续判断：比如[3,1],1
    - 判断target的时候，target可能和low或者high的元素相等
 
 {% gist 37a58404ffad8ccdbd4d2e88af2c8d3b %}
