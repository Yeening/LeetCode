class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] elements = path.split("/");
        for (String element: elements) {
            if (element.isEmpty() 
                    || element.equals(".")) {
                        continue;
            } else if (element.equals("..")) {
                if (stack.isEmpty()) continue;
                stack.removeLast();
            } else {
                stack.addLast(element);
            }
        }

        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String dir: stack) {
            sb.append('/');
            sb.append(dir);
        }

        return sb.toString();
    }
}
