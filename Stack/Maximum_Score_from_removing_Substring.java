class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> st = new Stack<>();
        boolean b = false;
        int pairs1 = 0;

        // First pass - remove high-priority pattern
        if (x > y) {
            for (int i = 0; i < s.length(); i++) {
                if (!st.isEmpty() && st.peek() == 'a' && s.charAt(i) == 'b') {
                    st.pop();
                    pairs1++;
                } else {
                    st.push(s.charAt(i));
                }
            }
            b = true;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (!st.isEmpty() && st.peek() == 'b' && s.charAt(i) == 'a') {
                    st.pop();
                    pairs1++;
                } else {
                    st.push(s.charAt(i));
                }
            }
        }

        int points1 = b ? pairs1 * x : pairs1 * y;

        // Build remaining string after first pass
        StringBuilder r = new StringBuilder();
        while (!st.isEmpty()) {
            r.append(st.pop());
        }
        r.reverse();

        int pairs2 = 0;
     if(b==true)
      {
           for(int i=0;i<r.length();i++)
        {
            if(!st.isEmpty()&&st.peek()=='b'&&r.charAt(i)=='a')
            {
                
                    st.pop();
                    pairs2++;
            }
            else{
                st.push(r.charAt(i));
            }
        }

      }
      else{
            for(int i=0;i<r.length();i++)
        {
            if(!st.isEmpty()&&st.peek()=='a'&&r.charAt(i)=='b')
            {
                
                    st.pop();
                     pairs2++;
            }
            else{
                st.push(r.charAt(i));
            }
        }

      }
        int points2 = b ? pairs2 * y : pairs2 * x;

        return points1 + points2;
    }
}
//Approach 2:2pointer
class Solution {
    public int maximumGain(String s, int x, int y) {
        int n = s.length();
        int score = 0;

        String maxStr = (x > y) ? "ab" : "ba";
        String minStr;
        if(maxStr.equals("ab")) { //This is updated after the video was made as a new test case was added in Leetcode
            minStr = "ba";
        }
        else {
            minStr = "ab";
        }

        // First Pass
        String tempFirst = removeSubstring(s, maxStr);
        int L = tempFirst.length();
        int removedPairsCount = (n - L) / 2;
        score += removedPairsCount * Math.max(x, y);

        // Second Pass
        String tempSecond = removeSubstring(tempFirst, minStr);
        removedPairsCount = (L - tempSecond.length()) / 2;
        score += removedPairsCount * Math.min(x, y);

        return score;
    }

    private String removeSubstring(String inputString, String matchStr) {
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            j++;

            if (j > 1 && sb.charAt(j - 2) == matchStr.charAt(0) && sb.charAt(j - 1) == matchStr.charAt(1)) {
                sb.delete(j - 2, j);
                j -= 2;
            }
        }

        return sb.toString();
    }
}
