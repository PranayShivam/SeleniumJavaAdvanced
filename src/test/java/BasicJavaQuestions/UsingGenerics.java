package BasicJavaQuestions;


import java.util.Arrays;

/**
 * Using Generics develop a method that would print the size of an Array
 * Print the 2nd last element
 * Array can be of Strings Integers float booleans etc...
 */
public class UsingGenerics {

    public static void main(String[] args) {
        Integer[] i = {1, 2, 4, 5, 6, 7, 8, 10};
        String[] s = {"sd", "swdhj", "ihjds", "ijssd", "hsx"};
        System.out.println(returnSecondLastValue(s));
    }


    public static  <T>T returnSecondLastValue(T[] t) {
        System.out.println(t.length);
        Arrays.sort(t);
        System.out.println("Sorted Array: " + Arrays.toString(t));
        return t[t.length-2];
    }
}
