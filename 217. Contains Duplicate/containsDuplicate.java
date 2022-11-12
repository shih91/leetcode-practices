import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (numbers.get(num) == null)
                numbers.put(num, 1);
            else
                return true;
        }
        return false;
    }
}