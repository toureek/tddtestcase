import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by jgyang on 17/03/2017.
 */
public class WordsCountTest {

    @Test
    public void should_return_answer1st_given_eg1st() {
        String input = "When the I was small and the car I was When";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("I 2\nWhen 2\nthe 2\nwas 2\nand 1\ncar 1\nsmall 1\n");
    }

    @Test
    public void should_return_answer2nd_given_eg2nd() {
        String input = "When          the I   was    small     and     the car I              was       ";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("I 2\nthe 2\nwas 2\nWhen 1\nand 1\ncar 1\nsmall 1\n");
    }



}
