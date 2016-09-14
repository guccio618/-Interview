
public class PocketGems_PhoneInterview_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int len = nums.length;
        int curMax = 0, curMin = 0;
        int prevMax = nums[0], prevMin = nums[0], ans = nums[0];
        
        for(int i = 1; i < len; i++){
            if(nums[i] > 0){
                curMax = Math.max(nums[i], prevMax * nums[i]);
                curMin = Math.min(nums[i], prevMin * nums[i]);
            } else {
                curMax = Math.max(nums[i], prevMin * nums[i]);
                curMin = Math.min(nums[i], prevMax * nums[i]);
            }
            
            ans = Math.max(ans, curMax);
            prevMax = curMax;
            prevMin = curMin;
        }
        
        return ans;
    }
}
