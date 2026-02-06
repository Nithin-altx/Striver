//Approach 1
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> res=new ArrayList<>();
        Set<String> st=new HashSet<>();
        for(String x:folder)
        {
            st.add(x);
        }
        for(int i=0;i<folder.length;i++)
        {
            String a=folder[i];
            int idx=-1;
            boolean b=true;
            for(int j=a.length()-1;j>=0;j--)
            {
                if(a.charAt(j)=='/')
                {
                    idx=j;
                    String s=a.substring(0,idx);
                    if(st.contains(s))
                    {
                        b=false;
                        break;
                    }
                    
                }
            }
            if(b==true)
            {
                res.add(a);
            } 
            

        }
        return res;
    }
}
//Approach 2
//Tc=O(Nlogn*l)
class Solution {
    public List<String> removeSubfolders(String[] folder) {
                List<String> res=new ArrayList<>();
            Arrays.sort(folder); 
            res.add(folder[0]);
                for(int i=1;i<folder.length;i++)
                {
                    String a=folder[i];
                    
                            String l=res.get(res.size()-1);
                            l+='/';
                            if(!a.startsWith(l))
                            {            
                        res.add(a);
                            }
                            
                
                    

                }
                return res;
            }





        }
