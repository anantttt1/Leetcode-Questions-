class Solution {
    private int matchingNodesCount = 0;
    public int averageOfSubtree(TreeNode root) {
        matchingNodesCount = 0;
        calculateSumAndCount(root);
        return matchingNodesCount;
    }
    private int[] calculateSumAndCount(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] leftData = calculateSumAndCount(node.left);
        int[] rightData = calculateSumAndCount(node.right);
        int currentSum = leftData[0] + rightData[0] + node.val;
        int currentCount = leftData[1] + rightData[1] + 1;
        int average = currentSum / currentCount;
        if (node.val == average) {
            matchingNodesCount++;
        }
        return new int[]{currentSum, currentCount};
    }
}
