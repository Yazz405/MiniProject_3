package lab.polymorphism;

import java.lang.String;

/**
 * A text block centered on a width.
 *
 * @author Alma Ordaz
 */

public class Centered implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // the TextBlock that will be centered
  TextBlock block;

  // the width we will use to center
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  // Build a new block that is centered along width
  public Centered(TextBlock block, int width) {
    this.block = block;
    this.width = width;
  }// centered(Textblock, int)

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

    // the amount of total spaces
    int start = this.width - this.block.width();

    // the amount of spaces for one side of the block
    int spaces = start / 2;
    String result;

    // if the textblock is wider than the width we are using to center
    if (this.block.width() > this.width) {
      TextBlock help = new Truncated(this.block, this.width);
      return help.row(i);
    } // if
    // if spaces can be divided equally both sides of the block will have equal
    // amount of spaces
    else if ((start % 2) == 0) {

      result = TBUtils.spaces(spaces);
      result = result.concat(this.block.row(i));
      result = result.concat(TBUtils.spaces(spaces));
      return result;
    } // else if
    // if spaces are not even add one more space to the left of block
    else {
      result = TBUtils.spaces(spaces);
      result = result.concat(this.block.row(i));
      result = result.concat(TBUtils.spaces(spaces + 1));
      return result;
    } // else
  }// row(int)

  /*
   * returns the width
   */
  public int width() {
    return this.width;
  } // width()

  /*
   * returns the height
   */
  public int height() {
    return this.block.height();
  } // height()

  /*
   * checks to see if other is the same type as Centered
   */
  public boolean eqv(TextBlock other) {
    return other instanceof Centered;
  }// eqv(TextBlock)

}// class Centered
