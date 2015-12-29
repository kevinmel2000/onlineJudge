/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> solution=new ArrayList<>();
        for(UndirectedGraphNode n : nodes) {
            if(!visited.contains(n.label)) {
                List<Integer> res=new ArrayList<Integer>();
                dfs(n, res);
                Collections.sort(res);
                solution.add(res);
            }
        }
        return solution;
    }
    
    private void dfs(UndirectedGraphNode node, List<Integer> res) {
        visited.add(node.label);
        res.add(node.label);
        rectedGraphNode n : node.neighbors) {
            if(!visited.contains(n.label)) {
                dfs(n, res);
            }
        }
    }
    
    private HashSet<Integer> visited = new HashSet<Integer>();
}

