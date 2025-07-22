class Solution {

    boolean isvalid(StringBuilder s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }

    void solve(StringBuilder s, int n, ArrayList<String> res) {
        if (s.length() == 2 * n) {
            if (isvalid(s)) {
                res.add(s.toString());
            }
            return;
        }

        s.append('(');
        solve(s, n, res);
        s.deleteCharAt(s.length() - 1); // backtrack

        s.append(')');
        solve(s, n, res);
        s.deleteCharAt(s.length() - 1); // backtrack
    }

    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        solve(s, n, res);
        return res;
    }
}
