//Brute Force
//Tc=O(n^3)
//SC=O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
         Set<List<Integer>> res=new HashSet<>();
         Arrays.sort(nums);
         for(int i=0;i<n;i++)
         {
            
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    List<Integer> ls=new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[k]);
                        res.add(new ArrayList<>(ls));
                    }
                }

            }
         } 
         return new ArrayList<>(res);


        
    }
}
//Better
//Tc=O(N^2*log(N)),SC=O(2*log(n)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
 
        Set<List<Integer>> res=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            Set<Integer> st=new HashSet<>();
            for(int j=i+1;j<n;j++)
            {
                int k=-(nums[i]+nums[j]);
                   List<Integer> ls=new ArrayList<>();
                if(st.contains(k))
                {
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(k);
                    Collections.sort(ls);
                    res.add(new ArrayList<>(ls));
                } 
                st.add(nums[j]);
            }
        }
        return new ArrayList<>(res);

        
    }
}
//Optimal
//Tc=O(Nlogn*N^2)
//Sc=O(N)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        List<List<Integer>> res=new ArrayList<>();

Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
            continue;

            int j=i+1;
            int k=n-1;


            while(j<k){
                  int sum=nums[i]+nums[j]+nums[k];
                  List<Integer>ls=new ArrayList<>();
            if(sum==0)
            {
                ls.add(nums[i]);
                ls.add(nums[j]);
                ls.add(nums[k]);
                res.add(new ArrayList<>(ls));
                j++;
                k--;
                while(nums[j]==nums[j-1])
                {
                    j++;
                }
                while(nums[k]==nums[k+1])
                {
                    k--;
                }
            }
            else if(sum<0)
            {
                j++;
            }
            else if(sum>0)
            {
                k--;    
            }
            }     
        }
        
       
        return res;

        
    }
}
