// This program tests to see whether a String begins with
// a capital letter, and also ends with a capital letter

public class CapitalAlphaZeta {

    public static void main(String[] args) {
        System.out.println(isCapital("Doctor"));
        System.out.println(isCapital("SuesS"));
    }

    public static boolean isCapital(String str) {
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);
        
        String strCapital = str.toUpperCase();
        char firstCharCapital = strCapital.charAt(0);
        char lastCharCapital = strCapital.charAt(strCapital.length() - 1);
        
        if (firstChar == firstCharCapital && lastChar == lastCharCapital) {
            return true;
        } else {
            return false;
        }
    }
}
