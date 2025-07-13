class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        PriorityQueue<Integer> pq1=new PriorityQueue<>(Collections.reverseOrder());
          PriorityQueue<Integer> pq2=new PriorityQueue<>(Collections.reverseOrder());
          int count=0;
          for(int x:players)
          {
            pq1.offer(x);
          }
          for(int y:trainers)
          {
            pq2.offer(y);
          }
          while(!pq1.isEmpty()&&!pq2.isEmpty())
          {
            int a = pq1.poll();
int b = pq2.peek();
if (a <= b) {
    pq2.poll();
    count++;
}
          }
          return count;
        
    }
}
