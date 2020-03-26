package Leetcode;

public class Crop_Words {
    public String solutions(String message, int k) {
        //edge case
        if(k >= message.length()){
            return message;
        }
        StringBuilder sb = new StringBuilder(message.substring(0, k));
        if(message.charAt(k) != ' '){
            while(k > 0 && sb.charAt(--k) != ' '){
                sb.deleteCharAt(k);
            }
        }
        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == ' '){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Crop_Words c = new Crop_Words();
        String message = "dasfsdsfgs";
        System.out.println("result :" + c.solutions(message,8));
        String message2 = "das fs dsf g2 s";
        System.out.println("result :" + c.solutions(message2,12));

    }
}
