import java.util.PriorityQueue;
import java.util.Queue;


public class PocketGems_PhoneInterview_Cost_of_rod {
	public static int costOfRod(int[] nums){
		if(nums == null || nums.length <= 1){
			return 0;
		}
		
		Queue<Integer> heap = new PriorityQueue<Integer>();
		int cost = 0;
		
		for(int num : nums){
			heap.offer(num);
		}
		
		while(heap.size() >= 2){
			int curCost = heap.poll() + heap.poll();
			cost += curCost;
			heap.offer(curCost);
		}
		
		return cost;
	}
}
