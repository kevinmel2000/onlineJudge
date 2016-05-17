---
layout: post
author: delbao
title: Length of Last Word
tag: leetcode
---

这题很容易去找最后word的start和end，这样可以做，但是增加了code的复杂性（因为有可能只有一个字符，这样两边都要检查越界）。最好只找start，因为start可以reset len，然后len可以在非空格处累加。找start（或者找end）用到的方法就是区分两种情况，首字母 or i-1为空格，然后再检查i非空格。

{% gist f5d55a9581117dc1b6fb71cd6190c1ab %}
