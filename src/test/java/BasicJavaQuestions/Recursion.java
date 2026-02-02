package BasicJavaQuestions;

public class Recursion {


    /**
     * Perform Recursion
     * Print 1 to 10 using recursion
     */

    private static void num(int i) {
        if(i<11){
            System.out.println(i);
            i++;
            num(i);

        }
    }
    public static void main(String[] args) {
        num(1);
    }
}
