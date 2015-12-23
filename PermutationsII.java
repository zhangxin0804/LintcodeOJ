// Solution 2 -- 非递归，迭代法---找交换点swap, reverse方法
class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if( nums == null || nums.size() == 0 ){
            return res;
        }
        int length = nums.size();
        // 先排序依次输入集合
        Collections.sort(nums);
        // 先将排序后的输入集合作为其中一个解加入解集。
        res.add( new ArrayList<Integer>(nums) );
        while(true){
            // 找交换点
            int pos = findSwapPosition(nums);
            // 找不到交换点则退出结束。
            if( pos == -1 ){
                break;
            }
            // 从后往前找第一个比交换点大的数，进行和交换点位置数的swap
            swap(nums, pos);
            // 然后将从交换点位置之后的一个位置到末尾进行reverse
            reverse(nums, pos+1, length-1);
            // 得到新的输入集合作为解加入解集，在循环重复上面步骤。
            res.add( new ArrayList<Integer>(nums) );
        }
        return res;
    }
    
    private int findSwapPosition(ArrayList<Integer> nums){
        int pos = -1;
        int i = nums.size() - 1;
        while( i >= 1 && nums.get(i) <= nums.get(i-1) ){
            i--;
        }
        if( i >= 1 ){
            pos = i - 1;
        }
        return pos;
    }
    
    private void swap(ArrayList<Integer> nums, int swapIndex){
        int length = nums.size();
        for(int i = length - 1; i >= 0; i--){
            if( nums.get(i) > nums.get(swapIndex) ){
                int temp = nums.get(i);
                nums.set(i, nums.get(swapIndex));
                nums.set(swapIndex, temp);
                break;
            }
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int i, int j){
        while( i <= j ){
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
            i++;
            j--;
        }
    }
}



/*
// Solution 1 --- 递归方法。

class Solution {

    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if( nums == null || nums.size() == 0 ){
            return res;
        }
        Collections.sort(nums);
        ArrayList<Integer> eachPermu = new ArrayList<Integer>();
        boolean[] markArr = new boolean[nums.size()];
        dfs(res, eachPermu, markArr, nums);
        return res;
    }
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> eachPermu, boolean[] markArr, ArrayList<Integer> nums){
        
        if( eachPermu.size() == nums.size() ){
            res.add( new ArrayList<Integer>(eachPermu) );
            return;
        }
        
        for(int i = 0; i < nums.size(); i++){
            if( markArr[i] == true ){
                continue;
            }
            if( i > 0 && nums.get(i) == nums.get(i-1) && !markArr[i-1] ){
                continue;
            }
            
            markArr[i] = true;
            eachPermu.add(nums.get(i));
            dfs(res, eachPermu, markArr, nums);
            eachPermu.remove(eachPermu.size()-1);
            markArr[i] = false;
        }
    }
}
*/
