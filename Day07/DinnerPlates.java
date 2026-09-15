class DinnerPlates {

    List<Stack<Integer>> lt;
    TreeSet<Integer> set;
    int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        lt = new ArrayList<>();
        set = new TreeSet<>();
    }

    public void push(int val) {
        while (!set.isEmpty() && set.first() >= lt.size()) {
            set.pollFirst();
        }

        if (set.isEmpty()) {
            lt.add(new Stack<>());
            set.add(lt.size() - 1);
        }
    }
}
