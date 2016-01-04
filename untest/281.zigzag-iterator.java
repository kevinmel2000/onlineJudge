public class ZigzagIterator {
    private List<Iterator<Integer>> iters = new ArrayList<>();
    private int count = 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(!v1.isEmpty()) iters.add(v1.iterator());
        if(!v2.isEmpty()) iters.add(v2.iterator());
    }
   
    public int next() {
        if(hasNext()) {
            int next = iters.get(count).next();
            if(!iters.get(count).hasNext()) iters.remove(count);
            else count++;
           
            if(count>=iters.size()) count-=iters.size();
            return next;
        }
        return -1;
    }
   
    public boolean hasNext() {
        return !iters.isEmpty();
    }
}
