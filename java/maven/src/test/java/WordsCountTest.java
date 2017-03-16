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

    @Test
    public void should_return_answer3rd_given_eg3rd() {
        String input = "";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("Error");
    }

    @Test
    public void should_return_answer4th_given_eg4th() {
        String input = "the the   the car I was car The Car";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("the 3\ncar 2\nCar 1\nI 1\nThe 1\nwas 1\n");
    }

    @Test
    public void should_return_answer5th_given_eg5th() {
        String input = "xxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("xxxxxxxxxxxxxxxxxxxxxxxxxxxx 1\n");
    }

}
