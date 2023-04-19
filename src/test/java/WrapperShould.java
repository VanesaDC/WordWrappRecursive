import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"aaaa",4->aaaa
"abc dfg", 3->"abc\ndfg"
"Mas desde", 6->"Mas\ndesde"
"Muchachitos",6-> Muchac--hitos
"Muchachitos de los pueblos altos, no se si por el frío o por supercalifrajilisticospialidoso", 10 ->
"Muchachito\ns de los\npueblos\naltos, no\nse si por\nel frío o\npor\nsupercalif\nrajilistic\nospialidos\no"
 */

public class WrapperShould {

    @Test
    void allow_empty_text_and_colum_number_0() {
        assertEquals("", wrapper("", 0));
    }

    @Test
    void foo() {
        assertEquals("aaaa", wrapper("aaaa", 4));
    }
    @Test
    void cutting_is_a_space() {
        assertEquals("aaa\nbbbb", wrapper("aaa bbbb", 4));
    }

    @Test
    void cut_entry_in_the_previous_spaces_when_cut_points_is_in_a_character() {
        assertEquals("Mas\ndesde", wrapper("Mas desde", 6));
    }
    @Test
    void no_is_previous_space_the_cutting_and_cut_is_in_a_character() {
        assertEquals("Muchac\nhitos", wrapper("Muchachitos", 6));
    }
    @Test
    void no_is_previous_space_the_cutting_and_cut_is_in_a_character2() {
        assertEquals("Muchachito\ns de los\npueblos\naltos, no\nse si por\nel frío o\npor\nsupercalif\nrajilistic\nospialidos\no",
                wrapper("Muchachitos de los pueblos altos, no se si por el frío o por supercalifrajilisticospialidoso", 10));
    }


    private String wrapper(String entry, int colum) {

        final String space = " ";
        final String lineBreak = "\n";
        int cut = colum;

        if (entry.length() > colum){
            String charCut = String.valueOf(entry.charAt(cut));
            int beginIndex = 0;
            if ( !charCut.equals( space )) {
                String provisional = entry.substring(beginIndex, cut );
                if ( provisional.contains( space )) {
                    cut = provisional.lastIndexOf( space );
                }
            }
            String textProcessed = entry.substring(beginIndex, cut ) + lineBreak;
            String restOfText = entry.substring (cut).trim();
            return textProcessed + wrapper(restOfText, colum);
        }
        return entry;
    }
}
