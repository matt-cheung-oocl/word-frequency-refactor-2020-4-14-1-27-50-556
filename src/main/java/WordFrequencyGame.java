import java.util.*;

public class WordFrequencyGame {

	private static final String SPACE_FORMAT = "\\s+";
	private static final String NEW_LINE_DELIMITER = "\n";
	private static final String SPACE_DELIMITER = " ";
	private static final String CALCULATE_ERROR = "Calculate Error";

	public String getResult(String sentence) {
		try {
				List<WordInfo> wordInfoList = calculateWordFrequency(sentence);
				StringJoiner joiner = generateWordFrequencyOutput(wordInfoList);
				return joiner.toString();
			} catch (Exception e) {
				return CALCULATE_ERROR;
			}
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
		wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());
		return wordInfoList;
	}
}
