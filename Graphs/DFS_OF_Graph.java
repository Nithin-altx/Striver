class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    void dfs(int node,ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res,  boolean []vis)
    {
        vis[node]=true;
        res.add(node);
        List<Integer> ls=adj.get(node);
        for(int x:ls)
        {
            if(vis[x]==false)
            {
                dfs(x,adj,res,vis);
            }
           
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> res=new ArrayList<>();
        boolean []vis=new boolean[adj.size()];
        dfs(0,adj,res,vis);
        return res;
    }
}
