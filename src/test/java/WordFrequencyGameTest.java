import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordFrequencyGameTest {

    @Test
    public void should_get_the_1_when_input_the() {
        String inputSentence = "the";
        String expectResult = "the 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    @Test
    public void should_process_two_words() {
        String inputSentence = "the is";
        String expectResult = "the 1\nis 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_spaces() {
        String inputSentence = "the      is";
        String expectResult = "the 1\nis 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    @Test
    public void should_process_two_words_with_special_enter() {
        String inputSentence = "the   \n   is";
        String expectResult = "the 1\nis 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    @Test
    public void should_process_two_same_words_with_sorted() {
        String inputSentence = "the the is";
        String expectResult = "the 2\nis 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    @Test
    public void should_process_sorted_with_count_descending() {
        String inputSentence = "the is is";
        String expectResult = "is 2\nthe 1";
        should_return_true_if_output_result_is_match_with_expected_result(inputSentence, expectResult);
    }

    private void should_return_true_if_output_result_is_match_with_expected_result(String sentence, String expectResult) {
        WordFrequencyGame wordFrequencyGame = new WordFrequencyGame();
        assertEquals(wordFrequencyGame.getResult(sentence), expectResult);
    }
}
