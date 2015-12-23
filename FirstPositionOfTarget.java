class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if( nums == null || nums.length == 0 ){
            return -1;
        }
        int length = nums.length;
        int left = 0, right = length - 1;
        while( left + 1 < right ){
            int middle = left + ((right-left) >> 1);
            if( nums[middle] == target ){
                right = middle;
            }else if( nums[middle] > target ){
                right = middle;
            }else{
                left = middle;
            }
        }
        
        if( nums[left] == target ){
            return left;
        }else if( nums[right] == target ){
            return right;
        }
        return -1;
    }
}
