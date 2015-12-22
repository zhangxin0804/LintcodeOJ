// Solution 1 -- 按照从大到小的顺序，从新数组的尾部开始merge
// 时间复杂度: O(n)
// 空间复杂度: O(1), 不算解集空间。
class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // assume A and B are both valid
        int length1 = A.length;
        int length2 = B.length;
        int[] res = new int[length1+length2];
        int index = length1+length2-1;
        int i = length1 - 1, j = length2 - 1;
        while( i >= 0 && j >= 0 ){
            if( A[i] >= B[j] ){
                res[index--] = A[i];
                i--;
            }else{
                res[index--] = B[j];
                j--;
            }
        }
        while( i >= 0 ){
            res[index--] = A[i];
            i--;
        }
        while( j >= 0 ){
            res[index--] = B[j];
            j--;
        }
        return res;
    }
}
