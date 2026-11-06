import java.util.*;

class Largest_Subarray_with_0_Sum {
    int maxLength(int arr[]) { 
        int n = arr.length;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefix = 0;
        int prev = 0;

        for(int i=0; i<n; i++){ 
            if(i != 0){
                prev = prefix;
            }

            prefix = prev + arr[i];

            if(prefix == 0){ 
                int len = i+1;
                ans = Math.max(ans, len);
            }

            if(map.containsKey(prefix)){
                int len = i - map.get(prefix);
                ans = Math.max(ans, len);
            }
            else{
                map.put(prefix, i);
            }
        }

        return ans;

    }
}