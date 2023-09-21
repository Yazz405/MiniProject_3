package lab.polymorphism;
public class Truncated implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock block;
    int w;

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public Truncated(TextBlock block, int w) {
        this.block = block;
        this.w = w;
]
    }// Truncated(TextBlock, int)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    /*
     * 
     */
    public String row(int i) throws Exception{
        int h = this.block.height();
        int w = this.w;

        // Sanity check
        if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid

        return this.block.row(i).substring(0, w);

    }// row(int)

    public int width() {
        return this.w;
    } // width()

    public int height() {
        return this.block.height();
    } // height()

}//class Truncated
