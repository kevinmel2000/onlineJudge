---
layout: post
author: delbao
title: Multiply Strings 
tag: leetcode
---

要点：基本公式就是从低位开始（或者string的高index）两层loop：i，j乘积对应的位置是i+j+1（比如0，0，的位置是1，这里0的位置是进位。另外一定要有高位在0的sense）。
错误点：
 
- j是下位乘数的index，因为有进位，所以j要超出0，要更新j-=1

{% gist bf99b99cf26d9a231936748c89f96b69 43 Multiply Strings.py %}
