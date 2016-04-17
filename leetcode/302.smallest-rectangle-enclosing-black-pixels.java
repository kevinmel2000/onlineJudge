import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        
        // find row
        int minx = checkRowMin(image, x, y);
        int maxx = checkRowMax(image, x, y);
        int miny = checkColumnMin(image, x, y);
        int maxy = checkColumnMax(image, x, y);

        return (maxx-minx)*(maxy-miny);
      
    }
  
    int checkRowMin(char[][] image, int x, int y) {
        if(image[x][0]=='1') return -1;
        int high = y;
        int low = 0;
        
        int mid = (high+low+1)/2;
        while(low<high) {
            if(image[x][mid]=='0') {
                low = mid;
            } else {
                high = mid-1;
            }
            mid = (low+high+1)/2;
        }
        return mid;
    }
  
    intwMax(char[][] image, int x, int y) {
        if(image[x][image[x].length-1]=='1') return image[x].length;
        int high = image[x].length-1;
        int low = y;
        
        int mid = (high+low)/2;
        while(low<high) {
            if(image[x][mid]=='1') {
                low = mid+1;
            } else {
                high = mid;
            }
            mid = (low+high)/2;
        }
        return mid;
    }
  
    int checkColumnMin(char[][] image, int x, int y) {
        return 0; // To implement
    }
  
    int checkColumnMax(char[][] image, int x, int y) {
        return 0; // To implement
    }
}
