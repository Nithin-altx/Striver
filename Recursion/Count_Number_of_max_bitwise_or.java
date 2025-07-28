class Solution {
    int dp[][];
    int solve(int i,int[]nums,int maxor,int or)
    {
        if(i>=nums.length)
        {
            if(or==maxor)
            {
                return 1;
            }
            else{
                return 0;
            }
            
        }
        if(dp[i][or]!=-1)
        {
            return dp[i][or];
        }
       int take= solve(i+1,nums,maxor,or|nums[i]);
        int nottake=solve(i+1,nums,maxor,or);
        return dp[i][or]= take+nottake;

        
    }
    public int countMaxOrSubsets(int[] nums) {
       
       int maxor=0;
       for(int x:nums)
       {
        maxor=maxor|x;
       } 
       dp=new int[nums.length+1][maxor+1];
       for(int i=0;i<nums.length+1;i++)
       {
        Arrays.fill(dp[i],-1);
       }
       return solve(0,nums,maxor,0);

    }
}
