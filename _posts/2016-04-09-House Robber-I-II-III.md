---
layout: post
author: delbao
title: House Robber I/II/III 
tag: leetcode
---

这题代表了单向线性dp的基本pattern: build local best value at each element and track the global optimal. 这题的要点是local是前k个房间的最优解，这个解不一定要选第k个房间。这个local解是比较k-1的optimal和k-2 optimal + current value。之所以不以必选第k个房间作local是因为有可能最优解有连续2或多个房间不选，比如100，1，1，100
 
III: idea
 
### Letter Combinations of a Phone Number
这题iterate方法的基本思路就是连续做+1，+1的含义就是移动同一数字对应字母下一个index处。算法是两层循环，外层是每一个输出，内层是一个数的每一位。难点是循环的invariant：外层是carry!=1，因为如果内层循环最高位仍有进位说明已经过了最后一个对应string。内层从低到高遍历每一位，但如果carry变为0，要break中止。
 
错误点
 
 
 {% gist f935db41a84fe0bbde6530b182aa6346 %}
 
 {% gist 9d90ad5227967a65fdabd6367af82109 %}
 
 {% gist 9eade83bbbcdc24ea104b0023664e7cc %}
