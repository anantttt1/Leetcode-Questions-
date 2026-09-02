import java.util.HashMap;
import java.util.Map;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long currentSum = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        if (frequencyMap.size() == k) {
            maxSum = currentSum;
        }
        for (int i = k; i < nums.length; i++) {
            int incomingElement = nums[i];
            currentSum += incomingElement;
            frequencyMap.put(incomingElement, frequencyMap.getOrDefault(incomingElement, 0) + 1);
            int outgoingElement = nums[i - k];
            currentSum -= outgoingElement;
            if (frequencyMap.get(outgoingElement) == 1) {
                frequencyMap.remove(outgoingElement);
            } else {
                frequencyMap.put(outgoingElement, frequencyMap.get(outgoingElement) - 1);
            }
            if (frequencyMap.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
    
        return maxSum;
    }
}
