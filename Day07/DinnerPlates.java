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

        int idx = set.first();
        Stack<Integer> st = lt.get(idx);
        st.push(val);

        if (st.size() == capacity) {
            set.remove(idx);
        }
    }

    public int pop() {
        while (!lt.isEmpty() && lt.get(lt.size() - 1).isEmpty()) {
            lt.remove(lt.size() - 1);
        }

        if (lt.isEmpty()) return -1;

        int idx = lt.size() - 1;
        Stack<Integer> st = lt.get(idx);

        int val = st.pop();

        set.add(idx);

        return val;
    }
}
