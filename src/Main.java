import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("**************************************");

        System.out.println(checkForPalindromeFIFO("abccba"));
        System.out.println(checkForPalindromeFIFO("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindromeFIFO("I did, did I?"));
        System.out.println(checkForPalindromeFIFO("hello"));
        System.out.println(checkForPalindromeFIFO("Don't node"));
        System.out.println(checkForPalindromeFIFO("RACECAR"));

        System.out.println("**************************************************");
        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));

    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctionString = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);
        //hello
        //h, e, l, l, o
        //o, l, l, e, h
        //racecar
        //racecar
        //racecar
        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                noPunctionString.append(c);
                //noPunctionString.insert()
                stack.push(c);
            }
        }

        //System.out.println(stack);

        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        return noPunctionString.toString().equals(reversed.toString());
    }

    public static boolean checkForPalindromeFIFO(String text) {
        //dad
        //d, a, d
        //d, a, d
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        //RACECAR
        //racecar

        for(int i = 0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }


        if(stack.equals(queue)){
            System.out.println("EQUAL");
        } else{
            System.out.println("NOT EQUAL");
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

        return true;

    }

    public static String convertDecimalToBinary(int num){
        //5
        //5 % 2 = 1    2 % 2 = 0    1 % 2 = 1
        //5 / 2 = 2    2 / 2 = 1    1 / 2 = 0

        //13
        //13 % 2 = 1   6 % 2 = 0   3 % 2 = 1  1 % 2 = 1
        //13 / 2 = 6   6 / 2 = 3   3 / 2 = 1  1 / 2 = 0

        final int base = 2;
        Stack digits = new Stack();

        while(num > 0){
            //[1, 1, 0, 1]
            digits.push(num % base);
            num = num / base;
        }

        String bits = "";
        while (!digits.isEmpty()){
            bits += digits.pop();
        }
        digits.toString();
        return bits;
    }
}