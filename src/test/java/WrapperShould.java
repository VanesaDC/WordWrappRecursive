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
        assertEquals("aaaa", wrapper("aaaa", 3));
    }

    @Test
    void when_newLine_is_in_a_empty_place() {
        assertEquals("abc\ndfg\nhijk", wrapper("abc dfg hijk", 3));
    }

    @Test
    void muy_largo() {
        assertEquals("Mas vale\ntarde que\nnunca hipopotamo", wrapper("Mas vale tarde que nunca hipopotamo, que te crees una margarita", 7));
    }


    private String wrapper(String entry, int colum) {

        if (colum==0)
            return entry;

        if (entry.length() == colum + 1)
            return entry;

        int newCut = colum;
        int restOfTextLength = entry.length();
        while (entry.length() - newCut > colum) {
            String firstText= entry.substring( 0, newCut);
            String secondText = entry.substring (newCut).trim();
            String cutting;
            cutting = String.valueOf (entry.charAt (newCut));
            String space = " ";
            String lineBreak = "\n";
            if (cutting.equals(space)) {
                entry = firstText + lineBreak + secondText;
            }else{
                secondText = secondText.replaceFirst(space, lineBreak);
                entry = firstText + secondText;
                int lastLineBreak = entry.lastIndexOf(lineBreak);
                secondText = entry.substring(lastLineBreak + 1);
            }
            restOfTextLength = secondText.length();
            newCut = entry.lastIndexOf(lineBreak) + colum;
        }
        return entry;
    }
}
