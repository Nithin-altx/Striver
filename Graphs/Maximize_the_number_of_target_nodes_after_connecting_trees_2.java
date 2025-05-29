class Solution {
    void dfs(int i,Map<Integer,List<Integer>> mp,int answer1[],int num, boolean vis[])
    {
        answer1[i]=num;
        vis[i]=true;
        List<Integer> ngbr=mp.getOrDefault(i,new ArrayList<>());
        if(ngbr.size()==0)
        return;

        for(int v:ngbr)
        {
            if(vis[v]==false)
            {
                vis[v]=true;
                dfs(v,mp,answer1,1-num,vis);
            }
        }
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int n=edges1.length;
        int mark1[]=new int[n+1];
        int m=edges2.length;
        int mark2[]=new int[m+1];
        Map<Integer,List<Integer>> mp=new HashMap<>();
        Map<Integer,List<Integer>> mp1=new HashMap<>();
        for(int edge[]:edges1)
        {
            int u=edge[0];
            int v=edge[1];
            mp.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            mp.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
           for(int edge[]:edges2)
        {
            int u=edge[0];
            int v=edge[1];
            mp1.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            mp1.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        boolean vis[]=new boolean[n+1];
        dfs(0,mp,mark1,0,vis);
        int zerocount=0;
        int onecount=0;
         int answer1[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            if(mark1[i]==0)
            zerocount++;
            else
            onecount++;
        }
        for(int i=0;i<=n;i++)
        {
            if(mark1[i]==0)
            {
                answer1[i]+=zerocount;
            }
            else{
                answer1[i]+=onecount;
            }
        }
        boolean viss[]=new boolean[m+1];
        dfs(0,mp1,mark2,1,viss);
        int zerocount1=0;
        int onecount1=0;
        for(int i=0;i<=m;i++)
        {
            if(mark2[i]==0)
             zerocount1++;
            else
            onecount1++;
           
        }
        int max=0;
        max=Math.max(onecount1, zerocount1);
        for(int i=0;i<=n;i++)
        {
            answer1[i]+=max;
        }

        return answer1;

        
    }
}
