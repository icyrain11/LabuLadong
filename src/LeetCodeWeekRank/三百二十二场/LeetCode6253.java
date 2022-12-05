package LeetCodeWeekRank.三百二十二场;

/**
 * @author icyrain11
 * @version 1.8
 */
public class LeetCode6253 {
    public boolean isCircularSentence(String sentence) {
        String[] s = sentence.split(" ");

        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }
        }
        String lastWord = s[s.length - 1];
        String firstWord = s[0];

        if (lastWord.charAt(lastWord.length() - 1) != firstWord.charAt(0)) {
            return false;
        }

        return true;
    }
}
