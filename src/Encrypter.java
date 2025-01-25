public class Encrypter {
    private final int[] steps;
    private final int length;
    private final String selection;
    private final String splitter;

    public Encrypter(int length, String uniqueSplitter, String selection, int... steps) {
        this.steps = steps;
        this.selection = selection;
        this.length = length;
        this.splitter = uniqueSplitter;
    }

    public String enCrypt(String word) {
        StringBuilder bonusString = new StringBuilder();
        bonusString.append(splitter);

        int iteration = 0, numCount = 0, stepsIndex = steps.length-1;

        for (int i = 0; i < length; i++) {
            int index = numCount + steps[iteration];

            if (index >= selection.length()) {
                index %= selection.length();
            }

            bonusString.append(selection.charAt(index));
            numCount += steps[iteration];
            iteration++;

            if (iteration > stepsIndex) {
                iteration = 0;
            }
        }
        return wordEncrypter(word) + bonusString;
    }

    private String wordEncrypter(String word) {
        StringBuilder encryptedWord = new StringBuilder();
        int iteration = steps.length-1, numCount = 0, strSize = length/word.length();

        for (int i = 0; i < word.length() * strSize; i++) {
            int index = numCount + steps[iteration];

            if (index >= selection.length()) {
                index %= selection.length();
            }

            encryptedWord.append(selection.charAt(index));
            numCount += steps[iteration];
            iteration--;

            if (iteration < 0) {
                iteration = steps.length - 1;
            }
        }
        return encryptedWord.toString();
    }

}
