import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"aaaa",4->aaaa
"abc dfg", 3->"abc\ndfg"
"Mas desde", 6->"Mas\ndesde"



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

   /* @Test
    void cut_entry_in_the_previous_spaces_when_cut_points_is_in_a_character() {
        assertEquals("Mas\ndesde", wrapper("Mas desde", 6));
    }*/



    private String wrapper(String entry, int colum) {

        if (colum==0)
            return entry;

        if (entry.length() == colum )
            return entry;







        return entry;
    }
}
