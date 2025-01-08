import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list using an array of lists
        List<Integer>[] graph = new ArrayList[n];
        
        // Initialize the array of lists
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph using the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u); // Since the graph is undirected
        }
        
        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        
        // Perform DFS from the source node
        return dfsIterative(source, destination, graph, visited);
    }
    
   private boolean dfsIterative(int source, int destination, List<Integer>[] graph, boolean[] visited) {
        // Create a stack for the DFS traversal
        Stack<Integer> stack = new Stack<>();
        
        // Push the source node to the stack
        stack.push(source);
        
        // While there are nodes to visit
        while (!stack.isEmpty()) {
            // Pop the top node from the stack
            int node = stack.pop();
            
            // If we've already visited this node, skip it
            if (visited[node]) {
                continue;
            }
            
            // Mark the current node as visited
            visited[node] = true;
            
            // Base case: If we've reached the destination
            if (node == destination) {
                return true;
            }
            
            // Explore all the neighbors of the current node
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    stack.push(neighbor); // Push unvisited neighbors onto the stack
                }
            }
        }
        
        // If no valid path is found, return false
        return false;
    }
}
