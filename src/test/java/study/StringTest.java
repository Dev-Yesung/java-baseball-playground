package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    // 요구사항 1
    @Test
    @DisplayName("문자열\"1,2\"를 \"1\"과 \"2\"로 분리하라")
    void splitStringWithPause1() {
        // given
        String beforeSplit = "1,2";

        // when
        String[] afterSplit = beforeSplit.split(",");

        // then
        assertThat(afterSplit).contains("1");
        assertThat(afterSplit).contains("2");
        assertThat(afterSplit).containsExactly("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 \",\"로 split 했을 때, \"1\"만 포함하는 배열을 반환")
    void splitStringWithPause2() {
        // given
        String beforeSplit = "1";

        // when
        String[] afterSplit = beforeSplit.split(",");

        // then
        assertThat(afterSplit.length).isEqualTo(1);
        assertThat(afterSplit).contains("1");
        assertThat(afterSplit).containsExactly("1");
    }

    // 요구사항 2
    @Test
    @DisplayName("\"(1,2)\"값이 주어졌을 때, substring()을 활용해 ()제거")
    void removeParenthesisBySubstring() {
        // given
        String beforeSubstring = "(1,2)";

        // when
        int startIdx = 1;
        int endIdx = beforeSubstring.length() - 1;
        String afterSubstring = beforeSubstring.substring(startIdx, endIdx);

        // then
        assertThat(afterSubstring).isEqualTo("1,2");
    }

    // 요구사항 3
    @Test
    @DisplayName("특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 예외발생")
    void throw_StringIndexOutOfBoundsException_if_access_out_of_bounds() {
        // given
        String test = "abc";

        // when
        int outOfRangeIdx = test.length();

        // then
        // 1번 방법
        assertThatThrownBy(() -> {
            for (int idx = 0; idx <= outOfRangeIdx; idx++) {
                test.charAt(idx);
            }
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + outOfRangeIdx);
        // 2번 방법
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    for (int idx = 0; idx <= outOfRangeIdx; idx++) {
                        test.charAt(idx);
                    }
                })
                .withMessageMatching("String index out of range: \\d+");
    }
}
