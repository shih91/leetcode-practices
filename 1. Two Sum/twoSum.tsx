function twoSum(nums: number[], target: number): number[] {
	let indices = new Map<number, number>();
	for (let i = 0; i < nums.length; i++) {
		if (indices.get(target - nums[i]) != null)
			return [indices.get(target - nums[i])!, i];
		indices.set(nums[i], i);
	}
	return [] as number[];
}
