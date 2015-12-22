// Solution 1 --- 三步翻转法
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution {

    public void rotateString(char[] str, int offset) {
        if( str == null || str.length == 0 ){
            return;
        }
        int length = str.length;
        offset = offset % length;
        if( offset == 0 ){
            return;
        }
        swap(str, length - offset, length-1);
        swap(str, 0, length - offset - 1);
        swap(str, 0, length-1);
    }
    
    private void swap(char[] str, int i, int j){
        while( i <= j ){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
            i++;
            j--;
        }
    }
}
