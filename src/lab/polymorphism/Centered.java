package lab.polymorphism;

import java.lang.String;

public class Centered implements TextBlock{
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock block;
    int width;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    public Centered(TextBlock block, int width) {
        this.block = block;
        this.width = width;
    }// centered(Textblock, int)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public String row(int i) throws Exception {

        int start = this.width - this.block.width();
        int spaces = start / 2;
        String result;
        

        if (this.block.width() > this.width){
            TextBlock help = new Truncated(this.block, this.width);
            return help.row(i);
        }//if
        else if ((start % 2) == 0) {

            result = TBUtils.spaces(spaces);
            result = result.concat(this.block.row(i));
            result = result.concat(TBUtils.spaces(spaces));
            return result;
        } // else if
        else {
            result = TBUtils.spaces(spaces);
            result = result.concat(this.block.row(i));
            result = result.concat(TBUtils.spaces(spaces + 1));
            return result;
        } // else
    }// row(int)

    public int width() {
       return this.width;
    } // width()

    public int height() {
        return this.block.height();
    } // height()

}// class Centered
