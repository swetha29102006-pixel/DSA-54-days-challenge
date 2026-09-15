class Solution {
    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        return new int[0];
    }
}
