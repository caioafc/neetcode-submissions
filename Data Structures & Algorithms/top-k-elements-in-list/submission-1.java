class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        int[] result = new int[k];

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }

            bucket[entry.getValue()].add(entry.getKey());
        }

        int resultIndex = 0;
        for (int frequency = bucket.length - 1; frequency >= 0 && resultIndex < k; frequency--) {
            if (bucket[frequency] == null) {
                continue;
            }

            for(int num : bucket[frequency]) {
                result[resultIndex++] = num;

                if(resultIndex == k) {
                    break;
                }
            }
        }

        return result;
    }
}
