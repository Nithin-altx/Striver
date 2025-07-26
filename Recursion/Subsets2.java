class Solution {
        List<List<Integer>> res=new ArrayList<>();
    void solve(int idx, List<Integer> ls, Map<Integer,Integer> mp,List<Integer> keys)
    {
        res.add(new ArrayList<>(ls));
        for(int i=idx;i<keys.size();i++)
        {
            int key=keys.get(i);
            int val=mp.get(key);
            if(val==0)
            continue;

            ls.add(key);
            mp.put(key,val-1);
            solve(i,ls,mp,keys);
            ls.remove(ls.size()-1);
            mp.put(key,val);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
     
                List<Integer> ls=new ArrayList<>();
                Map<Integer,Integer> mp=new HashMap<>();
                for(int x:nums)
                {
                    mp.put(x,mp.getOrDefault(x,0)+1);
                }
                   List<Integer> keys=new ArrayList<>(mp.keySet());
                
                solve(0,ls,mp,keys);
                return res;

        
    }
}
\
