class Solution {
    public int[] replaceElements(int[] arr) {
        
        int max = -1;
        
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            
            // Replace current element with greatest element on right
            arr[i] = max;
            
            if (temp > max) {
                max = temp;
            }
        }
        
        return arr;
    }
}
