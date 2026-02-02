package BasicJavaQuestions;

import java.util.Stack;

public class Coforge_1 {
    
    public static void main(String[] args) {

        int i1 = 234;
        int i2 = 453;

        char[] s1 = String.valueOf(i1).toCharArray();
        char[] s2 = String.valueOf(i2).toCharArray();
        StringBuilder b = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s1) {
            if (!stack.contains(c)) {
                stack.push(c);
            } else {
                b.append(c).append(",");
            }
        }

        for (char c : s2) {
            if (!stack.contains(c)) {
                stack.push(c);
            } else {
                b.append(c).append(",");
            }
        }

        System.out.println(b);
    }
}
