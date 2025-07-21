class Solution {
    void dfs(Map<Integer,List<Integer>> adj,int u,boolean vis[])
    {
        vis[u]=true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                dfs(adj,ngbr,vis);
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int n=isConnected.length;
        int m=isConnected[0].length;
       for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                    {
                        if(i==j)
                            continue;
                        if(isConnected[i][j]==1)
                        {
                            adj.computeIfAbsent(i+1,k->new ArrayList<>()).add(j+1);
                        }
                    }
            }
        boolean vis[]=new boolean[isConnected.length+1];
        int count=0;
        for(int i=1;i<=isConnected.length;i++)
        {
            if(!vis[i])
            {
                count++;
                dfs(adj,i,vis);
                
            }
        }
        return count;
        
    }
}
//Using BFS
class Solution {
    void bfs(Map<Integer,List<Integer>> adj,int u,boolean vis[])
    {
        Queue<Integer> pq=new LinkedList<>();
        pq.offer(u);
        vis[u]=true;
        while(!pq.isEmpty())
        {
            int curr=pq.poll();
        for(int ngbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                vis[ngbr]=true;
                pq.offer(ngbr);
            }
        }

        }
        

    }
    public int findCircleNum(int[][] isConnected) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int n=isConnected.length;
        int m=isConnected[0].length;
       for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                    {
                        if(i==j)
                            continue;
                        if(isConnected[i][j]==1)
                        {
                            adj.computeIfAbsent(i+1,k->new ArrayList<>()).add(j+1);
                        }
                    }
            }
        boolean vis[]=new boolean[isConnected.length+1];
        int count=0;
        for(int i=1;i<=isConnected.length;i++)
        {
            if(!vis[i])
            {
                count++;
                bfs(adj,i,vis);
                
            }
        }
        return count;
        
    }
}
