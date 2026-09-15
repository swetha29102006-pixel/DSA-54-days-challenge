class LFUCache {

    private int capacity;
    private Map<Integer, Integer> keyToVal = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key))
            return -1;

        return keyToVal.get(key);
    }
}
