        String encode(String[] strs) {
                // ... your code
                if(strs.length==0) return "";
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<strs.length;i++) {
                        sb.append(strs[i].length());
                        sb.append("#");
                        sb.append(strs[i]);
                }
               
                return sb.toString();
        }
       
        String[] decode(String s) {
                //... your code
                int i=0, count=0, wCount=0;
                List<String> strList = new ArrayList<>();
                while(i<s.length()) {
                        if(s.charAt(i)=='#') {
                                strList.add(s.substring(i+1, i+count));
                                count=0;
                                i+=count+1;
                                wCount++;
                        } else {
                                count=10*count+s.charAt(i)-'0';
                                i++;
                        }
                }
               
                return strList.toArray(new String[wCount]);
        }
