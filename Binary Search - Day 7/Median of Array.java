public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
        int m = A.size();
        int n = B.size();

        // Ensure A is the smaller array to optimize partitioning
        if (m > n) {
            return findMedianSortedArrays(B, A); // Swap the arrays and call the function again
        }

        int low = 0, high = m;
        while (low <= high) {
            int partitionX = (low + high) / 2; // Determine the partition point for array A
            int partitionY = (m + n + 1) / 2 - partitionX; // Determine the corresponding partition point for array B

            // Find the maximum elements on the left side of the partitions
            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : A.get(partitionX - 1);
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : B.get(partitionY - 1);

            // Find the minimum elements on the right side of the partitions
            int minX = (partitionX == m) ? Integer.MAX_VALUE : A.get(partitionX);
            int minY = (partitionY == n) ? Integer.MAX_VALUE : B.get(partitionY);

            // Check if the current partitioning is valid for finding the median
            if (maxX <= minY && maxY <= minX) {
                if ((m + n) % 2 == 0) {
                    // Even total elements: average of the two middle elements
                    return (double) (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2;
                } else {
                    // Odd total elements: the maximum of the elements on the left side
                    return (double) Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move the partition point in array A to the left
                high = partitionX - 1;
            } else {
                // Move the partition point in array A to the right
                low = partitionX + 1;
            }
        }
        
        // If no valid partition was found, return an error value (-1)
        return (double) -1;
    }
}
