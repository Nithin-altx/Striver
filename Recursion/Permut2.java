class Solution {
    List<List<Integer>> res=new ArrayList<>();
    void solve(int idx,List<Integer> ls)
    {
        if(idx==ls.size())
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        Set<Integer> st=new HashSet<>();
        for(int i=idx;i<ls.size();i++)
        {
            if(st.contains(ls.get(i)))
            continue;

            st.add(ls.get(i));

            int temp=ls.get(i);
            ls.set(i,ls.get(idx));
           ls.set(idx,temp);
            solve(idx+1,ls);

            temp=ls.get(i);
            ls.set(i,ls.get(idx));
           ls.set(idx,temp);
           
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ls=new ArrayList<>();
        for(int x:nums)
        {
            ls.add(x);
        }
        solve(0,ls);
        return res;

        
    }
}
