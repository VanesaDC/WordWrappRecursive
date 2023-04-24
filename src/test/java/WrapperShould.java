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

    @Test
    void allow_empty_text() {
        assertEquals("", wrap("", 8));
    }

    @Test
    void not_wrap_text_that_fits_with_columns() {
        assertEquals("aaaa", wrap("aaaa", 4));
    }
    @Test
    void wrap_text_without_spaces_that_does_not_fit_in_columns() {
        assertEquals("aa\naa", wrap("aaaa", 2));
    }
    @Test
    void wrap_when_cutpoint_is_a_space() {
        assertEquals("aaa\nbbbb", wrap("aaa bbbb", 4));
    }

    @Test
    void wrap_text_in_the_previous_spaces_when_cutpoint_is_a_character() {
        assertEquals("Mas\ndesde", wrap("Mas desde", 6));
    }
    @Test
    void wrap_text_when_not_are_previous_space() {
        assertEquals("Muchac\nhitos", wrap("Muchachitos", 6));
    }
    @Test
    void wrap_text_when_not_are_previous_space2() {
        assertEquals("Muchachito\ns de los\npueblos\naltos, no\nse si por\nel frío o\npor\nsupercalif\nrajilistic\nospialidos\no",
                wrap("Muchachitos de los pueblos altos, no se si por el frío o por supercalifrajilisticospialidoso", 10));
    }


    private String wrap(String text, int column) {

        final String space = " ";
        final String lineBreak = "\n";
        int cutIndex = column;

        boolean textLengthIsGreaterThanColumn = text.length() > column;
        if (textLengthIsGreaterThanColumn){
            String cutPoint = String.valueOf(text.charAt(cutIndex));
            int beginIndex = 0;
            boolean cutPointIsALetter = !cutPoint.equals(space);
            if (cutPointIsALetter) {
                String textToWrap = text.substring(beginIndex, cutIndex );
                if ( textToWrap.contains( space )) {
                    cutIndex = textToWrap.lastIndexOf( space );
                }
            }
            String textProcessed = text.substring(beginIndex, cutIndex ) + lineBreak;
            String restOfText = text.substring (cutIndex).trim();
            return textProcessed + wrap(restOfText, column);
        }
        return text;
    }
}
