
public class PocketGems_PhoneInterview_Find_Equal_Index {
	// 注意，不含 0 和 len - 1
	public static int findEqualIndex(int[] nums, int target){
		if(nums == null || nums.length <= 2){
			return -1;
		}
		
		int totalCount = 0;
		int len = nums.length;
		int rightCount = nums[len - 1] == target ? 1 : 0;
		
		for(int i = 0; i < len - 1; i++){
			if(nums[i] == target){
				totalCount++;
			}
		}
		
		for(int i = len - 2; i > 0; i--){
			if(nums[i] == target){
				totalCount--;
			}
			
			if(totalCount == len - 1 - i - rightCount){
				return i;
			}
			
			if(nums[i] == target){
				rightCount++;
			}
		}
		
		return -1;
	}
	
	public static int findEqualIndex2(int[] nums, int target){
		if(nums == null || nums.length <= 2){
			return -1;
		}
		
		int len = nums.length;
		int[] contain = new int[len];
		int[] uncontain = new int[len];
		int count = 0;
		
		for(int i = 0; i < len; i++){
			if(nums[i] == target){
				count++;
			}
			contain[i] = count;
		}
		
		count = 0;
		
		for(int i = len - 1; i >= 0; i--){
			if(nums[i] != target){
				count++;
			}
			uncontain[i] = count;
		}
		
		for(int i = len - 2; i > 0; i--){
			if(contain[i - 1] == uncontain[i + 1]){
				return i;
			}
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args){
		int[] nums = {6, 4, 1, 5, 6, 2, 5, 6, 2, 6};
		int[] nums2 = {2, 4, 1, 5, 6, 2, 5, 6, 2, 2};
		int[] nums3 = {2,2,2};
		System.out.println(findEqualIndex(nums3, 2));
		System.out.println(findEqualIndex2(nums3, 2));
	}
}
