class Solution {
    static void Dfs( Map<Integer,List<Integer>> adj,Stack<Integer> st,boolean vis[],int u)
    {
        vis[u]=true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                Dfs(adj,st,vis,ngbr);
            }
        }
        st.add(u);
        
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
        boolean  vis[]=new boolean[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                Dfs(adj,st,vis,i);
                
            }
        }
        while(!st.isEmpty())
        {
            res.add(st.pop());
        }
        return res;
        
    }
}
