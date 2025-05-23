//Tc=O(N)
//sc=O(1)
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        int count=0;
        long loss=Integer.MAX_VALUE;
        for(int x:nums)
        {
            int xor=x^k;
            if(xor>x)
            {
                sum+=xor;
                count++;
            }
            else{
                sum+=x;
            } 
            loss=Math.min(Math.abs(x-xor),loss); 
        }
        if(count%2==0)
        return sum;
        else
        return sum-loss;
        
    }
}
