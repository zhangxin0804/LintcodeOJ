// Solution 3 --- quick sort变种quick selection算法，挖坑填数找对应index元素。
// 时间复杂度: average ~ O(n), worst case ~ O(n^2)
// 空间复杂度: average ~ O(logn), worst case ~ O(n)

class Solution {

    public int kthLargestElement(int k, int[] nums) {
        if( nums == null || nums.length == 0 || k > nums.length ){
            return 0;
        }
        int length = nums.length;
        // 找第kth大，即找从小到大sorting后 index = length - k的元素
        // quick sort变形成quick selection
        return quickSelection(nums, 0, length-1, length - k);
        
    }
    
    private int quickSelection(int[] nums, int left, int right, int kth){
        
        int leftCopy = left;
        int rightCopy = right;
        int pivot = nums[left];
    
        while( leftCopy < rightCopy ){
            
            while( leftCopy < rightCopy && nums[rightCopy] > pivot ){
                rightCopy--;
            }
            if( leftCopy < rightCopy ){
                swap(nums, leftCopy, rightCopy);
                leftCopy++;
            }
            while( leftCopy < rightCopy && nums[leftCopy] <= pivot ){
                leftCopy++;
            }
            if( leftCopy < rightCopy ){
                swap(nums, leftCopy, rightCopy);
                rightCopy--;
            }
        }
        nums[leftCopy] = pivot;
        if( leftCopy > kth ){
            return quickSelection(nums, left, leftCopy-1, kth);
        }else if( leftCopy < kth ){
            return quickSelection(nums, leftCopy+1, right, kth);
        }else{
            return nums[leftCopy];        
        }
    }
    // swap helper function
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


// Solution 2 -- top k问题，找第kth大问题，利用heap来解决。
// 时间复杂度: O(nlogk)
// 空间复杂度: O(k)
/*
class Solution {

    public int kthLargestElement(int k, int[] nums) {
        
        if( nums == null || nums.length == 0 || k > nums.length ){
            return 0;
        }
        int length = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i = 0; i < length; i++){
            if( minHeap.size() < k ){
                minHeap.offer(nums[i]);
                continue;
            }
            if( nums[i] >= minHeap.peek() ){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
*/

// Solution 1: 直接built-in sorting, 再找第kth大
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)

/*
class Solution {

    public int kthLargestElement(int k, int[] nums) {

        if( nums == null || nums.length == 0 || k > nums.length ){
            return 0;
        }
        int length = nums.length;
        Arrays.sort(nums);
        return nums[length-k];
    }
}
*/
