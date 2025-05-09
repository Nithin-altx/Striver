class Solution {
    public int secondLargestElement(int[] nums) {
        int n=nums.length;
        int lg=nums[0],sl=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>lg)
            {
                sl=lg;
                lg=nums[i];
            }
            if(nums[i]>sl&&nums[i]!=lg)
            {
                sl=nums[i];

            }
        }
        return sl;
    
    }
}
