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
//Approach 2
class Solution {
    //Tc=O(NlogN)
    //Sc=O(N)
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum=0;
        List<Integer> ls=new ArrayList<>();
        for(int x:nums)
        {
            sum+=x;
            int xor=x^k;
            int profit=xor-x;
            ls.add(profit);
        }
        Collections.sort(ls,Collections.reverseOrder());
        for(int i=0;i<ls.size()-1;i+=2)
        {
            if(ls.get(i)+ls.get(i+1)>0)
            {
                sum+=ls.get(i)+ls.get(i+1);
            }
        }
        return sum;
        
        
    }
}
