class Solution {

    static int findPivotIndex(int[] nums) {
        int n = nums.length;
        int s = 0;
        int e = n - 1;
        int ans = -1;

        // Array is already sorted
        if (nums[s] < nums[e]) {
            return -1;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= nums[n - 1]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    static int binarySearch(int[] nums, int s, int e, int target) {

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                s = mid + 1;
            } 
            else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int pivotIndex = findPivotIndex(nums);
        int n = nums.length;

        // Array is not rotated
        if (pivotIndex == -1) {
            return binarySearch(nums, 0, n - 1, target);
        }

        // First sorted part: 0 to pivotIndex
        int startArray1 = 0;
        int endArray1 = pivotIndex;

        if (target >= nums[startArray1] && target <= nums[endArray1]) {
            return binarySearch(nums, startArray1, endArray1, target);
        }

        // Second sorted part: pivotIndex + 1 to n - 1
        int startArray2 = pivotIndex + 1;
        int endArray2 = n - 1;

        if (target >= nums[startArray2] && target <= nums[endArray2]) {
            return binarySearch(nums, startArray2, endArray2, target);
        }

        return -1;
    }
}