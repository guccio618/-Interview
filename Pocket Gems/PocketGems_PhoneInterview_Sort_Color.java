public class PocketGems_PhoneInterview_Sort_Color {
	public static void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int len = nums.length;
		int index0 = 0, index2 = len - 1;
		int curIndex = 0;
		
		while(curIndex <= index2){
			if(nums[curIndex] == 0){
				swap(nums, curIndex++, index0++);
			} else if(nums[curIndex] == 1){
				curIndex++;
			} else if(nums[curIndex] == 2){
				swap(nums, curIndex, index2--);
			}
		}
	}
	
	public static void swap(int[] nums, int x, int y){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
	
	public static void swap(char[] letters, int x, int y){
		char temp = letters[x];
		letters[x] = letters[y];
		letters[y] = temp;
	}
		
	public static void sortColors_follow_up(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int len = nums.length;
		int index1 = 0, index2 = len - 1;
		int curIndex = 0;
		
		while(curIndex <= index2){
			if(nums[curIndex] == 0){
				swap(nums, curIndex++, index1++);
			} else if(nums[curIndex] == 3){
				swap(nums, curIndex, index2--);
			} else {
				curIndex++;
			}
		}
		
		curIndex = index1;
		
		while(curIndex <= index2){
			if(nums[curIndex] == 1){
				swap(nums, curIndex++, index1++);
			} else if(nums[curIndex] == 2){
				swap(nums, curIndex, index2--);
			} else {
				curIndex++;
			}
		}		
	}
	
	public static void sortColors_follow_up2(char[] letters) {
		if (letters == null || letters.length == 0) {
			return;
		}

		int len = letters.length;
		int index1 = 0, index2 = len - 1;
		int curIndex = 0;
		
		while(curIndex <= index2){
			if(letters[curIndex] == '1'){
				swap(letters, curIndex++, index1++);
			} else if(letters[curIndex] == '2'){
				curIndex++;
			} else {
				swap(letters, curIndex, index2--);
			}
		}
	}
	
	

	public static void sortColors2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int len = nums.length;
		int[] index = new int[3];
		int curIndex = 0;

		for (int num : nums) {
			index[num]++;
		}

		while (curIndex < len) {
			for (int i = 0; i < index[0]; i++) {
				nums[curIndex++] = 0;
			}

			for (int i = 0; i < index[1]; i++) {
				nums[curIndex++] = 1;
			}

			for (int i = 0; i < index[2]; i++) {
				nums[curIndex++] = 2;
			}
		}
	}
	
	public static void print(int[] nums){
		for(int num : nums){
			System.out.print(num + ", ");
		}
		System.out.println();
	}
	
	public static void print(char[] letters){
		for(char c : letters){
			System.out.print(c + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		int[] nums = {0,1,2,1,0,2,1,0,1,2,1,0,1};
		sortColors(nums);
		System.out.println("answer : ");
		print(nums);
		
		int[] nums2 = {0,1,2,3,1,0,3,2,1,0,1,3,2,1,0,1};
		sortColors_follow_up(nums2);
		System.out.println("answer : ");
		print(nums2);
		
		char[] letters = {'0','1','2','3','1','0','3','2','1','0','1','3','2','1','0','1'};
		sortColors_follow_up2(letters);
		System.out.println("answer : ");
		print(letters);
	}
}
