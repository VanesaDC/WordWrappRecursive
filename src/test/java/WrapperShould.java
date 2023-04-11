import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
"", 0->""
"a",1->""
"a",0->"\na"
"a b",1->a\nb
"a b",2->a\nb
"ab",1->\nab

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
    @Test
    void foo3(){
        assertEquals("a\nb", wrapper("a b",2));
    }



    private String wrapper(String text, int colum) {
        if (text.length()==colum){
            return text= text+"\n";
        }

        if (text.length()>colum) {
            if (text.contains(" ")) {
                String divisionPoint= String.valueOf(text.charAt(colum));
                if (divisionPoint.equals(" ")){
                    text = text.replace(text.charAt(colum), '\n');
                }else{
                    int cut= text.lastIndexOf(" ");
                    text = text.replace(text.charAt(cut), '\n');
                }

            }else{
                text="\n"+text;
            }
        }


        return text;
    }



}
