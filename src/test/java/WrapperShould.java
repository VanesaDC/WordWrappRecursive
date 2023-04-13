import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"aaaa",3->aaaa
"abc dfg", 3->"abc\ndfg"
"abc dfg", 2->"abc\ndfg"



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



    private String wrapper(String entry, int colum) {

        if (colum==0)
            return entry;

        if (entry.length() == colum )
            return entry;

        final String space = " ";
        final String lineBreak = "\n";





        return entry;
    }
}
