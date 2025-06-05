//Tc=O(V+E)
//Sc=O(V)
class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> pq=new LinkedList<>();
        int v=adj.size();
        boolean vis[]=new boolean[v];
        pq.offer(0);
        vis[0]=true;
        ArrayList<Integer> res=new ArrayList<>();
        while(!pq.isEmpty())
        {
            int curnode=pq.poll();
            res.add(curnode);
    
            List<Integer> ls=adj.get(curnode);
            for(int x:ls)
            {
                if(vis[x]==true)
                {
                    continue;
                }
                vis[x]=true;
                pq.offer(x);
            }
            
        }
        return res;
        
    }
}
