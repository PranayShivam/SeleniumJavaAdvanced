package BasicJavaQuestions;

public class PrintAtoZUsingIntegers {

    /**
     * Print A to Z using Integer conversion via character
     */
    public static void main(String[] args) {

        StringBuilder b = new StringBuilder();
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            b.append((char) (c+i));
        }

        System.out.println(b);
    }
}
