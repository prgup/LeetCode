class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop(), a = stack.pop();
                    stack.push(a / b); // truncates toward zero, as required
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
