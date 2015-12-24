// Solution 4 -- two pointers, 一个维护<k元素的left boundary指针，一个是遍历指针。
//               类似Leetcode Move Zeroes那个题的思路。
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if( nums == null || nums.length == 0 ){
	        return 0;
	    }
	    int length = nums.length;
	    int left = 0;
	    for(int i = 0; i < length; i++){
	        if( nums[i] < k ){
	            swap(nums, left, i);
	            left++;
	        }
	    }
	    return left;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Solution 3 --- 三指针，左右两个boundary指针以及一个遍历指针，通过SWAP把元素重新place
//                类似Leetcode Sort Colors的其中一个解法。
//                left始终表示<k的元素将要被放置到的index位置
//                right始终表示>=k的元素将要被放置到的index位置。
// 时间复杂度: O(n)
// 空间复杂度: O(1)

/*
public class Solution {
    public int partitionArray(int[] nums, int k) {
	    if( nums == null || nums.length == 0 ){
	        return 0;
	    }
	    int length = nums.length;
	    int left = 0, right = length - 1;
	    int crt = 0;
	    while( crt <= right ){
	        if( nums[crt] < k ){
	            nums[left] = nums[crt];
	            left++;
	            crt++;
	        }else{
	            swap(nums, crt, right);
	            right--;
	        }
	    }
	    return right+1;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/

// Solution 2 --- 类似quick sort或者quick selection的中间环节partition的步骤。
//                注意循环条件的边界控制！！！取等不取等要分析！！
// 时间复杂度: O(n)
// 空间复杂度: O(1), in-place实现。
/*
public class Solution {

    public int partitionArray(int[] nums, int k) {
	    if( nums == null || nums.length == 0 ){
	        return 0;
	    }
	    int length = nums.length;
	    int left = 0, right = length - 1;
	    while( left <= right ){
	        // 从左开始遍历，找到第一个>=k的数
	        while( left <= right && nums[left] < k ){
	            left++;
	        }
	        // 从右开始遍历，找到第一个<k的数
	        while( left <= right && nums[right] >= k ){
	            right--;
	        }
	        // 如果都在boundary内，则进行SWAP操作。然后各自前进，准备下一次循环
	        if( left <= right ){
	            swap(nums, left, right);
	            left++;
	            right--;
	        }
	    }
	    return left;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
*/

// Solution 1 --- 开辟额外数组进行copy,然后再partition重新place元素到原始数组。
//                two pointers使用，从两边往中间夹逼。
// 时间复杂度: O(n)
// 空间复杂度: O(n)
/*
public class Solution {
    public int partitionArray(int[] nums, int k) {
        // corner case
        if( nums == null || nums.length == 0 ){
            return 0;
        }
        int length = nums.length;
        int[] res = new int[length];
        // 先copy原始数组
        for(int i = 0; i < length; i++){
            res[i] = nums[i];
        }
        // 再partition, 重新place, 
        // left代表的含义是下一个 < k的元素要被放置的位置。
        // right代表的含义是下一个 >= k的元素要被放置的位置。
        
        int left = 0, right = length - 1;
        for(int i = 0; i < length; i++){
            if( res[i] >= k ){
                nums[right--] = res[i];
            }else{
                nums[left++] = res[i];
            }
        }
        // 别忘了+1
        return right+1;
    }
}
*/
