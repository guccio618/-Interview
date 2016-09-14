import java.util.HashSet;
import java.util.Set;


public class PocketGems_PhoneInterview_Longest_Consecutive_Sequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        int len = nums.length;
        int maxLen = 0;
        
        for(int num : nums){
            set.add(num);
        }
        
        for(int i = 0; i < len; i++){
            int left = nums[i] - 1;
            int right = nums[i] + 1;
            
            while(set.contains(left)){
                set.remove(left);
                left--;
            }
            
            while(set.contains(right)){
                set.remove(right);
                right++;
            }
            
            maxLen = Math.max(maxLen, right - left - 1);
        }
        
        return maxLen;
    }
}
