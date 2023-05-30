import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        String regExStr = "^(([0-1]?\\d?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.){3}([0-1]?\\d?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)$";

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Solution sol = new Solution();

        System.out.println("Input matched with regEx:"+
                sol.regExMatcher(regExStr,input));



    }

    public boolean regExMatcher(String regExStr,String input){
        return Pattern.matches(regExStr, input);
    }
}
