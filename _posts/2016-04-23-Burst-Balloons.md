---
layout: post
author: delbao
title: Burst Balloons
tag: leetcode
---

要点：利用了divide and conquer的方法，开始不是那么容易想出来，因为左右并不是完全分开的。这题的理解点在于把分割点想成在范围(left，right)最后一个burst的气球，因为left和right是exclusive的，那么这个气球带来的价值就是nums[k]*nums[left]*nums[right] (也就是只依赖于其边界）。其左边(left,k)和右边(k,right)仍然依赖k，但不会超过边界。这样就把问题分割了。
错误点：
 
- 注意dp的顺序：不能用外循环left，内循环right的方法，因为(left,k)或者(k,right)还没有更新到正确的值。因为(left,k)最终值不止left固定得到的临时值。所以循环应该基于长度len，从2开始直到n，然后left作为内循环，right就固定。
- 注意这种循环方式longest palindromic subsequence也用到，但是这题外循环left，内循环right的方法也能用。不同点在于这里没有k的第三重循环，只依赖于左右边界相邻的dp值
 
