import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"abc dfg", 3->"abc\ndfg"
"abc dfg", 2->"abc\ndfg"



 */

public class WrapperShould {

    @Test
    void allow_empty_text_and_colum_number_0() {
        assertEquals("", wrapper("", 0));
    }

    @Test
    void when_newLine_is_in_a_empty_place() {
        assertEquals("abc\ndfg", wrapper("abc dfg", 3));
    }









    private String wrapper(String text, int colum) {

        if (colum==0){
            return text;
        }

        return text;
    }



}
