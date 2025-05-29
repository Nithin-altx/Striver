//Using dfs
class Solution {
    int dfs(int i,Map<Integer,List<Integer>> mp,int k,boolean vis[])
    {
        
        if(k<0)
        return 0;
        int count=1;
        vis[i]=true;
        List<Integer> ngbr=mp.getOrDefault(i,new ArrayList<>());
        for(int v:ngbr)
        {
            if(vis[v]==false){
            count+=dfs(v,mp,k-1,vis);
            }
        }
        
      return count;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length;
        int m=edges2.length;
        int answer[]=new int[n+1];
        int tree2[]=new int[m+1];
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int edge[]:edges1)
        {
            int u=edge[0];
            int v=edge[1];
            mp.computeIfAbsent(u,l->new ArrayList<>()).add(v);
            mp.computeIfAbsent(v,l->new ArrayList<>()).add(u);
        }
        Map<Integer,List<Integer>> mp1=new HashMap<>();
        for(int edge[]:edges2)
        {
            int u=edge[0];
            int v=edge[1];
            mp1.computeIfAbsent(u,l->new ArrayList<>()).add(v);
            mp1.computeIfAbsent(v,l->new ArrayList<>()).add(u);
        }
        for(int i=0;i<=n;i++)
        {
            boolean vis[]=new boolean[n+1];
           answer[i]=dfs(i,mp,k,vis);
        }
        for(int i=0;i<=m;i++)
        {
              boolean vis[]=new boolean[m+1];
              tree2[i]=dfs(i,mp1,k-1,vis);
        }
        int max=0;
        for(int i=0;i<=m;i++)
        {
            max=Math.max(max,tree2[i]);
        }
        for(int i=0;i<=n;i++)
        {
            answer[i]+=max;
        }
        return answer;
        
    }
}
//Using BFS
class Solution {
    int BFS(int i,Map<Integer,List<Integer>> mp,int k,boolean vis[])
    {
        Queue<int[]> pq=new LinkedList<>();
        pq.offer(new int[]{i,0});
        vis[i]=true;
        int count=0;
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int node=curr[0];
            int dist=curr[1];
            if(dist>k)
            continue;
            List<Integer> ngbr=mp.getOrDefault(node,new ArrayList<>());
            count++;
            for(int v:ngbr)
            {
                if(vis[v]==false)
                {
                    vis[v]=true;
                    pq.offer(new int[]{v,dist+1});
                }
            }  
        }   
      return count;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length;
        int m=edges2.length;
        int answer[]=new int[n+1];
        int tree2[]=new int[m+1];
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int edge[]:edges1)
        {
            int u=edge[0];
            int v=edge[1];
            mp.computeIfAbsent(u,l->new ArrayList<>()).add(v);
            mp.computeIfAbsent(v,l->new ArrayList<>()).add(u);
        }
        Map<Integer,List<Integer>> mp1=new HashMap<>();
        for(int edge[]:edges2)
        {
            int u=edge[0];
            int v=edge[1];
            mp1.computeIfAbsent(u,l->new ArrayList<>()).add(v);
            mp1.computeIfAbsent(v,l->new ArrayList<>()).add(u);
        }
        for(int i=0;i<=n;i++)
        {
            boolean vis[]=new boolean[n+1];
           answer[i]=BFS(i,mp,k,vis);
        }
        for(int i=0;i<=m;i++)
        {
              boolean vis[]=new boolean[m+1];
              tree2[i]=BFS(i,mp1,k-1,vis);
        }
        int max=0;
        for(int i=0;i<=m;i++)
        {
            max=Math.max(max,tree2[i]);
        }
        for(int i=0;i<=n;i++)
        {
            answer[i]+=max;
        }
        return answer;
        
    }
}
