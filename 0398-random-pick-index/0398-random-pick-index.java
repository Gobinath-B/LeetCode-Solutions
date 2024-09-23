import java.util.*;

class Solution {
    private int[] nums;  // The array of numbers
    private Random random;  // Random number generator

    // Constructor to initialize the array and Random instance
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    // Method to pick a random index where target occurs in nums
    public int pick(int target) {
        List<Integer> indices = new ArrayList<>();  // List to store indices where target is found
        
        // Iterate through the array to find all indices where nums[i] == target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indices.add(i);  // Add the index to the list
            }
        }
        
        // Pick a random index from the list of indices where target occurs
        return indices.get(random.nextInt(indices.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
