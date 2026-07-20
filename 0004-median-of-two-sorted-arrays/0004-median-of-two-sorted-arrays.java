class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];

        int index = 0;

        for(int num : nums1){
            arr[index++] = num;
        }

        for(int num : nums2){
            arr[index++] = num;
        }

        Arrays.sort(arr);

        int n = arr.length;

        if(n % 2 == 1){
            return arr[n/2];
        }

        return (arr[n/2] + arr[n/2 - 1]) / 2.0;
    }
}