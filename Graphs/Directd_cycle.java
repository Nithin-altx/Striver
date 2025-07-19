//DFS
class Solution {
    boolean Dfs( Map<Integer,List<Integer>> adj,boolean vis[],boolean inrec[],int u)
    {
        vis[u]=true;
        inrec[u]=true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(vis[ngbr]==false)
            {
                if(Dfs(adj,vis,inrec,ngbr))
                {
                    return true;
                }
            }
            if(inrec[ngbr]==true)
            return true;
        }
        inrec[u]=false;
        return false;
      
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
        boolean vis[]=new boolean[V];
        boolean inrec[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(Dfs(adj,vis,inrec,i))
                {
                    return true;
                }
            }
        }
        return false;
        
    }
}
//BFS

