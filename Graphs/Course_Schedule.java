//Using DfS
class Solution {
    boolean dfs(Map<Integer,List<Integer>> adj,boolean vis[],boolean inrec[],int u)
    {
        vis[u]=true;
        inrec[u]=true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                if(dfs(adj,vis,inrec,ngbr))
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
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int pre[]:prerequisites)
        {
            int u=pre[0];
            int v=pre[1];
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        boolean vis[]=new boolean[numCourses];
        boolean inrec[]=new boolean[numCourses];
        boolean b=false;
        for(int i=0;i<numCourses;i++)
        {
            if(!vis[i]){
                 if(dfs(adj,vis,inrec,i))
                 {
                    return false;
                
                 }
            }
           
        }
        return true;
        
    }
}
//Using BFS
class Solution {
    boolean bfs(Map<Integer,List<Integer>> adj,int indeg[])
    {
       Queue<Integer> pq=new LinkedList<>();
       for(int i=0;i<indeg.length;i++)
       {
        if(indeg[i]==0)
        pq.offer(i);
       }
       int count=0;
       while(!pq.isEmpty())
       {
        int curr=pq.poll();
        count++;
          for(int ngbr:adj.getOrDefault(curr,new ArrayList<>()))
        {
            
                indeg[ngbr]--;
                if(indeg[ngbr]==0)
                {
                    pq.offer(ngbr);
                }
            
        }
       }
      return count==indeg.length;
      
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
          int indeg[]=new int[numCourses];
        for(int pre[]:prerequisites)
        {
            int u=pre[0];
            int v=pre[1];
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
            indeg[u]++;
        }
      
        return bfs(adj,indeg);
      
        
    }
}
