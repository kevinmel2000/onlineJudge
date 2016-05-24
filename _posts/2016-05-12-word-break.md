---
layout: post
author: delbao
title: Word Break I/II
tag: leetcode
---

现在看都是小case题了，一遍过了。注意这题不是np complete，dp解的time complexity可以是O(n^2) or O(nm)。所有解的个数是exponential的 (比如”aaaa....”, dict="a, aa”)。以前在amazon onsite遇到过，不过既不是返回True/False，也不是所有解，而是一个解。其实一个解和True/False是一个复杂度，因为单一解是可以从dp反向重构的。

{% gist bf99b99cf26d9a231936748c89f96b69 139 Word Break.py %}

{% gist bf99b99cf26d9a231936748c89f96b69 140 Word Break II.py %}
