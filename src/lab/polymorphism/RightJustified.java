package lab.polymorphism;

public class RightJustified implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock block;
    int width;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    public RightJustified(TextBlock block, int width) {

        this.block = block;
        this.width = width;
    }// RightJustified(TextBlock, int)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public String row(int i) throws Exception {
        int spaces = this.width - this.block.width();
        String result;

        if (this.block.width() > this.width) {
            TextBlock help = new Truncated(this.block, this.width);
            return help.row(i);
        } // if
        else {
            result = TBUtils.spaces(spaces).concat(this.block.row(i));
        } // else

        return result;

    }// row(int)

    public int width() {
        return this.width;
    } // width()

    public int height() {
        return this.block.height();
    } // height()

    /*
     * checks to see if other is the same type as RightJustified
     */
    public boolean eqv(TextBlock other) {
        return other instanceof RightJustified;
    }// eqv(TextBlock)

}// class RightJustified
