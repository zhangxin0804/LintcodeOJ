
class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
        if( nums == null || nums.size() == 0 ){
            return prev;
        }
        Collections.sort(nums);
        ArrayList<Integer> eachPermu = new ArrayList<Integer>();
        eachPermu.add(nums.get(0));
        prev.add(eachPermu);
        for(int i = 1; i < nums.size(); i++){
            ArrayList<ArrayList<Integer>> crt = new ArrayList<ArrayList<Integer>>();
            for(int j = 0; j < prev.size(); j++){
                ArrayList<Integer> tmp = prev.get(j);
                int size = tmp.size();
                for(int k = 0; k < size; k++){
                    tmp.add(k, nums.get(i));
                    crt.add( new ArrayList<Integer>(tmp) );
                    tmp.remove(k);
                }
                tmp.add(nums.get(i));
                crt.add( new ArrayList<Integer>(tmp) );
            }
            prev = crt;
        }
        return prev;
    }
}

/*
class Solution {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if( nums == null || nums.size() == 0 ){
            return res;
        }
        Collections.sort(nums);
        ArrayList<Integer> eachPermu = new ArrayList<Integer>();
        boolean[] markArr = new boolean[nums.size()];
        dfs(res, eachPermu, nums, markArr);
        return res;
    }
    
    private void dfs(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> eachPermu, ArrayList<Integer> nums, boolean[] markArr){
        
        if( eachPermu.size() == nums.size() ){
            res.add( new ArrayList<Integer>(eachPermu) );
            return;
        }
        for(int i = 0; i < nums.size(); i++){
            if( markArr[i] == true ){
                continue;
            }
            markArr[i] = true;
            eachPermu.add(nums.get(i));
            dfs(res, eachPermu, nums, markArr);
            eachPermu.remove(eachPermu.size()-1);
            markArr[i] = false;
        }
    }
}
*/
