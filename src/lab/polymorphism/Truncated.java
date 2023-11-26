package lab.polymorphism;

public class Truncated implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock block;
  int width;

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public Truncated(TextBlock block, int width) {
    this.block = block;
    this.width = width;

  }// Truncated(TextBlock, int)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /*
   * @pre
   */
  public String row(int i) throws Exception {
    int height = this.height();
    int width = this.width;

    // Sanity check
    if ((i < 0) || (i >= height)) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid

    if ((this.block.width() < width) || (this.block.width() == width)) {
      return this.block.row(i);
    } // if
    else {
      return this.block.row(i).substring(0, width);
    } // else

  }// row(int)

  public int width() {
    return this.width;
  } // width()

  public int height() {
    return this.block.height();
  } // height()

  /*
   * checks to see if other is the same type as Truncated
   */
  public boolean eqv(TextBlock other) {
    return other instanceof Truncated;
  }// eqv(TextBlock)

}// class Truncated
