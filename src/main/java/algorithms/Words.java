package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Words {
    private List<String> words = new ArrayList<>();

    public void addWord(String word) {

        if (isLegalWord(word)) {
            words.add(word);
        }
    }

    private boolean isLegalWord(String word) {
        if (!word.toLowerCase(Locale.ROOT).equals(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        if (word.split(" ").length > 1) {
            throw new IllegalArgumentException("It should be one word!");
        }
        return true;
    }

    public boolean isThereAWordTwice() {
        for (String theVictim : words
        ) {
            int counterForTwoWords = 0;
            for (String theSuspect : words
            ) {
                if (theVictim.equals(theSuspect)) {
                    counterForTwoWords++;
                    if (counterForTwoWords > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
