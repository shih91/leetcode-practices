class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        HashMap<Integer, Integer> nums1map = new HashMap<>();
        for (int num : nums1) {
            if (nums1map.containsKey(num)) {
                nums1map.put(num, nums1map.get(num) + 1);
            } else {
                nums1map.put(num, 1);
            }
        }
        List<Integer> result = new ArrayList<>();

        for (int num : nums2) {
            if (nums1map.containsKey(num)
                    && nums1map.get(num) > 0) {
                result.add(num);
                int count = nums1map.get(num);
                count--;
                nums1map.put(num, count);
            }
        }

        return listToArray(result);
    }

    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}