package lab.polymorphism;

public class HorizontallyFlipped implements TextBlock{
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock contents;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    public HorizontallyFlipped(TextBlock contents){
        this.contents = contents;
        
    }//HorizontallyJustified(TextBlock)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public String row(int i) throws Exception{

        char[] line = this.contents.row(i).toCharArray();
        char temp;
        for(int j = 0; j < this.contents.height()/2; j++){
            temp = line[j];
            line[j] = line [this.contents.width() - 1];
            line[this.contents.width() - 1] = temp;
        }//for

        return new String(line);
    }//row(int)

    public int width() {
        return this.contents.width();
     } // width()
 
     public int height() {
         return this.contents.height();
     } // height()
}//class HorizontallyFlipped
