//Tc=O(V+E)=SC
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int n=colors.length();
        int []indegree=new int[n];
        for(int edge[]:edges)
        {
            int u=edge[0];
            int v=edge[1];
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            indegree[v]++;
        }
        Queue<Integer> pq=new LinkedList<>();
        int t[][]=new int[n][26];
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                pq.offer(i);
                t[i][colors.charAt(i)-'a']=1;
            }
        }
        int answer=0;
        int countnodes=0;
        while(!pq.isEmpty())
        {
            int u=pq.poll();
            countnodes++;
            for(int i=0;i<26;i++)
            {
                answer=Math.max(t[u][i],answer);
            }
            List<Integer> ngbr=adj.getOrDefault(u,new ArrayList<>());
            for(int v:ngbr)
            {
                for(int i=0;i<26;i++)
                {
                    int val=t[u][i]+(colors.charAt(v)-'a'==i?1:0);
                    t[v][i]=Math.max(t[v][i],val);
                }
                indegree[v]--;
                if(indegree[v]==0)
                {
                    pq.offer(v);
                }
            }
        }
        return countnodes<n?-1:answer;
        
    }
}
