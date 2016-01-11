class Queue(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.s1 = []
        self.s2 = []

    def push(self, x):
        """
        :type x: int
        :rtype: nothing
        """
        self.s2.append(x)

    def pop(self):
        """
        :rtype: nothing
        """
        if not self.s1:
            while self.s2:
                self.s1.append(self.s2.pop())
        return self.s1.pop()
            

    def peek(self):
        """
        :rtype: int
        """
        if not self.s1:
            while self.s2:
                self.s1.append(self.s2.pop())
        return self.s1[-1]

    def empty(self):
        """
        :rtype: bool
        """
        return not self.s1 and not self.s2
