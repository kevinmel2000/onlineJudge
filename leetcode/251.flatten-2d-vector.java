public class Vector2D {
    int x = 0, y = 0;
    List<List<Integer>> vec2d;    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
    }

    public int next() {
        int m = vec2d.size();
        if(hasNext()) {
            while(x<m) {
                if(y<vec2d.get(x).size()) return vec2d.get(x).get(y++);
                x++;
                y=0;
            }
        }
        return -1;
    }

    public boolean hasNext() {
        int m = vec2d.size();
        int nx = x, ny = y;
        while(nx<m) {
            if(ny<vec2d.get(nx).size()) return true;
            nx++;
            ny=0;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
