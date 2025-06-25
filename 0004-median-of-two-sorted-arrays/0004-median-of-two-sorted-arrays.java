class Solution {

    /**
    int j = (m + n + 1) / 2 - i; why instead of
    int j = (m + n ) / 2 - i;
    
    +1 biases the partition to ensure the extra element (when odd total) stays on the left side, which is where we compute the median from.
     */

     /**
     why right is m not n

     to keep complexity O(log(min(m, n)))
      */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
        return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int left=0, right=m, median=(m+n+1)/2;

        while (left<=right){
            int i= (left+right)/2;
            int j = median-i;
            int nums1left = (i==0)?Integer.MIN_VALUE: nums1[i-1];
            int nums1right = (i==m)?Integer.MAX_VALUE:nums1[i];
            int nums2left = (j==0)?Integer.MIN_VALUE: nums2[j-1];
            int nums2right = (j==n)?Integer.MAX_VALUE: nums2[j];

            if (nums1left<= nums2right && nums2left <= nums1right){
                if ((m+n)%2==0)
                 return (Math.max(nums1left, nums2left) + Math.min(nums1right, nums2right))/2.0;
                 return (double) Math.max(nums1left, nums2left);
            }
            if (nums1left > nums2right)
            right=i-1;
            else
            left=i+1;

        }
        return 0;

    }
}