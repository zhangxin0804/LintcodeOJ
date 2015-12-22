class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        if( n < 0 ){
            return 0;
        }
        long count = 0L;
        while( n >= 5 ){
            count += n/5;
            n = n/5;
        }
        return count;
    }
}
