---
layout: post
author: delbao
title: Best Time to Buy and Sell Stock with Cooldown 
tag: leetcode
---

要点：这题就是house robber的变形，buy/sell来记录，一个trick是buy就是profit损失，这样后面的sell就能catch up。另外，这里cooldown体现在buy的递推式：取sell[i-2]，因为sell[i-1]可能就在i-1这个点卖的。
错误点：
 
- 注意buy和sell的初始化：buy[1]是前两个哪个prices点低
- buy可以为负，sell最小为0。最后返回的就是sell[n-1]
 
 {% gist 4c65087a806311416d04eba2c4462d0a %}
