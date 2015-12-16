/*
Given k sorted integer arrays, merge them into one sorted array.

Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge
Do it in O(N log k).

N is the total number of integers.
k is the number of arrays.
*/

// Solution 1 --- 分治递归merge k sorted array, 注意helper函数的返回值类型和最终返回值类型的差别。
// 时间复杂度: 一共K个array, 分治递归一共logK层，每层一共要移动Merge的元素就是总共元素N个，所以O(NlogK)
// 空间复杂度: O(N), 中间环节创建的那些数组，就当做随着函数结束，释放掉了。

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        if( arrays == null || arrays.length == 0 || arrays[0].length == 0 ){
            return new ArrayList<Integer>();
        }
        int length = arrays.length;
        int[] tmp = mergeKsortedArray(arrays, 0, length-1);
        // 返回值List类型，所以要再重新拷贝一次。
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < tmp.length; i++){
            result.add(tmp[i]);
        }
        return result;
    }
    
    private int[] mergeKsortedArray(int[][] arrays, int left, int right){
        
        if( left == right ){
            return arrays[left];
        }
        int middle = left + ((right-left) >> 1);
        int[] leftRes = mergeKsortedArray(arrays, left, middle);
        int[] rightRes = mergeKsortedArray(arrays, middle+1, right);
        return merge2sortedArray(leftRes, rightRes);
    }
    
    private int[] merge2sortedArray(int[] a, int[] b){
        int length1 = a.length;
        int length2 = b.length;
        int[] res = new int[length1+length2];
        int count = length1 + length2 - 1;
        length1--;
        length2--;
        while( length1 >= 0 && length2 >= 0 ){
            if( a[length1] >= b[length2] ){
                res[count--] = a[length1];
                length1--;
            }else{
                res[count--] = b[length2];
                length2--;
            }
        }
        while( length1 >= 0 ){
            res[count--] = a[length1];
            length1--;            
        }
        while( length2 >= 0 ){
            res[count--] = b[length2];
            length2--;            
        }
        return res;
    }
}


// Solution 2 --- 将思路转化到merge k sorted lists上去，因此用minHeap维护size = K的优先队列，需要注意不同于merge k sorted lists
//                我们要想办法，每次把元素poll后要能够找到其所属的那个array的下一个index元素再添加入minHeap才行。因此，自建一个class
//                分别存储元素值, 所述的array, 以及在所属的array中的index位置。这样方便后序元素拼成Node加入min heap.
// 时间复杂度: O(NlogK)
// 空间复杂度: O(N), 因为创建了N个nodes, heap中的空间是O(k)

class Node{
    int val;
    int arrayIndex;
    int valIndex;
    Node(int x, int y, int z){
            val = x;
            arrayIndex = y;
            valIndex = z;
    }
}
class NodeComparator implements Comparator<Node>{
    public int compare(Node o1, Node o2){
            return o1.val - o2.val;
    }
}
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if( arrays == null || arrays.length == 0 || arrays[0].length == 0 ){
            return res;
        }
        int length = arrays.length;
        NodeComparator comp = new NodeComparator();
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>(length, comp);
        for(int i = 0; i < length; i++){
            minHeap.offer( new Node(arrays[i][0], i, 0) );
        }
        while( !minHeap.isEmpty() ){
            Node crt = minHeap.poll();
            res.add(crt.val);
            if( crt.valIndex + 1 < arrays[crt.arrayIndex].length ){
                minHeap.offer( new Node(arrays[crt.arrayIndex][crt.valIndex+1],crt.arrayIndex, crt.valIndex+1) );
            }
        }
        return res;
    }
}
