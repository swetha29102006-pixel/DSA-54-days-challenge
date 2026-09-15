class DinnerPlates {

    List<Stack<Integer>> lt;
    TreeSet<Integer> set;
    int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        lt = new ArrayList<>();
        set = new TreeSet<>();
    }
}
