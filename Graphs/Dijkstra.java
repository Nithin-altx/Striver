class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        Map<Integer,List<List<Integer>>> adj=new HashMap<>();
        for(int e[]:edges)
        {
            int u=e[0];
            int v=e[1];
            int w=e[2];
            List<Integer> ls=new ArrayList<>();
            ls.add(v);
            ls.add(w);
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(ls);
        }
        int res[]=new int[V];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
              if(a[0]==b[0])
            return Integer.compare(a[1],b[1]);
            else
            return Integer.compare(a[0],b[0]);
            
        });
        pq.add(new int[]{0,src});
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int dis=curr[0];
            int node=curr[1];
            for(List<Integer> ls:adj.get(node))
            {
                int newnode=ls.get(0);
                int newdis=ls.get(1);
                if(dis+newdis<res[newnode])
                {
                    res[newnode]=dis+newdis;
                    pq.offer(new int[]{dis+newdis,newnode});
                }
                
            }
        }
        return res;
    }
}