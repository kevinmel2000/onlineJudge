# http://geeksquiz.com/check-given-four-points-form-square/
# 
class Point:
        def __init__(self, x, y):
                self.x = x
                self.y = y
class CheckSquare:
        def checkSquare(self, p1, p2, p3, p4):
                def distSq(p, q):
                        return (p.x-q.x)*(p.x-q.x)+(p.y-q.y)*(p.y-q.y)
                
                p12,p13,p14=distSq(p1,p2),distSq(p1,p3),distSq(p1,p4)
                p23,p24,p34=distSq(p2,p3),distSq(p2,p4),distSq(p3,p4)
                
                if p12==p13 and 2*p12==p14:
                        return p12==p24 and p12==p34
                        
                if p12==p14 and 2*p12==p13:
                        return p12==p23 and p12==p34
                        
                if p13==p14 and 2*p13==p12:
                        return p13==p23 and p13==p24
                
                return False
        
a = CheckSquare()
print a.checkSquare(Point(20,10),Point(10,20),Point(20,20),Point(10,10))
