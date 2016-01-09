/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
        public static void main (String[] args) throws java.lang.Exception
        {
                // your code goes here
                System.out.println(isOneEditDistance(new CharacterIterator("145"), 
                                                     new CharacterIterator("14567")));
        }
        
        public static boolean isOneEditDistance(String s, String t) {
                int ns = s.length();
                int nt = t.length();
                if(Math.abs(ns-nt)>1) return false;

                if(ns>nt) {
                        String tmp = t;
                        t = s;
                        s = tmp;
                        int ntmp = ns;
                        ns = nt;
                        nt = ntmp;
                }

                int i = -1;
                while(++i<ns) {
                        if(s.charAt(i)!=t.charAt(i)) break;
                }
                
                if(i==ns) return true;
                int j = i;
                if(ns==nt) {
                        i++;
                }
                j++;
                //System.out.println(i+","+j);

                while(i<ns&&j<nt) {
                        if(s.charAt(i)!=t.charAt(j)) return false;
                        i++; j++;
                }
                return true;
        }
        
        public static boolean isOneEditDistance(CharacterIterator s, CharacterIterator t) {
                boolean diff=false, insA=false, insB=false, replace=false;
                Character preA = null, preB = null;
                while(s.hasNext() && t.hasNext()) {
                        Character curA = s.next();
                        Character curB = t.next();
                        if(!insA && !insB && !replace) {
                                if(curA!=curB) {
                                        insA = insB = replace = diff = true;
                                }
                        } else {
                                if(insA && preA!=curB) insA = false;
                                if(insB && preB!=curA) insB = false;
                                if(replace && curA!=curB) replace = false;
                                if(!insA && !insB && !replace) return false;
                        }
                        preA=curA;
                        preB=curB;
                }
                
                if(s.hasNext()) {
                        Character curA = s.next();
                        return (!diff || (insB && preB==curA)) && !s.hasNext();
                } else if(t.hasNext()) {
                        Character curB = t.next();
                        return (!diff || (insA && preA==curB)) && !t.hasNext();
                } else {
                        return !diff || replace;
                }
        }
        
        static class CharacterIterator implements Iterator<Character> {

            private final String str;
            private int pos = 0;
        
            public CharacterIterator(String str) {
                this.str = str;
            }
        
            public boolean hasNext() {
                return pos < str.length();
            }
        
            public Character next() {
                return str.charAt(pos++);
            }
        
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
}
