public class Wrapper {

    public Wrapper() {
    }

    public String wrap(String text, int column) {
        if(column < 0){
            throw new IllegalArgumentException("Column must be greater than zero");
        }

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
