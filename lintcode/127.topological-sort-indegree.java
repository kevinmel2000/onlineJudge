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
        Map<DirectedGraphNode, Integer> inDegree = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode neighbor : node.neighbors) {
                if(inDegree.containsKey(neighbor)) {
                    inDegree.put(neighbor, inDegree.get(neighbor)+1);
                } else {
                    inDegree.put(neighbor, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> q=new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res=new ArrayList<DirectedGraphNode>();
        for(DirectedGraphNode node : graph) {
            if(!inDegree.containsKey(node)) {
                q.add(node);
            }
        }

        while(!q.isEmpty()) {
            DirectedGraphNode next=q.poll();
            res.add(next);
            for(DirectedGraphNode neighbor : next.neighbors) {
                inDegree.put(neighbor, inDegree.get(neighbor)-1);
                if(inDegree.get(neighbor)==0) {
                    //inDegree.remove(neighbor);
                    q.offer(neighbor);
                }
            }
        }
        return res;
    }
}
