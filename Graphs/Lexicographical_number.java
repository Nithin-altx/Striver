//tc=O(N)
//Sc=O(logn)
class Solution {
    void solve(int start,int end, List<Integer> res)
    {
        if(start>end)
        return;
        res.add(start);
        for(int a=0;a<=9;a++)
        {
            int newnum=(start*10)+a;
            solve(newnum,end,res);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<=9;i++)
        {
            solve(i,n,res);
        }
        return res;
        
    }
}
