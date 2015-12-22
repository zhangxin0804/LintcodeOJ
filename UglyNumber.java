class Solution {

    public long kthPrimeNumber(int k) {
        // write your code here
        
        // assume k >= 1
        long res = 0L;
        LinkedList<Long> three = new LinkedList<Long>();
        LinkedList<Long> five = new LinkedList<Long>();
        LinkedList<Long> seven = new LinkedList<Long>();
        three.add(3L);five.add(5L);seven.add(7L);
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        minHeap.offer(3L);minHeap.offer(5L);minHeap.offer(7L);
        
        while( k-- > 0 ){
            long tmp = minHeap.poll();
       		while( !minHeap.isEmpty() && tmp == minHeap.peek() ){
       			minHeap.poll();
       		}
            res = tmp;
            three.add(tmp*3);
            five.add(tmp*5);
            seven.add(tmp*7);
            if( tmp == three.peek() ){
                three.pollFirst();
                minHeap.offer(three.getFirst());
            }
            if( tmp == five.peek() ){
                five.pollFirst();
                minHeap.offer(five.getFirst());
            }
            if( tmp == seven.peek() ){
                seven.pollFirst();
                minHeap.offer(seven.getFirst());
            }
        }
        return res;
    }
}

// Solution 1 --- 暴力brute force, 借助helper函数检测某个数是否为ugly number, Not AC, TLE
// 时间复杂度: O(nlogn)
// 空间复杂度: O(1)

class Solution {

    public long kthPrimeNumber(int k) {
        // assume k >= 1
        
        long res = 0L;
        for(long i = 3L; i <= Long.MAX_VALUE && k > 0; i++){
            if( isUgly(i) ){
                res = i;
                k--;
            }
        }
        return res;
    }
    
    private boolean isUgly(long num){
        
        while( num != 1 ){
            if( num % 3 == 0 ){
                num = num/3;
            }else if( num % 5 == 0 ){
                num = num/5;
            }else if( num % 7 == 0 ){
                num = num/7;
            }else{
                return false;
            }
        }
        return true;
    }
}
