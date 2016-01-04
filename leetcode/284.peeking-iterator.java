// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    boolean cached = false;
    Integer cachedValue = null;
    Iterator<Integer> real;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        real = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
    if(cached) return cachedValue;
    if(hasNext()) { 
        cached = true;
        cachedValue = real.next();
        return cachedValue;
    }
    return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(cached) {
            cached = false;
            return cachedValue;
        }
        if(hasNext()) {
            return real.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if(cached) return true;
        return real.hasNext();
    }
}
