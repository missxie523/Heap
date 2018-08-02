import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class NodeComparator implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2){
        if(o1.value < o2.value){
            return -1;
        }else if(o1.value > o2.value){
            return 1;
        }else{
            return 0;
        }
    }
}
