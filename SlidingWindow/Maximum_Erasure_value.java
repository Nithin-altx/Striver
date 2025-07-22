class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int sum = 0, maxsum = 0;
        Set<Integer> st = new HashSet<>();

        while (j < n) {
            if (!st.contains(nums[j])) {
                sum += nums[j];
                st.add(nums[j]);
                j++;
                maxsum = Math.max(sum, maxsum); // update here after addition
            } else {
                // shrink window from left
                sum -= nums[i];
                st.remove(nums[i]);
                i++;
            }
        }

        return maxsum;
    }
}
