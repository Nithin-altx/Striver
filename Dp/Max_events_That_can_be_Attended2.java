//Tc=2^n*(logn)
//sc=O(n+1)*O(k+1)
class Solution {
    int n;
    int t[][];
    int solve(int i,int[][] events, int k)
    {
        if(i>=n||k==0)
        return 0;

        int start=events[i][0];
        int end=events[i][1];
        int val=events[i][2];
        if(t[i][k]!=-1)
        return t[i][k];

        int skip=solve(i+1,events,k);

        int l=i+1;
        int u=n-1;
        int j=n;
        while(l<=u)
        {
            int mid=(l+u)/2;
            if(events[mid][0]>events[i][1])
            {
                j=mid;
                u=mid-1; 
            }
            else{
                l=mid+1;
            }
           
        }

        int take=val+solve(j,events,k-1);

        return t[i][k]= Math.max(take,skip);
    }
    public int maxValue(int[][] events, int k) {
        n=events.length;
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        t=new int[n+1][k+1];
        for(int i=0;i<n+1;i++)
        {
            Arrays.fill(t[i],-1);
        }
        return solve(0,events,k);
        
    }
}
