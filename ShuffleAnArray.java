import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/**
 * Solution class.
 * 
 * Runtime: 97 ms, faster than 17.49% of Java online submissions.
 * Memory Usage: 47.9 MB, less than 16.43% of Java online submissions.
 * 
 * Runtime: 89 ms, faster than 19.97% of Java online submissions.
 * Memory Usage: 47.8 MB, less than 25.16% of Java online submissions.
 */
class Solution {

    // **** class members ****
    int[] nums;
    Random rand;
    int len;

    /**
     * constructor
     */
    public Solution(int[] nums) {
        this.nums   = nums;
        this.rand   = new Random();
        this.len    = nums.length;
    }

    /**
     * reset
     */
    public int[] reset() {
        return this.nums;
    }

    /**
     * shuffle
     */
    public int[] shuffle() {

        // // **** array[] to list<Integer> ****
        // List<Integer> lst = Arrays.stream(this.nums).boxed().collect(Collectors.toList());

        // // **** shuffle the list<Integer>  ****
        // Collections.shuffle(lst);

        // // **** return list to int[] ****
        // return lst.stream().mapToInt(Integer::valueOf).toArray();


        // **** initialization ****
        int[] arr = this.nums.clone();

        // **** shuffle the array ****
        for (int i = 0; i < this.len; i++) {
            int j   = rand.nextInt(this.len);
            int tmp = arr[i];
            arr[i]  = arr[j];
            arr[j]  = tmp;
        }

        // **** return shuffled array ****
        return arr;
    }
}


/**
 * 384. Shuffle an Array
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleAnArray {

    /**
     * Test scaffolding.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        
        // **** ****
        int[] nums      = null;
        Solution obj    = null;

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read the number of command ****
        int N = Integer.parseInt(br.readLine().trim());

        // ???? ????
        System.out.println("main <<< N: " + N);

        // **** loop once per command ****
        for (int i = 0; i < N; i++) {

            // **** read command ****
            String cmd = br.readLine().trim();

            // ???? ????
            System.out.println("main <<< cmd ==>" + cmd + "<==");

            // **** read nums[] (if needed) *****
            if (cmd.equals("Solution") == true) {
                nums = Arrays.stream(br.readLine().trim().split(","))
                                    .mapToInt(Integer::parseInt)
                                    .toArray();

                // ???? ????
                System.out.println("main <<< nums: " + Arrays.toString(nums));
            }

            // **** process command ****
            switch (cmd) {
                case "Solution":
                    obj = new Solution(nums);
                break;

                case "shuffle":
                    System.out.println("main <<< shuffle: " + Arrays.toString(obj.shuffle()));
                break;

                case "reset":
                    System.out.println("main <<< reset: " + Arrays.toString(obj.reset()));
                break;

                default:
                    System.out.println("main <<< unexpected cmd ==>" + cmd + "<==");
                break;
            }

        }

        // **** close buffered reader ****
        br.close();
    }
}