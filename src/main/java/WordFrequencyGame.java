import java.util.*;

public class WordFrequencyGame {

	private static final String SPACE_FORMAT = "\\s+";
	private static final String NEW_LINE_DELIMITER = "\n";
	private static final String SPACE_DELIMITER = " ";
	private static final String CALCULATE_ERROR = "Calculate Error";

	public String getResult(String sentence) {


		if (sentence.split(SPACE_FORMAT).length == 1) {
			return sentence + " 1";
		} else {

			try {

				//split the input string with 1 to n pieces of spaces
				String[] words = sentence.split(SPACE_FORMAT);

				List<WordInfo> wordInfoList = new ArrayList<>();
				for (String word : words) {
					WordInfo wordInfo = new WordInfo(word, 1);
					wordInfoList.add(wordInfo);
				}

				//get the map for the next step of siz
				// ing the same word
				Map<String, List<WordInfo>> map = getMap(wordInfoList);

				List<WordInfo> list = new ArrayList<>();
				for (Map.Entry<String, List<WordInfo>> entry : map.entrySet()) {
					WordInfo wordInfo = new WordInfo(entry.getKey(), entry.getValue().size());
					list.add(wordInfo);
				}
				wordInfoList = list;

				wordInfoList.sort((firstWord, secondWord) -> secondWord.getWordCount() - firstWord.getWordCount());

				StringJoiner joiner = new StringJoiner(NEW_LINE_DELIMITER);
				for (WordInfo wordInfo : wordInfoList) {
					String wordWithCountOutput = wordInfo.getWord() + SPACE_DELIMITER + wordInfo.getWordCount();
					joiner.add(wordWithCountOutput);
				}
				return joiner.toString();
			} catch (Exception e) {
				return CALCULATE_ERROR;
			}
		}
	}

	private Map<String, List<WordInfo>> getMap(List<WordInfo> wordInfoList) {
		Map<String, List<WordInfo>> map = new HashMap<>();
		for (WordInfo wordInfo : wordInfoList) {
			if (!map.containsKey(wordInfo.getWord())) {
				ArrayList arr = new ArrayList<>();
				arr.add(wordInfo);
				map.put(wordInfo.getWord(), arr);
			} else {
				map.get(wordInfo.getWord()).add(wordInfo);
			}
		}
		return map;
	}
}
