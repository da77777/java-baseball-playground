package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /*
    * contains: 순서, 중복 무시, 값 일치 여부만 확인
    * containsOnly: 순서, 중복을 무시하는 대신 원소값과 갯수가 정확히 일치
    * containsExactly: 중복 불가, 순서를 포함해서 정확히 일치
    * */

    @Test
    void splitTest() {
        String[] input = "1,2".split(",");
        assertThat(input).containsExactly("1","2");
    }
    
    @Test
    void splitOneTest() {
        String[] input = "1,".split(",");
        //assertThat(input).doesNotContain(",");
        assertThat(input).containsExactly("1");
    }

    @Test
    void subStringTest() {
        String input = "(1,2)".substring(1,4);
        assertThat(input).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 처리 테스트")
    void charAtTest() {
        String input = "abc";
        assertThatThrownBy( () -> input.charAt(input.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3"); //입력한 문자열이 익셉션 메시지에 포함되는지 확인
    }

}
