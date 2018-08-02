import java.util.*;

/*
Find smallest k elements from an unsorted array of size n.
 */
public class SmallestK {
    /*
    Solution 1: Maintain a max-heap of size k.
    Step 1: heapify the first k-elements, time = O(k).
    Step 2: from the k + 1th element to the nth element, for the current element x,
        if x < max-heap.peek() --> max-heap.poll() and then insert x.
        else, do nothing.
    1. Heapify first k elements O(k)
    2. Iterate, compare, offer, poll: (n - k)log k
    Time = O(k + (n - k) log k)
    If k << n: O(nlogk)
    If k ~= n/2: O(nlogn)
    If k ~= n: O(n)
     */
    public List<Integer> maxheap(int[] array, int k){
        Queue<Integer> maxQ = new PriorityQueue<>(10, Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            maxQ.offer(array[i]);
        }
        for(int i = k; i < array.length; i++){
            if(array[i] < maxQ.peek()){
                maxQ.offer(array[i]);
                maxQ.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!maxQ.isEmpty()){
            res.add(maxQ.poll());
        }
        return res;
    }
    /*
    Solution 2: MinHeap
    Step 1: heapify the whole array O(n)
    Step 2: keep popping k times, O(klogn)
     */
    public List<Integer> minheap(int[] array, int k){
        Queue<Integer> minQ = new PriorityQueue<>();
        for(int a: array){
            minQ.offer(a);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(minQ.poll());
        }
        return res;
    }
    /*
    Solution 3: QuickSelect (O(n) find the kth smallest in an unsorted array.
     */
    public List<Integer> quickSelect(int[] array, int k){
        helper(array, k - 1, 0, array.length - 1);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++){
            list.add(array[i]);
        }
        return list;
    }
    private void helper(int[] array, int k, int left, int right){
        if(array == null || array.length == 0){
            return;
        }
        if(left >= right){
            return;
        }
        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(array, pivotIndex, right);
        int l = left, r = right - 1;
        while(l <= r){
            if(array[l] < array[right]){
                l++;
            }else{
                swap(array, l, r);
                r--;
            }
        }
        swap(array,l,right);
        if(k == l){
            return;
        }else if(k < l){
            helper(array, k, left, l - 1);
        }else{
            helper(array, k, l + 1, right);
        }
    }
    private void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
