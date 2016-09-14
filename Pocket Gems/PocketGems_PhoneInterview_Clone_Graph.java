import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class PocketGems_PhoneInterview_Clone_Graph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if(root == null){
            return null;
        }
        
        UndirectedGraphNode copyRoot = new UndirectedGraphNode(root.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Queue<UndirectedGraphNode> copyQueue = new LinkedList<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.offer(root);
        copyQueue.offer(copyRoot);
        map.put(root, copyRoot);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            UndirectedGraphNode copyNode = copyQueue.poll();
            
            for(UndirectedGraphNode nextNode : node.neighbors){
                if(map.containsKey(nextNode)){
                    copyNode.neighbors.add(map.get(nextNode));
                } else {
                    UndirectedGraphNode copyNextNode = new UndirectedGraphNode(nextNode.label);
                    copyNode.neighbors.add(copyNextNode);
                    map.put(nextNode, copyNextNode);
                    queue.offer(nextNode);
                    copyQueue.offer(copyNextNode);
                }
            }
        }
        
        return copyRoot;
    }
}
