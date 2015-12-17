// Solution 1 --- 既然不能用常规的运算符，考虑位操作，XOR即不带进位位的加法运算
//                再另外判断处理进位位，加入结果中。
// 时间复杂度: O(1)
// 空间复杂度: O(1)

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        int res = a^b; // 先做不带进位位的加法，也即通过XOR得到结果。
        for(int i = 0; i < 32; i++){
            int mask = 1<<i;
            // 掩码, 从0000..00001 到 10000.0000, 一共32组。
            // 检测a和b的每一位,如果都为1说明会产生carry bit, 因此mask<<1得到进位位, 加入
            // 结果。
            if( (mask & a) != 0 && (mask & b) != 0 ){
                res += (mask<<1);
            }
        }
        return res;
    }
}
