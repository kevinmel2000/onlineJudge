---
layout: post
author: delbao
title: Text Justification
tag: leetcode
---

细节实现题，基本结构是逐层填（外循环），maintain每层的start和end：start代表开始点，end在每层开始为start。在内层循环找到本层的end。找法是前向比较。最终end点落在本层end的下一个位置
corner cases以及解法or错误点
 
- 在内循环中end还要检查<n
- 只有一个单词的行在一个分支处理，可能这个单词超过maxWidth or not，没超过要补空格
- space和bonus：因为空格的长度是随着单词个数变动，用space和bonus来动态分配，公式见code
- 最后一行要补空格，在python中因为每行用list表示string，所以还要记录行长

{% gist bf99b99cf26d9a231936748c89f96b69 68 Text Justification.py %}
