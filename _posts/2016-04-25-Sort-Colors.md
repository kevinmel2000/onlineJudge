---
layout: post
author: delbao
title: Sort Colors
tag: leetcode
---

要点：维护左右边界的指针，从左边互换或者本来就在中间，都要接着找下一个。而从右边互换来，不变。
 
- 这是因为，处理顺序是从左向右，所以右边的互换来的还没有处理而左边都是处理过的。
- 这里一个错误点就是左边互换来的也不找下一个。这样的问题是如果左边和当前正好是同一个位置（这种情况只会在当前为0时），永远没法前进。而这种情况实际没发生互换并且都为0，可以同步推进。而其他情况也被包括进来因为换来的肯定是1，可以继续处理下一个

{% gist c17301909d8a972b44248d894b49ff8d %}