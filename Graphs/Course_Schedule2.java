//Using BFS
class Solution {
    int [] bfs(Map<Integer,List<Integer> > adj,int indeg[])
    {
        int res[]=new int[indeg.length];
        Queue<Integer> pq=new LinkedList<>();
        for(int i=0;i<indeg.length;i++)
        {
            if(indeg[i]==0)
            {
                pq.offer(i);
            }
        }
        int i=0;
        int count=0;
        while(!pq.isEmpty())
        {
            int curr=pq.poll();
            count++;
            res[i]=curr;
            for(int ngbr:adj.getOrDefault(curr,new ArrayList<>()))
            {
                indeg[ngbr]--;
                if(indeg[ngbr]==0)
                {
                    pq.offer(ngbr);
                }
            }
            i++;
        }
        if(count==indeg.length)
        return res;
        else{
            return new int[]{};
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer> > adj=new HashMap<>();
        int indeg[]=new int[numCourses];
        for(int pre[]:prerequisites)
        {
            int u=pre[0];
            int v=pre[1];
            indeg[u]++;
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        return bfs(adj,indeg);
        
    }
}
//Using DFS
class Solution {
    boolean dfs(Map<Integer,List<Integer> > adj,Stack<Integer> st,boolean vis[],boolean []inrec,int u)
    {
        vis[u]=true;
        inrec[u]=true;
        for(int ngbr:adj.getOrDefault(u,new ArrayList<>()))
        {
            if(!vis[ngbr])
            {
                if(dfs(adj,st,vis,inrec,ngbr))
                {
                    return true;
                }
            }
            else if(inrec[ngbr]==true)
            {
                return true;
            }
        }
        st.add(u);
        inrec[u]=false;
        return false;
       
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer> > adj=new HashMap<>();
        boolean inrec[]=new boolean[numCourses];
         boolean vis[]=new boolean[numCourses];
         Stack<Integer> st=new Stack<>();
        for(int pre[]:prerequisites)
        {
            int u=pre[0];
            int v=pre[1];
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        for(int i=0;i<numCourses;i++)
        {
            if(!vis[i]&&dfs(adj,st,vis,inrec,i))
            {
                return new int[]{};
            }
        }
        int res[]=new int[numCourses];
        int i=0;
        while(!st.isEmpty())
        {
            res[i]=st.pop();
            i++;
        }
        return res;
        
        
    }
}
