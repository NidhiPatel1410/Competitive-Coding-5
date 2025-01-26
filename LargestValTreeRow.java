// In this problem, we are using queue(fifo) for get rows level wise, and adding left and right value in queue, updating the max row
// wise and adding in the result list.

// Time Complexity : O(n)
// Space Complexity : O(n) - queue size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        // Base case
        if (root == null) {
            return new ArrayList<>();
        }

        // Declare queue
        Queue<TreeNode> q = new LinkedList<>();
        // Add root to the queue
        q.add(root);
        // Result list
        List<Integer> result = new ArrayList<>();
        // Loop till queue is empty
        while (!q.isEmpty()) {
            // Calc size of row list(one level at a time)
            int size = q.size();
            // Declare a max variable
            int max = Integer.MIN_VALUE;
            // Loop till size
            for (int i = 0; i < size; i++) {
                // Poll from queue
                TreeNode curr = q.poll();
                // Update max accordingly
                max = Math.max(max, curr.val);
                // Check if that node has left and right value
                if (curr.left != null) {
                    // Add it to queue
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    // Add it to queue
                    q.add(curr.right);
                }
            }
            // Add max to the result list
            result.add(max);
        }
        // Return result list
        return result;
    }
}