/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        int n=graph.size();
        Stack<DirectedGraphNode> stk=new Stack<DirectedGraphNode>();
        HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();
        for(int i=0;i<n;i++) {
            if(!visited.contains(graph.get(i))) {
                dfs(graph.get(i), visited, stk);
            }
        }
        ArrayList<DirectedGraphNode> res=new ArrayList<DirectedGraphNode>();
        while(!stk.empty()) {
            res.add(stk.pop());
        }
        return res;
    }
    
    public void dfs(DirectedGraphNode node, HashSet<DirectedGraphNode> visited, Stack<DirectedGraphNode> res) {
        visited.add(node);
        for(DirectedGraphNode n : node.neighbors) {
            if(!visited.contains(n)) {
                dfs(n, visited, res);
            }
        }
        res.push(node);
    }
}
