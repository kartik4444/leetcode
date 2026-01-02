class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        StringBuilder dir = new StringBuilder();

        for (char ch : path.toCharArray()) {
            if (ch == '/') {
                processDir(dir, s);
                dir.setLength(0);
            } else {
                dir.append(ch);
            }
        }
        
        processDir(dir, s);

        // build result
        StringBuilder result = new StringBuilder();
        for (String folder : s) {
            result.append("/").append(folder);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    private void processDir(StringBuilder dir, Stack<String> s) {
        if (dir.length() == 0 || dir.toString().equals(".")) return;

        if (dir.toString().equals("..")) {
            if (!s.isEmpty()) s.pop();
        } else {
            s.push(dir.toString());
        }
    }
}
