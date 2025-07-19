class Solution {
    Set<String> res=new HashSet<>();
    void solve(StringBuilder s,int[] digits,boolean[]visited)
    {
        if(s.length()==3)
        {
            if(!res.contains(s.toString())&&(s.charAt(s.length()-1)-'0')%2==0)
            {
                res.add(s.toString());
            }
            return;
        }
        for(int i=0;i<digits.length;i++)
        {
            if (!visited[i] && (s.length() > 0 || digits[i] != 0))
            {
                visited[i]=true;
                s.append(String.valueOf(digits[i]));
                solve(s,digits,visited);
                visited[i]=false;
                s.deleteCharAt(s.length()-1);
            }
        }
    }
    public int totalNumbers(int[] digits) {
        StringBuilder s=new StringBuilder();
       boolean visited[]=new boolean[digits.length];
        solve(s,digits,visited);
        return res.size();
        
    }
}
