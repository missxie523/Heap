import java.util.*;

public class Test {
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //offer, poll, peek, size, isEmpty, remove
        pq.offer(5);
        pq.offer(3);
        pq.offer(6);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.size());

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.size());

        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.size());

        Queue<Node> nodepq = new PriorityQueue<>(5, new NodeComparator().reversed());
        Queue<Node> nodepq2 = new PriorityQueue<>(5, new NodeComparator());
        Node n1 = new Node(7);
        Node n2 = new Node(3);
        Node n3 = new Node(6);
        nodepq.offer(n1);
        nodepq.offer(n2);
        nodepq.offer(n3);
        System.out.println(nodepq.poll().value);
        nodepq2.offer(n1);
        nodepq2.offer(n2);
        nodepq2.offer(n3);
        System.out.println(nodepq2.poll().value);

        int[] array = {7, 4, 1, 9, 8, 5, 2, 3};
        SmallestK maxHeap = new SmallestK();
        List<Integer> res = maxHeap.maxheap(array, 3);
        for(int r: res){
            System.out.print(r + " ");
        }

        System.out.println();

        SmallestK minHeap = new SmallestK();
        List<Integer> result = minHeap.minheap(array, 3);
        for(int n: result){
            System.out.print(n + " ");
        }
        System.out.println();
        SmallestK quickSelect = new SmallestK();
        List<Integer> ans = quickSelect.quickSelect(array, 3);
        for(int n: ans){
            System.out.print(n + " ");
        }
    }
}
