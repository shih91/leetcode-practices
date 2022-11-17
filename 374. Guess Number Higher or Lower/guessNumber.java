/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is higher than the picked number
 *         1 if num is lower than the picked number
 *         otherwise return 0
 *         int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        int myGuess = ((max - min) / 2) + min;
        int outcome = guess(myGuess);
        while (min <= max) {
            if (outcome > 0) {
                min = myGuess + 1;
            } else {
                max = myGuess - 1;
            }
            myGuess = ((max - min) / 2) + min;
            outcome = guess(myGuess);
        }
        return myGuess;
    }
}