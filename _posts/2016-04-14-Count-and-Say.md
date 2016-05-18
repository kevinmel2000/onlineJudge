---
layout: post
author: delbao
title: Count and Say 
tag: leetcode
---

要点：考点就是count和duplicate的code pattern：如果基本条件判断nums[i]和nums[i+1]，那么要loop从0到n-1，但最后一个元素特殊处理：这种情况和不相等同样处理。如果是判断nums[i]和nums[i-1]，那么要loop从1到n，最后特殊处理。
错误点：
 
- next要append

{% gist 1db3660aeeaaed9986d4fd4f549a9620 %}
