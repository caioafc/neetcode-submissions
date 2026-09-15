class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] result = new int[k];

        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }

            bucket[entry.getValue()].add(entry.getKey());
        }

        int resultIndex = 0;
        for(int freq = bucket.length - 1; freq > 0 && resultIndex < k; freq--) {
            if(bucket[freq] == null) {
                continue;
            }
            
            for(int num : bucket[freq]) {
                result[resultIndex++] = num;

                if(resultIndex == k) {
                    break;
                }
            }
        }

        return result;
    }
}
