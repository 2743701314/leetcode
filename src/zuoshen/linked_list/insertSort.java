package zuoshen.linked_list;

import java.util.Arrays;
import java.util.HashSet;

public class insertSort {
    public static void main(String[] args) {
       insertSort in = new insertSort();
       int s = in.numTrees(19);
        System.out.println(s);

    }
//    public int numTrees(int n){
//        if(n == 0){
//            return 0;
//        }
//        return help(1,n);
//    }
public int numTrees(int n){
    int[] dp = new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
        for(int j = 1; j <= i; j++){
            dp[i] += dp[j-1] * dp[i-j];
        }
    }
    return dp[n];
}

    public int help(int start, int end){
        int res = 0;
        if(start > end){
            return 1;
        }
        for(int i = start; i <= end; i++){
            int left = help(start,i-1);
            int right = help(i+1,end);
            res += left*right;
        }
        return res;
    }



}
