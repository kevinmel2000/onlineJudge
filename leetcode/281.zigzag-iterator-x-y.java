public class ZigzagIterator {
    
    List<List<Integer>> nv = new ArrayList<>();
    int x=0, y=0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        nv.add(v1);
        nv.add(v2);
    }

    public int next() {
        for(int i=0;i<nv.size();i++) {
            if(x>=nv.size()) {
                x-=nv.size();
                y++;
            }
            if(y<nv.get(x).size()) {
                return nv.get(x++).get(y); 
            } else {
                x++;
            }
        }
        return -1;
    }

    public boolean hasNext() {
        int nx=x, ny=y;
        for(int i=0;i<nv.size();i++) {
            if(nx>=nv.size()) {
                nx-=nv.size();
                ny++;
            }
            if(ny<nv.get(nx).size()) return true;
            nx++;
        }
        
        return false;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
