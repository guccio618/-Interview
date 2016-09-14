
public class PocketGems_PhoneInterview_First_Occurrence_of_Binary_Search {
	public static int firstOccurenceBinarySearch(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		
		int left = 0, right = nums.length - 1;
		
		while(left + 1 < right){
			int mid = left + (right - left) / 2;
			
			if(nums[mid] < target){
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if(nums[left] == target){
			return left;
		} else if(nums[right] == target){
			return right;
		} else {
			return -1;
		}
	}
	
	
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,5,6,6,7,8,9};
		
		System.out.println(firstOccurenceBinarySearch(nums, 6));
	}
}
