package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        String lowerCaseInput = input.toLowerCase();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if ( lowerCaseInput.charAt(i) == 'y' || lowerCaseInput.charAt(i) == 'z' )
            {
                if (i < input.length() - 1 && !Character.isLetter( lowerCaseInput.charAt(i + 1) ) ) {
                    count++;
                } else if (i == input.length() - 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        int bLength = base.length();
        int rLength = remove.length();
        char[] charArray = base.toCharArray();
        int j = 0;

        // Loop through the base string one character at at time
        for (int i = 0; i < bLength; i++) {

            // i < bLength - rLength make sure we don't get ArrayOutOfBounds
            // base.substring(i, rLength) == remove test if remove string is present
            if (i < bLength - rLength + 1 && base.substring(i, i + rLength).equals(remove) ) {
                i += rLength - 1;

            // if the string is not present then add the char at i to the charArray
            } else {
                charArray[j] = base.charAt(i);
                j++;
            }
        }

        String str = String.valueOf(charArray);
        String returnStr = str.substring(0, j); // Only keep thru j - stuff after that is from original string

        return returnStr;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){

        int countNot = 0;
        int countIs = 0;

        for (int i = 0; i < input.length(); i++) {

            // check not out of bounds then check if substring = "not"
            if (i < input.length() - 2 && input.substring(i, i + 3).equals("not")) {
                countNot++;
                i += 2;

            // check not out of bounds then check if substring = "is"
            } else if (i < input.length() - 1 && input.substring(i, i + 2).equals("is")) {
                countIs++;
                i += 1;
            }
        }

        return countNot == countIs;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        boolean happy = true;

        for (int i = 0; i < input.length(); i++) {

            if (input.length() == 1 && input.charAt(i) == 'g') {
                happy = false;
                break;
            }
            else if (i < input.length() - 1
                    && input.charAt(i) == 'g'
                    && input.charAt(i + 1) != 'g'
                    && input.charAt(i - 1) != 'g')
            {
                happy = false;
                break;
            } else if (i == input.length() - 1
                    && input.charAt(i) == 'g'
                    && input.charAt(i - 1) != 'g') {
                happy = false;
                break;
            }
        }
        return happy;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){

        int count = 0;

        for (int i = 0; i < input.length(); i++) {

            if (i < input.length() - 2
                    && input.charAt(i + 1) == input.charAt(i)
                    && input.charAt(i + 2) == input.charAt(i)
            ) {
                count += 1;
            }

        }
        return count;
    }
}
