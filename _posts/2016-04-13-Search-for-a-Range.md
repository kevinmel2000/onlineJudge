---
layout: post
author: delbao
title: Search for a Range 
tag: leetcode
---

这两题的考点都是bounded binary search (i.e., > or >=), 程序结构要点：
 
- mid的更新在loop的最后，所以开始要初始化
- 条件是low<high，而不是low<=high, 否则可能infinite loop，因为low或者high可能不变，比如[1,3], 1：e.g., for >=: [4], mid==0, low==0, high==0, target=3, 因为循环后low没有变化。同样这个例子说明为什么mid要在loop最后更新：low==high就跳出循环
- 对于low=mid, mid lean to high: mid = (low+high+1)/2
 
对于range这题，value不存在的corner cases还是比较复杂。首先，bounded binary search选择’>’ or ‘<‘，而不是’>=’ or ‘<=‘。这是因为如果>=，返回的左右边界不能用一个条件来判断是否是target的边界。另外，target超过左右边界元素的任意一个，都返回[-1,-1]。另一种情况是target就在边界上，这个corner case是在binary search里面处理，返回-1 or len(nums)，这样在主函数里就可以用同一个公式判断target是否存在。

{% gist bf99b99cf26d9a231936748c89f96b69 34 Search for a Range.py %}
