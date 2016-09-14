
public class PocketGems_PhoneInterview_Kth_Largest_Element_in_an_Array {
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || k > nums.length){
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        
        while(left < right){
            int index = Partition(nums, left, right);
            
            if(index + 1 < k){
                left = index + 1;
            } else if(index + 1 > k){
                right = index - 1;
            } else {
                return nums[index];
            }
        }
        
        return nums[left];
    }
    
    public int Partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int temp = 0;
        int index = left;
        
        for(int i = left; i < right; i++){
            if(nums[i] >= pivot){
                temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
        
        temp = nums[index];
        nums[index] = nums[right];
        nums[right] = temp;
        return index;
    }
}
