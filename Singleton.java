/**
 * @return: The same instance of this class every time
*/

// Solution 1 --- Singleton Design Pattern, Lazy Mode

class Solution {
    private static Solution sol;
    // 私有构造器，防止外界实例化新的对象
    private Solution(){
        
    }
    public static Solution getInstance() {
        // write your code here
        if( sol == null ){
            sol = new Solution();
        }
        return sol;
    }
}

// Solution 2 -- Singleton Design Pattern, Eager Mode
class Solution {
    private static final Solution sol = new Solution();
    // 私有构造器，防止外界实例化新的对象
    private Solution(){
        
    }
    public static Solution getInstance() {
        // write your code here
        return sol;
    }
}
