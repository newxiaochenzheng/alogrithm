import java.util.HashMap;

public class SternTest {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s1 = "1";
        System.out.println(s == s1);

        String s2 = new String("1") + new String("1");
        s2.intern();
        String s3 = "11";
        System.out.println(s2 == s3);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < len; i++) {
            Integer value = map.get(target - nums[i]);
            if (value != null) {
                index[0] = i;
                index[1] = value;
                break;
            }
        }
        return index;
    }

}
