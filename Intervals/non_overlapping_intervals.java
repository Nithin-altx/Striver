class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
            res.add(new int[]{start[i],end[i]});
        }
        res.sort((a,b)->Integer.compare(a[1],b[1]));
        int count=0;
        int lastendtime=-1;
        for(int []r:res)
        {
            if(r[0]>lastendtime)
            {
                count++;
                lastendtime=r[1];
            }
        }
       
        return count;
        
    }
}
