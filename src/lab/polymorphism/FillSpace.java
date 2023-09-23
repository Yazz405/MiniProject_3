package lab.polymorphism;

public class FillSpace implements TextBlock {
    // +--------+------------------------------------------------------------
    // | Fields |
    // +--------+

    TextBlock block;

    // +--------------+------------------------------------------------------
    // | Constructors |
    // +--------------+

    public FillSpace(TextBlock block) {

        this.block = block;
    }// FillSpace(TextBlock)

    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    public String row(int i) throws Exception {
        char[] line = this.block.row(i).toCharArray();

        for (int j = 0; j < this.block.width(); j++) {
            if (line[j] == ' ') {
                line[j] = '*';
            } // if
        } // for

        return new String(line);
    }// row(int)

    public int width() {
        return this.block.width();
    } // width()

    public int height() {
        return this.block.height();
    } // height()

    /*
     * checks to see if other is the same type as FillSpace
     */
    public boolean eqv(TextBlock other) {
        return other instanceof FillSpace;
    }// eqv(TextBlock)
    
}// class FillSpace
