from ast import List
from collections import defaultdict

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        d = defaultdict(int)
        for i in nums:
            d[i] += 1
            if d[i] > 1:
                return True
        return False