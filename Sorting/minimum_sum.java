import java.util.*;

class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Distribute digits alternately
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) num1.append(arr[i]);
            else num2.append(arr[i]);
        }

        // Simulate addition of num1 + num2 (both are strings of digits)
        return addStrings(num1.toString(), num2.toString());
    }

    // Helper to add two large numbers represented as strings
    String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            res.append(sum % 10);
            carry = sum / 10;
        }

       // Remove leading zeros
String result = res.reverse().toString().replaceFirst("^0+(?!$)", "");
return result;

    }
}
