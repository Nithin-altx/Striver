class Solution {
    public int largestElement(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max=nums[i];
            }
        }
        return max;
    
    }
}
