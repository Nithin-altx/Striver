class Solution {
    int n;
    int[] GetCordinate(int num)
    {
        int rt=(num-1)/n;
        int Rb=(n-1)-rt;

        int col=(num-1)%n;
        if((Rb%2==1&&n%2==1)||(Rb%2==0&&n%2==0))
        {
            col=(n-1)-col;
        }
        return new int[]{Rb,col};
    }
    public int snakesAndLadders(int[][] board) {
        n=board.length;
        Queue<Integer> pq=new LinkedList<>();
        boolean vis[][]=new boolean[n][n];
        vis[n-1][0]=true;
        pq.offer(1);
        int steps=0;
        while(!pq.isEmpty())
        {
            int N=pq.size();
            while(N-->0)
            {
                int x=pq.poll();
                if(x==n*n)
                return steps;
                for(int k=1;k<=6;k++)
                {
                    int val=(k+x);
                    if(val>n*n)
                    break;
                    int []coord=GetCordinate(val);
                    int row=coord[0];
                    int col=coord[1];
                    if(vis[row][col]==true)continue;

                    vis[row][col]=true;
                    if(board[row][col]==-1)
                    {
                        pq.offer(val);
                    }
                    else{
                        pq.offer(board[row][col]);
                    }
                }
            }
            steps++;
        }
        return -1;
          
    }
}
