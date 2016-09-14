import java.util.Deque;
import java.util.LinkedList;


public class PocketGems_PhoneInterview_Sliding_Window_Maximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0){
            return new int[0];
        }
        
        int len = nums.length;
        Deque<Integer> dq = new LinkedList<Integer>();
        int index = 0;
        int[] ans = new int[len - k + 1];
        
        for(int i = 0; i < len; i++){
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i - dq.peekFirst() + 1 > k){
                dq.pollFirst();
            }
            
            if(i + 1 >= k){
                ans[index++] = nums[dq.peekFirst()];
            }
        }
        
        return ans;
    }
}
