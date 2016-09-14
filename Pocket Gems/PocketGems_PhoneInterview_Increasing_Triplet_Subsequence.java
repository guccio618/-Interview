
public class PocketGems_PhoneInterview_Increasing_Triplet_Subsequence {
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3){
            return false;
        }
        
        int[] sequence = new int[3];
        sequence[0] = sequence[1] = sequence[2] = Integer.MAX_VALUE;
        
        for(int num : nums){
            if(num <= sequence[0]){
                sequence[0] = num;
            } else if(num <= sequence[1]){
                sequence[1] = num;
            } else if(num <= sequence[2]){
                sequence[2] = num;
            }
        }
        
        return sequence[2] != Integer.MAX_VALUE;
    }
}
