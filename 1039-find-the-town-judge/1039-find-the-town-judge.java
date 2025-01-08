class Solution {
    public int findJudge(int n, int[][] trust) {
        // Initialize two arrays to count the number of people each person trusts and is trusted by.
        int[] trustCount = new int[n + 1];  // trustCount[i] will store how many people trust person i
        int[] trustedByCount = new int[n + 1];  // trustedByCount[i] will store how many people person i trusts
        
        // Process the trust relationships using a traditional for loop
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];  // person a trusts person b
            int b = trust[i][1];  // person b is trusted by person a
            trustedByCount[b]++;  // b is trusted by a
            trustCount[a]++;  // a trusts b
        }
        
        // Find the person who satisfies the condition of being the judge using a traditional for loop
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == 0 && trustedByCount[i] == n - 1) {
                return i;  // Person i is the judge
            }
        }
        
        return -1;  // No judge found
    }
}
