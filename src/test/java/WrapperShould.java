import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"a",1->"";
 */

public class WrapperShould {

    @Test
    void allow_empty_text_and_colum_number_0(){
        assertEquals("", wrapper("",0));
    }
    @Test
    void foo(){
        assertEquals("a\n", wrapper("a",1));
    }

    private String wrapper(String text, int colum) {
        return text;
    }



}
