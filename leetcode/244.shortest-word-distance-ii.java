public class WordDistance {

    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++) {
            if(!um.containsKey(words[i])) {
                um.put(words[i], new ArrayList<Integer>());
            }
            um.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> aList = um.get(word1);
        List<Integer> bList = um.get(word2);
        int shortest = Integer.MAX_VALUE;
        if(aList!=null && bList!=null) {
            int i=0,j=0;
            while(i<aList.size() && j<bList.size()) {
                int low, high;
                if(aList.get(i)<bList.get(j)) {
                    low = aList.get(i);
                    high = bList.get(j);
                    i++;
                } else {
                    low = bList.get(j);
                    high = aList.get(i);
                    j++;
                }
                if(high-low<shortest) shortest = high-low;
            }
        }
        hortest;
    }
    Map<String, List<Integer>> um = new HashMap<>();
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
