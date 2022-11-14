class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet disjointSet = new DisjointSet((maxRow + 1) + (maxCol + 1));
        HashSet<Integer> stoneNodes = new HashSet();
        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            disjointSet.union(nodeRow, nodeCol);
            stoneNodes.add(nodeRow);
            stoneNodes.add(nodeCol);
        }

        int count = 0;
        for (int node : stoneNodes) {
            if (node == disjointSet.find(node))
                count++;
        }

        return stones.length - count;
    }
}

class DisjointSet {
    // sources: https://www.youtube.com/watch?v=ayW5B2W9hfo&ab_channel=PotatoCoders
    // sources: https://www.youtube.com/watch?v=OwMNX8SPavM&ab_channel=takeUforward
    int[] parent;

    public DisjointSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}