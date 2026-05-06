import java.util.*;

public class CyclicSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        int n = s.length();
        String doubled = s + s; // handle cyclic

        Set<Character> set = new HashSet<>();

        int left = 0;
        int sum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            // If duplicate found → shrink window
            while (set.contains(ch)) {
                char leftChar = doubled.charAt(left);
                sum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            // Add current character
            set.add(ch);
            sum += (ch - 'a' + 1);

            // Limit window size to original string length
            if (right - left + 1 > n) {
                char leftChar = doubled.charAt(left);
                sum -= (leftChar - 'a' + 1);
                set.remove(leftChar);
                left++;
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println("Maximum Sum = " + maxSum);
        sc.close();
    }
}
