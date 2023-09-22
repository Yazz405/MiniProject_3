package lab.polymorphism;

public class VerticallyFlipped implements TextBlock{
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock contents;
    int current_height;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    public VerticallyFlipped(TextBlock contents){

        this.contents = contents;
        this.current_height = this.contents.height();
    }//RightJustified(TextBlock)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public String row(int i) throws Exception {
        // if(this.contents.height() == 1){
        //     return this.contents.heigth();
        // }//if
        
       // String temp = this.contents.row(i);
        String result = this.contents.row(this.contents.height());
        this.current_height = this.contents.height() - 1;

        return result;


    }//row(int)

    public int width() {
        return this.contents.width();
     } // width()
 
     public int height() {
         return this.contents.height();
     } // height()
}
