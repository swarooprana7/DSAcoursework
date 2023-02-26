package Qnum6;

public class Qnum6b {
    private char[] letters = {'S', 'I', 'X', 'E', 'V', 'N', 'T', 'W', 'Y'};
    private int[] values = {6, 5, 0, 8, 7, 2, 1, 3, 4};


    // Check sum of words equals to sum of result letters
    public boolean showResult(String[] words, String result) {
        return getWordsValue(words) == Integer.parseInt(getEachValue(result));
    }

    // Returns value of the array i.e words
    public int getWordsValue(String[] words) {
        int wordValue = 0;
        // Get each word
        for (String word : words) {
            // Get each word value by calling a function and convert the String into int value for addition
            wordValue += Integer.parseInt(getEachValue(word));
        }
        return wordValue;
    }

    // Returns values of the word
    public String getEachValue(String word) {
        String letterValue = "";
        char letter;
        for (int i = 0; i < word.length(); i++) {
            // Get each letter of the word
            letter = word.charAt(i);
            // Get the value of the word
            letterValue += getValueOf(letter);
        }
        return letterValue;
    }

    // Returns value of each letter
    public int getValueOf(char letter) {
        // Search letter
        for (int i = 0; i < letters.length; i++) {
            // If found
            if (letters[i] == letter) {
                return values[i];
            }
        }
        // Throw error if the value does not find
        throw new IllegalAccessError();
    }

    public static void main(String[] args) {
        Qnum6b answer = new Qnum6b();
        String[] words = {"SIX", "SEVEN", "SEVEN"};
        String result = "TWENTY";
        // Final output
        System.out.println(answer.showResult(words, result));

        // For confirming/testing
        int wordsValue = answer.getWordsValue(words);
        System.out.println("Words value: " + wordsValue);
        String resultValue = answer.getEachValue(result);
        System.out.println("Result value: " + resultValue);
    }
}
