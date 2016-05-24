---
layout: post
author: delbao
title: Sudoku Solver 
tag: leetcode
---

要点：和8 queen类似，dfs，同时要maintain row，column，box表示每个点所在的row，column和box的当前状态。本质是set，但是因为值是固定的，所以boolean array就可以，每个slot对应一个value
错误点
 
- 因为board上已经有值了，别忘了初始化row，column，box
- 解就是board本身，所以要同时更新board和row，column，box
- python integer和char的conversion: ord(‘9’)得到这个char的ascii，str(9) => ‘9’：注意python没有char的概念，所以str()就可以
- 函数内外的变量用同样的名字：i，j或者x，y，不一致很容易搞混
- box的坐标如何算：i/3*3+j/3: i/3得到row方向的box序数，再*3表示之前几行有几个box，最后j/3得到同一行3个box的偏移量，曾经错误的用i*3/3+j/3
- 因为值和index是差1的，所以在loop里一定要用index，只有在赋值的时候+1，这样避免错误

{% gist bf99b99cf26d9a231936748c89f96b69 37 Sudoku Solver.py %}
