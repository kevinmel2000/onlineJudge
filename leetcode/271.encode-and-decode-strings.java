public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.size();i++) {
            sb.append(strs.get(i).length()).append('#').append(strs.get(i));
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i=0;
        while(i<s.length()) {
            int start=i;
            while(s.charAt(i)!='#') i++;
            int len = Integer.parseInt(s.substring(start, i));
            res.add(s.substring(i+1, i+1+len));
            i+=len+1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
