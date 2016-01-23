import java.util.*;

class ThreeSumDuplicates{

     public static void main(String []args) {
        System.out.println("Hello World");
        int[] a = new int[]{1,1,1,2,2,2,2};
        threesum(a, 3);
        threesum(a, 5);
     }
     
     static void threesum(int[] a, int target) {
         int n = a.length;
         Arrays.sort(a);
         for(int i=0;i<n-2;i++) {
             if(i>0 && a[i]==a[i-1]) continue;
             int j=i+1, k=n-1;
             
             while(j<k) {
                 if(j>i+1 && a[j]==a[j-1]) {
                     j++; continue;
                 }
                 if(a[i]+a[j]+a[k]==target) {
                     //System.out.println(a[i]+","+a[j]+","+a[k]);
                     System.out.println(i+","+j+","+k);
                     j++;
                     k--;
                 } else if(a[i]+a[j]+a[k]<target) {
                     j++;
                 } else {
                     k--;
                 }
             }
         }
     }
}
