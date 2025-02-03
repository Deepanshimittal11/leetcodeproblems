class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        
        result[0] = findLeft(nums, target);
        result[1] = findRight(nums, target);
        
        return result;
    }
     private int findLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                leftIndex = mid;
                right = mid - 1;  // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }
        
        return leftIndex;
    }
    
    // Helper function to find the rightmost index of the target
    private int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                rightIndex = mid;
                left = mid + 1;  // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;  // Search in the right half
            } else {
                right = mid - 1;  // Search in the left half
            }
        }
        
        return rightIndex;
    }

}