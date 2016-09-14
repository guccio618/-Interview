import java.util.Arrays;
import java.util.Comparator;


public class PocketGems_PhoneInterview_Contains_Duplicate_III {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0){
            return false;
        }
        
        int len = nums.length;
        Node[] array = new Node[len];
        
        for(int i = 0; i < len; i++){
            array[i] = new Node(i, nums[i]);
        }
        
        Arrays.sort(array, new Comparator<Node>(){
            public int compare(Node left, Node right){
                if(left.value != right.value){
                    return left.value - right.value;
                } else {
                    return left.index - right.index;
                }
            }
        });
        
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len && Math.abs((long) array[i].value - (long) array[j].value) <= (long) t; j++){
                if(Math.abs(array[i].index - array[j].index) <= k){
                    return true;
                }
            }
        }
        
        return false;
    }
	
	class Node {
	    int index;
	    int value;
	    
	    public Node(int index, int value){
	        this.index = index;
	        this.value = value;
	    }
	}
}


