class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();

        // First row will be hardcoded
        results.add(Arrays.asList(1));

        if (numRows == 1)
            return results;

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            row.add(1);
            for (int col = 1; col < i; col++) {
                row.add(results.get(i - 1).get(col - 1) + results.get(i - 1).get(col));
            }

            row.add(1);
            results.add(row);
        }
        return results;
    }
}