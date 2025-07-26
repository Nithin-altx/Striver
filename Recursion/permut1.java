class Solution {
    Set<Integer> st=new HashSet<>();
    void solve(int nums[],List<Integer> ls, List<List<Integer>> res)
    {
        if(ls.size()==nums.length)
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(st.contains(nums[i]))
            {
                continue;
            }
            ls.add(nums[i]);
            st.add(nums[i]);
            solve(nums,ls,res);
            st.remove(nums[i]);
            ls.remove(ls.size()-1);


        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        solve(nums,ls,res);
        return res;

        
    }
}
//Approach 2
class Solution {
    void solve(int idx,List<Integer> ls, List<List<Integer>> res)
    {
        if(ls.size()==idx)
        {
            res.add(new ArrayList<>(ls));
            return;
        }
        for(int i=idx;i<ls.size();i++)
        {
            int temp=ls.get(i);
            ls.set(i,ls.get(idx));
            ls.set(idx,temp);
            solve(idx+1,ls,res);
             temp=ls.get(i);
            ls.set(i,ls.get(idx));
            ls.set(idx,temp);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        for(int x:nums)
        {
            ls.add(x);
        }
        solve(0,ls,res);
        return res;

        
    }
}
