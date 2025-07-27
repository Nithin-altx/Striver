class Solution {
    // Function to detect cycle using DSU in an undirected graph.
    int []parent;
    int []rank;
    int find(int i,int[]parent)
    {
        if(i==parent[i])
        {
            return i;
        }
        return parent[i]=find(parent[i],parent);
    }
    void union(int x,int y,int []parent)
    {
        int x_parent=find(x,parent);
        int y_parent=find(y,parent);
        
        if(x_parent==y_parent)
        return ;
        
        if(rank[x_parent]>rank[y_parent])
        {
            parent[y_parent]=x_parent;
        }
        else if(rank[x_parent]<rank[y_parent])
        {
            parent[x_parent]=y_parent;
        }
        else{
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        parent=new int[V];
        for(int i=0;i<V;i++)
        {
            parent[i]=i;
        }
        rank=new int[V];
        for(int u=0;u<V;u++)
        {
            for(int v:adj.get(u))
            {
                if(u<v)
                {
                    int parent_u=find(u,parent);
                    int parent_v=find(v,parent);
                    if(parent_u==parent_v)
                    {
                        return 1;
                    }
                    union(u,v,parent);
                }
            }
        }
        return 0;
        
    }
}
