public class ZigzagIterator {

    List<Iterator<Integer>> nv = new ArrayList<>();
    int count=0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) nv.add(v1.iterator());
        if(!v2.isEmpty()) nv.add(v2.iterator());
    }

    public int next() {
        int ret = nv.get(count).next();
        if(!nv.get(count).hasNext()) {
            nv.remove(count);
        } else {
            count++;
        }
        
        if(count>=nv.size()) count-=nv.size();
        return ret;
    }

    public boolean hasNext() {
        return nv.size()!=0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
