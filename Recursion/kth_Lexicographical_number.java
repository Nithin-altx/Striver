class Solution {
    //Tc=O(logN*logN)
    //Sc=O(LogN)
    int countnum(long curr,long next,int n)
    {
        int count=0;
        while(curr<=n)
        {
            count+=(next-curr);
            curr*=10;
            next*=10;
            next=Math.min(next,(long)n+1);
        }
        return count;
    }
    public int findKthNumber(int n, int k) {
        k=k-1;
         int curr=1;
        while(k>0)
        {
           int next=curr+1;
            int count=countnum(curr,next,n);
            if(count<=k)
            {
                k-=count;
                curr++;
            }
            else{
                curr*=10;
                k--;
            }
        }
        return curr;

        
    }
}
