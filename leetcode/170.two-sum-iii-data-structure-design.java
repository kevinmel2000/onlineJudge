public class TwoSum {

    // Add the number to an internal data structure.
        public void add(int number) {
            if(!um.containsKey(number)) {
                um.put(number, 0);
            }
            um.put(number, um.get(number)+1);
            l.add(number);
        }

    // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int value) {
            for(int i=0;i<l.size();i++){
                int num = l.get(i);
                if(value-num==num && um.get(num)>1) return true;
                else if(value-num!=num && um.get(value-num)!=null) return true;
            }
            return false;
        }
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> um = new HashMap<>();
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
