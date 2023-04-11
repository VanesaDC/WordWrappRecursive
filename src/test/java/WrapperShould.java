import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"",1->"";
 */

public class WrapperShould {

    @Test
    void allow_empty_text_and_colum_number_0(){
        assertEquals("", wrapper("",0));

    }

    private String wrapper(String text, int colum) {
        return text;
    }


}
