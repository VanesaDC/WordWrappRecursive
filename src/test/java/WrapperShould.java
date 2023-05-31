import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"aaaa", -5->throw error
"", 8->""
"aaaa",4->aaaa
"abc dfg", 3->"abc\ndfg"
"Mas desde", 6->"Mas\ndesde"
"Muchachitos",6-> Muchac--hitos
"Muchachitos de los pueblos altos, no se si por el frío o por supercalifrajilisticospialidoso", 10 ->
"Muchachito\ns de los\npueblos\naltos, no\nse si por\nel frío o\npor\nsupercalif\nrajilistic\nospialidos\no"
 */

public class WrapperShould {
    Wrapper wrapper = new Wrapper();

    @Test
    void allow_empty_text() {
        assertEquals("", wrapper.wrap("", 8));
    }

    @Test
    void not_wrap_text_that_fits_with_columns() {
        assertEquals("aaaa", wrapper.wrap("aaaa", 4));
    }
    @Test
    void wrap_text_without_spaces_that_does_not_fit_in_columns() {
        assertEquals("aa\naa", wrapper.wrap("aaaa", 2));
    }
    @Test
    void wrap_when_cutpoint_is_a_space() {
        assertEquals("aaa\nbbbb", wrapper.wrap("aaa bbbb", 4));
    }

    @Test
    void wrap_text_in_the_previous_spaces_when_cutpoint_is_a_character() {
        assertEquals("Mas\ndesde", wrapper.wrap("Mas desde", 6));
    }
    @Test
    void wrap_text_when_not_are_previous_space() {
        assertEquals("Muchac\nhitos", wrapper.wrap("Muchachitos", 6));
    }
    @Test
    void wrap_text_when_not_are_previous_space2() {
        assertEquals("Muchachito\ns de los\npueblos\naltos, no\nse si por\nel frío o\npor\nsupercalif\nrajilistic\nospialidos\no",
                wrapper.wrap("Muchachitos de los pueblos altos, no se si por el frío o por supercalifrajilisticospialidoso", 10));
    }



}
