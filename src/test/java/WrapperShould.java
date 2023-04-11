import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"a",1->""
"a",0->"\na"
"a b",1->a\nb
 */

public class WrapperShould {

    @Test
    void allow_empty_text_and_colum_number_0(){
        assertEquals("\n", wrapper("",0));
    }
    @Test
    void foo(){
        assertEquals("a\n", wrapper("a",1));
    }
    @Test
    void foo1(){
        assertEquals("\na", wrapper("a",0));
    }
    @Test
    void foo2(){
        assertEquals("a\nb", wrapper("a b",1));
    }

    private String wrapper(String text, int colum) {
        if (text.length()==colum){
            return text= text+"\n";
        }

        if (text.length()>colum){
            return text="\n"+text;
        }
        return text;
    }



}
