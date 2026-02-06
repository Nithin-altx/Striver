class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        int n=arr.length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int start=arr[i][0];
            int end=arr[i][1];
             if(res.size()==0||start>res.get(res.size()-1)[1])
                {
                    res.add(new int[]{start,end});
                }
                else{
                    res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],end);
                }   
        }
        return res;
    }
}
