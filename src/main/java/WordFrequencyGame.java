import java.util.*;

public class WordFrequencyGame {

	private static final String SPACE_FORMAT = "\\s+";
	private static final String NEW_LINE_DELIMITER = "\n";
	private static final String SPACE_DELIMITER = " ";

	public String getResult(String sentence) {
			List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
			StringJoiner joiner = generateWordFrequencyOutput(wordInfoList);
			return joiner.toString();
	}

	private StringJoiner generateWordFrequencyOutput(List<WordInfo> wordInfoList) {
		StringJoiner joiner = new StringJoiner(NEW_LINE_DELIMITER);
		for (WordInfo wordInfo : wordInfoList) {
			String wordWithCountOutput = wordInfo.getWord() + SPACE_DELIMITER + wordInfo.getWordCount();
			joiner.add(wordWithCountOutput);
		}
		return joiner;
	}

	private List<WordInfo> calculateWordFrequency(String sentence) {
		List<String> words = Arrays.asList(sentence.split(SPACE_FORMAT));
		List<WordInfo> wordInfoList = new ArrayList<>();
		for (String word : new HashSet<>(words)) {
			int wordCount = Collections.frequency(words, word);
			wordInfoList.add(new WordInfo(word, wordCount));
		}
		sortWordByFrequency(wordInfoList);
		return wordInfoList;
	}

	private void sortWordByFrequency(List<WordInfo> wordInfoList) {
		wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
	}
}