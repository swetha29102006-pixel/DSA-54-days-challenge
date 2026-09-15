class LFUCache {

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        final int freq = keyToFreq.get(key);

        freqToLRUKeys.get(freq).remove(key);

        if (freq == minFreq && freqToLRUKeys.get(freq).isEmpty()) {
            freqToLRUKeys.remove(freq);
            ++minFreq;
        }

        putFreq(key, freq + 1);

        return keyToVal.get(key);
    }

    private int capacity;
    private int minFreq = 0;
    private Map<Integer, Integer> keyToVal = new HashMap<>();
    private Map<Integer, Integer> keyToFreq = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> freqToLRUKeys = new HashMap<>();

    private void putFreq(int key, int freq) {
        keyToFreq.put(key, freq);
        freqToLRUKeys.putIfAbsent(freq, new LinkedHashSet<>());
        freqToLRUKeys.get(freq).add(key);
    }
}
