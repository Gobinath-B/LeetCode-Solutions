import java.util.ArrayList;
import java.util.List;

class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> groups = new ArrayList<>(); // Step 1: List to store counts of consecutive groups
        char currentChar = s.charAt(0); // Initialize to the first character
        int count = 1; // Start counting the first character

        // Step 2: Count consecutive characters
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentChar) {
                count++; // Increment count if the same character continues
            } else {
                // When character changes
                groups.add(count); // Add count of the previous character
                System.out.println("Group: " + currentChar + ", Count: " + count); // Print the group
                currentChar = s.charAt(i); // Update currentChar to the new character
                count = 1; // Reset count for the new character
            }
        }
        
        // Add the last group
        groups.add(count); // Add count of the last character group
       // System.out.println("Group: " + currentChar + ", Count: " + count); // Print the last group

        // Step 3: Count valid substrings
        int result = 0; // Initialize result
        for (int i = 1; i < groups.size(); i++) {
            result += Math.min(groups.get(i - 1), groups.get(i)); // Count valid substrings
        }

        return result; // Return total count of valid substrings
    }


}
