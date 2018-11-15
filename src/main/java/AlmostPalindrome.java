/**
 * Return true if a string is "Almost palindrome"
 *
 * i.e. if you can remove at most one character from the string to make it a palindrome
 *
 * e.g.
 * abcba -> true, because this is already a palindrome
 * abcb -> true, because this is a palindrome if we remove the first letter 'a'
 * abcdef -> false, because this is not a palindrome if we remove any char from the string
 */
public class AlmostPalindrome {

    // inefficient solution O(n^2)
    private static boolean isAlmostPalindrome1(String str){
        if(isPalindrome(str)){
            return true;
        }
        for(int i=0;i<str.length();i++){
            if(isPalindrome(str.substring(0,i)+str.substring(i+1))){
                return true;
            }
        }
        return false;
    }


    private static boolean isPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    // efficient solution O(n)
    private static boolean isAlmostPalindrome2(String str){
        return isAlmostPalindrome(str, 0, 0, str.length()-1);
    }

    private static boolean isAlmostPalindrome(String str, int numRemoved, int start, int end){
        System.out.println("str: "+str+ " ;numRem: "+numRemoved+ " ;start: "+start+" ;end: "+end);
        if(numRemoved > 1){
            return false;
        }
        if(start >= end) {
            return true;
        }
        if(str.charAt(start) == str.charAt(end)){
            return isAlmostPalindrome(str, numRemoved, start+1, end-1);
        }
        return isAlmostPalindrome(str, numRemoved+1, start+1, end)
                || isAlmostPalindrome(str, numRemoved+1, start, end-1);
    }
    
    public static void main(String args[]){
        String str = "fedcbabcbcbababcdef";
        System.out.println("isAlmostPalindrome("+str+") : "+isAlmostPalindrome2(str));
    }
}
