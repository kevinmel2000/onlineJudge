public class Vector2D {
    private int curRow = 0;
    private int curCol = 0;
    private List<List<Integer>> vec2d;
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
    }
   
    public int next() {
        if(hasNext()) {
            if(curCol+1<vec2d.get(curRow).size()) {
                curCol++;
            } else {
                curRow++;
                curCol = 0;
            }
            return vec2d.get(curRow).get(curCol);
        }
        return -1;
    }
   
    public boolean hasNext() {
        if(curCol+1<vec2d.get(curRow).size()) return true;
        if(curRow+1<vec2d.size()) return true;
        return false;
    }
} 
