class Solution {
    char dfs(Map<Character,List<Character>> adj,char s,boolean[]vis)
    {
        char min=s;
        vis[min-'a']=true;
        List<Character> ls=adj.getOrDefault(min,new ArrayList<>());
        for(char c:ls)
        {
            if(vis[c-'a']==false)
            {
                char want=dfs(adj,c,vis);
                if(want<min)
                {
                    min=want;
                }
       
            }  
        }
        return min;
        
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character,List<Character>> adj=new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            char u=s1.charAt(i);
            char v=s2.charAt(i);
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }
        String res="";
        for(int i=0;i<baseStr.length();i++)
        {
            boolean[]vis=new boolean[26];
            char r=dfs(adj,baseStr.charAt(i),vis);
            res+=r;
        }
        return res;
    }
}
