package lab.polymorphism;

/**
 * The TextBlock whose empty spaces is filled with '*'.
 *
 * @author Alma Ordaz
 */

public class FillSpace implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock block;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  // a new block whose empty spaces is filed with '*'
  public FillSpace(TextBlock block) {

    this.block = block;
  }// FillSpace(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @pre 0 <= i < this.height()
   * @exception Exception if the precondition is not met
   */
  public String row(int i) throws Exception {
    char[] line = this.block.row(i).toCharArray();

    for (int j = 0; j < this.block.width(); j++) {
      if (line[j] == ' ') {
        line[j] = '*';
      } // if
    } // for

    return new String(line);
  }// row(int)

  /*
   * returns block width
   */
  public int width() {
    return this.block.width();
  } // width()

  /*
   * returns block height
   */
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
