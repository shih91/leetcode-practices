class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indices = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (indices.get(target - nums[i]) != null)
                return new int[] { indices.get(target - nums[i]), i };
            indices.put(nums[i], i);
        }
        return null;
    }
}