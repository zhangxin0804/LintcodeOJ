// Solution 1 --- brute force方法，辅助函数用于判断每个数每一个digit是否等于k,
//                主函数枚举。注意辅助函数中num = 0 && k == 0 的情况。

// 时间复杂度: O(nlogn), log以10为底
// 空间复杂度: O(1)
class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int res = 0;
        if( n < 0 ){
            return 0;
        }
        for(int i = 0; i <= n; i++){
           res += helper(i, k); 
        }
        return res;
    }
    
    // return how many digit k in number num
    private int helper(int num, int k){
        int count = 0;
        if( num == 0 && k == 0 ){
            count = 1;
            return count;
        }
        
        while( num != 0 ){
            if( num % 10 == k ){
                count++;
            }
            num = num/10;
        }
        return count;
    }
}
