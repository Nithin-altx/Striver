//GFG SOLUTION
class Solution {
    boolean dfs(Map<Integer,List<Integer>> adj,int  color[],int u,int c)
    {
        color[u]=c;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(color[ngbr]==c)
            return false;
            
            if(color[ngbr]==-1)
            {
               if(!dfs(adj,color,ngbr,1-c))
               {
                   return false;
               }
            }
        }
        return true;
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int  color[]=new int[V];
        for(int i=0;i<V;i++)
        {
            color[i]=-1;
        }
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int edg[]:edges)
        {
            int u=edg[0];
            int v=edg[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(dfs(adj,color,i,1)==false)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
//Using LC

class Solution {
    boolean dfs(Map<Integer,List<Integer>> adj, int color[],int u,int c)
    {
        color[u]=c;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(color[ngbr]==c)
            return false;

            if(color[ngbr]==-1)
            {
                if(!dfs(adj,color,ngbr,1-c))
                return false;
            }
        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.computeIfAbsent(i,k->new ArrayList<>()).add(graph[i][j]);
            }
        }
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(adj,color,i,1))
                {
                    return false;
                }
            }
        }
        return true;

        
    }
}
//Using Bfs
class Solution {
    boolean bfs(Map<Integer,List<Integer>> adj, int color[],int u,int c)
    {
        Queue<int[]> pq=new LinkedList<>();
        pq.offer(new int[]{u,c});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int node=curr[0];
            int c0=curr[1];
            color[node]=c0;
        for(int ngbr:adj.getOrDefault(node,new ArrayList<>()))
        {
            if(color[ngbr]==c0)
            return false;

            if(color[ngbr]==-1)
            {
                pq.offer(new int[]{ngbr,1-c0});
            }
        }

        }
        return true;

    }
    public boolean isBipartite(int[][] graph) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                adj.computeIfAbsent(i,k->new ArrayList<>()).add(graph[i][j]);
            }
        }
        int color[]=new int[graph.length];
        Arrays.fill(color,-1);
        for(int i=0;i<color.length;i++)
        {
            if(color[i]==-1)
            {
                if(!bfs(adj,color,i,1))
                {
                    return false;
                }
            }
        }
        return true;

        
    }
}
