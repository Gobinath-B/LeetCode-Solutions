import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list using a List of Lists
        List<List<Integer>> graph = new ArrayList<>();
        
        // Initialize the list of lists (for each node, a list of neighbors)
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph using the edges
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];  // person u
            int v = edges[i][1];  // person v
            graph.get(u).add(v);   // Add v to u's adjacency list
            graph.get(v).add(u);   // Add u to v's adjacency list (undirected graph)
        }
        
        // Create a visited array to keep track of visited nodes
        boolean[] visited = new boolean[n];
        
        // Perform DFS from the source node
        return dfsIterative(source, destination, graph, visited);
    }
    
    private boolean dfsIterative(int source, int destination, List<List<Integer>> graph, boolean[] visited) {
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
            for (int i = 0; i < graph.get(node).size(); i++) {
                int neighbor = graph.get(node).get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor); // Push unvisited neighbors onto the stack
                }
            }
        }
        
        // If no valid path is found, return false
        return false;
    }
}
