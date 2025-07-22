class Solution {
     ArrayList<String> res=new ArrayList<>();
    // Function to find all possible paths'
    int n,m;
    void solve(int i,int j,int[][]maze, boolean vis[][],StringBuilder s)
    {
        if(i==n-1&&j==m-1)
        {
            res.add(s.toString());
            return;
        }
        if(i<0||i>=n||j<0||j>=m||maze[i][j]==0||vis[i][j]==true)
        {
            return;
        }
        vis[i][j]=true;
        s.append("D");
        solve(i+1,j,maze,vis,s);
    s.deleteCharAt(s.length()-1);
        s.append("R");
        solve(i,j+1,maze,vis,s);
    s.deleteCharAt(s.length()-1);
        s.append("L");
        solve(i,j-1,maze,vis,s);
    s.deleteCharAt(s.length()-1);
        s.append("U");
        solve(i-1,j,maze,vis,s);
    s.deleteCharAt(s.length()-1);
    vis[i][j]=false;
        
    }
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
         n=maze.length;
         m=maze[0].length;
        boolean vis[][]=new boolean[n][m];
        StringBuilder s=new StringBuilder();
        if (maze[0][0] == 0) return res;
        solve(0,0,maze,vis,s);
        Collections.sort(res);
        
        return res;
    }
}
