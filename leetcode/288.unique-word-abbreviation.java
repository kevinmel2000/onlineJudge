public class ValidWordAbbr {

    public ValidWordAbbr(String[] dictionary) {
        for(int i=0;i<dictionary.length;i++) {
            String sign = genAbbrev(dictionary[i]);
            if(um.containsKey(sign) && !um.get(sign).equals(dictionary[i])) {
                um.put(sign, "#");
            } else {
                um.put(sign, dictionary[i]);
            }
        }
    }

    public boolean isUnique(String word) {
        String sign = genAbbrev(word);
        return !um.containsKey(sign) || um.get(sign).equals(word);
    }
    
    public String genAbbrev(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length()!=0) sb.append(s.charAt(0));
        if(s.length()>2) sb.append(s.length()-2);
        if(s.length()>1) sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
    
    Map<String, String> um = new HashMap<>();
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
