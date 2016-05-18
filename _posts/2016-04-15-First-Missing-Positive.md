---
layout: post
author: delbao
title: First Missing Positive 
tag: leetcode
---

要点：因为值是range固定的，所以利用了slot的index作为mark。注意内循环的条件是目标的value和index不匹配而不是当前值所在slot的index，因为当前slot对应的值可能不存在，就算存在，也应该由其他slot移动过来。
错误点：
 
- 值的有效范围是1到len(nums)，所以如果全有，返回len(nums)+1
- 注意下标的范围是0到len(nums)-1，所以在对应下标和值时要做范围检查。
 
 {% gist 52b3e7b2cf16c039878003fb0d1d6345 %}
