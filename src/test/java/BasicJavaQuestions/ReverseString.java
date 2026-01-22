package BasicJavaQuestions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {

        /*HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1,2);
        map.put(3,4);
        map.put(5,6);

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for (Map.Entry<Integer, Integer>  set_  : set) {
            System.out.println(set_.getKey());
        }*/


        String str = "abcdeazcy";

        Stack<Character> stack = new Stack<>();
        StringBuilder b = new StringBuilder();

        for (char c: str.toCharArray()) {
            if (!stack.contains(c)) {
                stack.push(c);
            } else {
                b.append(c);
            }
        }

        System.out.println("Duplicate Elements: " +  b);


    }

/*
    @Test
    @Parameters("browser")
    public  void test(String browser) {
        switch (browser) {
            case :
        }
        WebDriver driver = new ChromeDriver();
    }*/
}
