import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by jgyang on 17/03/2017.
 */
public class WordsCountTest {

    @Test
    public void should_return_answer1st_given_eg1st() {
        String input = "xxx";
        WordsCount wc = new WordsCount();
        String result = wc.constructionData(input);

        assertThat(result).isEqualTo("xxx 1");
    }


}
