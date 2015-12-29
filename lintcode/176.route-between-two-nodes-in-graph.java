/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if(s==t) return true;
        Queue<DirectedGraphNode> q=new LinkedList<>();
        Set<DirectedGraphNode> visited=new HashSet<>();
        q.offer(s);
        visited.add(s);
        while(!q.isEmpty()) {
            DirectedGraphNode top=q.poll();
            for(DirectedGraphNode n : top.neighbors) {
                if(n==t) return true;
        if(!visited.contains(n)) {
                    q.offer(n);
                    visited.add(n);
                }
            }
        }
        return false;
    }
}
