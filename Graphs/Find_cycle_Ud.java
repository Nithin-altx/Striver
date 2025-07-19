class Solution {
    boolean Dfs(Map<Integer,List<Integer>>adj, boolean vis[],int parent[],int u)
    {
        
        vis[u]=true;
        for(int ngbr: adj.getOrDefault(u, new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                parent[ngbr]=u;
                if(Dfs(adj,vis,parent,ngbr))
                {
                    return true;
                }
            }
            else if(ngbr!=parent[u])
            {
                return true;
            }
            
        }
        return false;
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int parent[]=new int[V];
       Arrays.fill(parent, -1);
        boolean vis[]=new  boolean[V];
        Map<Integer,List<Integer>>adj=new HashMap<>();
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
           for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            if (Dfs(adj, vis, parent, i)) {
                return true; // cycle found
            }
        }
    }

    return false;
    }
}
//2nd way
class Solution {
    boolean Dfs(Map<Integer,List<Integer>>adj, boolean vis[],int parent,int u)
    {
        
        vis[u]=true;
        for(int ngbr: adj.getOrDefault(u, new ArrayList<>()))
        {
           if(ngbr==parent)
           {
               continue;
           }
           if(vis[ngbr]==true)
           return true;
           
           if(!vis[ngbr])
           {
               if(Dfs(adj,vis,u,ngbr))
               {
                   return true;
               }
           }
            
        }
        return false;
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
       
        boolean vis[]=new  boolean[V];
        Map<Integer,List<Integer>>adj=new HashMap<>();
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
           for (int i = 0; i < V; i++) {
        if (!vis[i]) {
            if (Dfs(adj, vis, -1, i)) {
                return true; // cycle found
            }
        }
    }

    return false;
    }
}
