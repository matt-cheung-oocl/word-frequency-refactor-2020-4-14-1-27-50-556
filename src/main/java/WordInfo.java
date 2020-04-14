public class WordInfo {
    private String word;
    private int wordCount;

    public WordInfo(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    String getWord() {
        return this.word;
    }

    int getWordCount() {
        return this.wordCount;
    }
}
