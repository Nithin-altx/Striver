class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
       Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int days=events[0][0];

        int i=0;
        int count=0;

        while(!pq.isEmpty()||i<n)
        {
            if(pq.isEmpty())
            {
                days=events[i][0];
            }
            while(i<n&&events[i][0]==days)
            {
                pq.offer(events[i][1]);
                i++;
            }
            if(!pq.isEmpty())
            {
                pq.poll();
                count++;
            }
            days++;

            while(!pq.isEmpty()&&pq.peek()<days)
            {
                pq.poll();//skipping the days;
            }
        }
        return count;
        
    }
}
