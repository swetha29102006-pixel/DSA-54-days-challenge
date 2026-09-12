class Solution {

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    private void func(int idx, String s, List<String> path, List<List<String>> ans) {
        
    }
}
