class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.matches("[*/+-]")) {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+":
                        token = a + b + "";
                        break;
                    case "-":
                        token = a - b + "";
                        break;
                    case "/":
                        token = a / b + "";
                        break;
                    case "*":
                        token = a * b + "";
                        break;
                }
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}