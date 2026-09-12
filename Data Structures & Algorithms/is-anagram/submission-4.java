class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqS = new HashMap<>();
        Map<Character, Integer> freqT = new HashMap<>();

        if(s.length() != t.length()) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            freqS.put(sChar, freqS.computeIfAbsent(sChar, k -> 0) + 1);
            freqT.put(tChar, freqT.computeIfAbsent(tChar, k -> 0) + 1);
        }

        for(char key : freqS.keySet()) {
            if (!freqS.get(key).equals(freqT.get(key))) {
                return false;
            }
        }

        return true;
    }
}
