package lab.polymorphism;

public class VerticallyFlipped implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  TextBlock contents;
  int current_height;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public VerticallyFlipped(TextBlock contents) {

    this.contents = contents;
    this.current_height = this.contents.height();
  }// RightJustified(TextBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  public String row(int i) throws Exception {

    String result = this.contents.row(this.contents.height() - 1 - i);
    return result;

  }// row(int)

  public int width() {
    return this.contents.width();
  } // width()

  public int height() {
    return this.contents.height();
  } // height()

  /*
   * checks to see if other is the same type as VerticallyFlipped
   */
  public boolean eqv(TextBlock other) {
    return other instanceof VerticallyFlipped;
  }// eqv(TextBlock)

}// class VerticallyFlipped
