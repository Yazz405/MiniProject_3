package lab.polymorphism;

/**
 * A text block that is flipped horizontally.
 *
 * @author Alma Ordaz
 */

public class HorizontallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock contents;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /*
   * build a new block that is horizontally flipped
   */
  public HorizontallyFlipped(TextBlock contents) {
    this.contents = contents;

  }// HorizontallyJustified(TextBlock)

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

    char[] line = this.contents.row(i).toCharArray();
    char temp;
    int changingWidth = this.contents.width() - 1;
    for (int j = 0; j < (this.contents.width() / 2); j++) {
      temp = line[j];
      line[j] = line[changingWidth];
      line[changingWidth] = temp;
      changingWidth--;
    } // for

    return new String(line);
  }// row(int)

  public int width() {
    return this.contents.width();
  } // width()

  public int height() {
    return this.contents.height();
  } // height()

  /*
   * checks to see if other is the same type as HorizontallyFlipped
   */
  public boolean eqv(TextBlock other) {
    return other instanceof HorizontallyFlipped;
  }// eqv(TextBlock)

}// class HorizontallyFlipped
