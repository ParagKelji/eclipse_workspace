
// 1, 2, 3 => 3/2 = 1.5 => Math.ceil => 2
// 1, 2 => 2/2 = 1
// 1, 2, 3, 4 => 4/2 = 2 
public class BinarySearch {
	
	public int search(int nums[], int numToFind) {
		int index = -1;
		if ( nums == null || nums.length == 0) {
			return index;
		}
		int startIndex = 0;
		int lastIndex = (nums.length - 1);
		int mid = -1;
		while (startIndex <= lastIndex) {
			mid = (lastIndex + startIndex) / 2;
			if (nums[mid] == numToFind) {
				index = mid;
				break;
			}
			if ( nums[mid] >= numToFind ) {
				lastIndex = mid - 1;
			} else {
				startIndex = mid + 1;
			}
			
		}
		return index;
	}
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		int nums1[] = {1,2};
		System.out.println(binarySearch.search(nums1, 0));
		System.out.println(binarySearch.search(nums1, 3));
		System.out.println(binarySearch.search(nums1, 2));
		int nums2[] = {1,2,3};
		System.out.println(binarySearch.search(nums2, 0));
		System.out.println(binarySearch.search(nums2, 4));
		System.out.println(binarySearch.search(nums2, 2));
		System.out.println(binarySearch.search(nums2, 1));
		System.out.println(binarySearch.search(nums2, 3));
	}

}
