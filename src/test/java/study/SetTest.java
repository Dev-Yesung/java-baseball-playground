package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // 요구사항 1
    @Test
    @DisplayName("Set의 size()메소드를 활용해 Set의 크기를 확인")
    void useSizeMethodBySetCollection() {
        // when
        int numbersSize = numbers.size();

        // then
        assertThat(numbersSize).isEqualTo(3);
    }

    // 요구사항 2
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("ParameterizedTest를 이용해 Set의 값을 검증")
    void useParameterizedTestToValidSet(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    // 요구사항 3
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("입력 값에 따라 결과 값이 다른 경우에 대한 테스트")
    void getAnotherResultIfInputValueDifferent(String input, String expected) {
        // given
        int number = Integer.parseInt(input);
        boolean isContained = Boolean.parseBoolean(expected);

        // when
        boolean actualValue = numbers.contains(number);

        // then
        assertThat(actualValue).isEqualTo(isContained);
    }

}
