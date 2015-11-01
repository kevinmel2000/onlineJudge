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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public class UFNode {
        int parent;
        int rank;
        UFNode(int p, int r) {
            parent=p;
            rank=r;
        }
    }
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        int ns=nodes.size();
        for(DirectedGraphNode n : nodes) {
            parents.put(n.label, new UFNode(n.label, 1));    
        }
        
        for(DirectedGraphNode n : nodes) {
            for(DirectedGraphNode n1 : n.neighbors) {
                union(n1.label, n.label);
            }
        }
        
        HashMap<Integer, List<Integer>> resList=new HashMap<Integer, List<Integer>>();
        for(Integer i : parents.keySet()) {
            int root = find(i).parent;
            if(!resList.containsKey(root)) {
                resList.put(root, new ArrayList<Integer>());
            }
            resList.get(root).add(i);
        }
        
        List<List<Integer>> res=new ArrayList<>();
        for(Integer i : resList.keySet()) {
            Collections.sort(resList.get(i));
            res.add(resList.get(i));
        }
        return res;
    }

    private HashMap<Integer, UFNode> parents = new HashMap<>();

    private void union(int x, int y) {
        UFNode px=find(x);
        UFNode py=find(y);
            
        if(px==py) return;
        if(px.rank<py.rank) {
            px.parent=py.parent;
        } else {
            py.parent=px.parent;
            if(px.rank==py.rank){
                px.rank++;
            }
        }
    }
    
    private UFNode find(int x) {
        if(x!=parents.get(x).parent) {
            parents.get(x).parent=find(parents.get(x).parent).parent;
        }
        return parents.get(parents.get(x).parent);
    }
}

