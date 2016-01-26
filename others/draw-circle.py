import math
 
# x = r*cos(theta)
# y = r*sin(theta)
# theta range is [0,r]
 
def printCircle(grid):
    m = len(grid)
    print "========="
    for x in xrange(m):
        for y in xrange(m):
            if grid[x][y]:
                print 'x',
            else:
                print '.',
        print ' '
 
def drawPoint(grid,x,y,m):
    x,y=int(round(x)),int(round(y))
    if x<m and y<m and x>=0 and y>=0:
        grid[x][y]=True
   
def drawCircle(m, r, x0, y0):
    grid = [[False]*m for i in xrange(m)]
    i=0.0;
    while i<2*math.pi:
        x=math.cos(i)*r
        y=math.sin(i)*r
        drawPoint(grid,x+x0,y+y0,m)
        i+=1.0/r
   
    printCircle(grid)
   
drawCircle(20,3,5,5)
