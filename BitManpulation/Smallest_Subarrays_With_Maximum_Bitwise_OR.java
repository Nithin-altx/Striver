class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int res[]=new int[nums.length];
        int setbit[]=new int[32];
        Arrays.fill(setbit,-1);
        for(int i=nums.length-1;i>=0;i--)
        {
            int endidx=i;
            for(int j=0;j<32;j++)
            {
                
                if((nums[i]&(1<<j))==0)
                {
                    if(setbit[j]!=-1)
                    {
                        endidx=Math.max(endidx,setbit[j]);
                    }    
                }
                else{
                    setbit[j]=i;
                }
            }
            res[i]=endidx-i+1;
        }
        return res;
        
    }
}
