package lab.polymorphism;
/*
 * Tests for all the TextBlocks
 * 
 * @author Alma Ordaz
 */

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TextBlockTests {

  /*
   * ********************** Truncated Tests **********************
   */

  /*
   * Tests if the TextBlock is properly truncated with a width that is less than
   * the textBlock
   */
  @Test
  void truncatedSmaller() {
    TextBlock block = new Truncated(new BoxedBlock(new TextLine("Hello")), 3);
    String expected = "+--\n|He\n+--";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedSmaller()

  /*
   * Tests truncated at a length of 0
   */
  @Test
  void truncatedZero() {
    TextBlock block = new Truncated(new TextLine("Hello"), 0);
    String expected = "";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedZero()

  /*
   * Tests truncated at a width of the block
   */
  @Test
  void truncatedSame() {
    TextBlock block = new Truncated(new BoxedBlock(new TextLine("Hello")), 7);
    String expected = "+-----+\n|Hello|\n+-----+";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedSame()

  /*
   * Tests truncated with a width larger than the width of the block
   */
  @Test
  void truncatedLarger() {
    TextBlock block = new Truncated(new BoxedBlock(new TextLine("Hello")), 20);
    String expected = "+-----+\n|Hello|\n+-----+";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedLarger()

  /*
   * Tests truncated on an empty block
   */
  @Test
  void truncatedEmpty() {
    TextBlock block = new Truncated(new TextLine(""), 5);
    String expected = "";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedEmpty

  /*
   * Tests truncated as a parameter to other text blocks
   */
  @Test
  void truncatedAsParamere() {
    TextBlock block = new HComposition(new Truncated(new TextLine("Hello World"), 6), new TextLine("World"));
    String expected = "Hello World";

    assertEquals(expected, TBUtils.toString(block));
  }// truncatedAsParameter()

  /*
   * ******************* Centered Tests *******************
   */

  /*
   * Tests centered at a width of 0
   */
  @Test
  void centeredZero() {
    TextBlock block = new BoxedBlock(new Centered(new TextLine("Hello"), 0));
    String expected = "++\n||\n++";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredZero()

  /*
   * Tests centered at a width smaller than the block, if this is the case the
   * block should be truncated to that width
   */
  @Test
  void centeredSmaller() {
    TextBlock block = new Centered(new TextLine("Hello"), 3);
    String expected = "Hel";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredSmaller()

  /*
   * Tests centered at the same width of the block,
   * In this case it should just return the block
   */
  @Test
  void centeredSame() {
    TextBlock block = new Centered(new BoxedBlock(new TextLine("Hello")), 7);
    String expected = "+-----+\n|Hello|\n+-----+";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredSame()

  /*
   * Tests centered on a width larger than the TextBlock
   */
  @Test
  void centeredLarger() {
    TextBlock block = new Centered(new BoxedBlock(new TextLine("Hello")), 11);
    String expected = "  +-----+  \n  |Hello|  \n  +-----+  ";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredLarger()

  /*
   * Tests centered on an empty block
   */
  @Test
  void centeredEmpty() {
    TextBlock block = new Centered(new TextLine(""), 5);
    String expected = "     ";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredEmpty

  /*
   * Tests Centered as a parameter to other text blocks
   */
  @Test
  void centeredAsParamere() {
    TextBlock block = new Truncated(new Centered(new TextLine("Hello"), 9), 7);
    String expected = "  Hello";

    assertEquals(expected, TBUtils.toString(block));
  }// centeredAsParameter()

  /*
   * ******************* RightJustified Tests *******************
   */

  /*
   * Tests RightJustified on a width of 0
   */
  @Test
  void rightJustifiedZero() {
    TextBlock block = new BoxedBlock(new RightJustified(new TextLine("Hello"), 0));
    String expected = "++\n||\n++";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedZero()

  /*
   * Tests RightJustified on a width smaller than the width of the block
   */
  @Test
  void rightJustifiedSmaller() {
    TextBlock block = new RightJustified(new BoxedBlock(new TextLine("Hello World")), 5);
    String expected = "+----\n|Hell\n+----";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedSmaller()

  /*
   * Tests RightJustified on a width of the same size as the block
   */
  @Test
  void rightJustifiedSame() {
    TextBlock block = new BoxedBlock(new RightJustified(new TextLine("Hello"), 5));
    String expected = "+-----+\n|Hello|\n+-----+";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedSame()

  /*
   * Tests RightJustified on a width larger than the width of the block
   */
  @Test
  void rightJustifiedLarger() {
    TextBlock block = new BoxedBlock(new RightJustified(new TextLine("Hello"), 10));
    String expected = "+----------+\n|     Hello|\n+----------+";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedLarger()

  /*
   * Tests RightJustified on an empty block
   */
  @Test
  void rightJustifiedEmpty() {
    TextBlock block = new BoxedBlock(new RightJustified(new TextLine("Hello"), 0));
    String expected = "++\n||\n++";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedEmpty()

  /*
   * Tests RightJustified as a parameter to other text blocks
   */
  @Test
  void rightJustifiedAsParamerer() {
    TextBlock block = new Centered(new BoxedBlock(new RightJustified(new TextLine("Hello"), 7)), 11);
    String expected = " +-------+ \n |  Hello| \n +-------+ ";

    assertEquals(expected, TBUtils.toString(block));
  }// rightJustifiedAsParamerer()

  /*
   * ************************* HorrizontallyFlipped Tests
   * *************************
   */

  /*
   * Tests to see if HorizontallyFlipped can flip an empty block
   */
  @Test
  void horizontallyFlippedEmpty() {
    TextBlock block = new HorizontallyFlipped(new TextLine(""));
    String expected = "";

    assertEquals(expected, TBUtils.toString(block));
  }// horizontallyFlippedEmpty()

  /*
   * Tests to see if HorizontallyFlipped can flip two complex blocks built with a
   * combination of various text blocks that are then HComposed
   */
  @Test
  void horizontallyFlippedComplex() {
    TextBlock block1 = new Centered(new BoxedBlock(new TextLine("Hello")), 9);
    TextBlock block2 = new Truncated(new TextLine("truncated"), 3);
    TextBlock actual = new HorizontallyFlipped(new HComposition(block1, block2));
    String expected = "urt +-----+ \n    |olleH| \n    +-----+ ";

    assertEquals(expected, TBUtils.toString(actual));
  }// horizontallyFlippedComplex()

  /*
   * Tests HorizontallyFlipped as a parameter to other text blocks
   */
  @Test
  void horizontallyFlippedAsParameter() {
    TextBlock block = new Centered(new HorizontallyFlipped(new BoxedBlock(new TextLine("Hello"))), 9);
    String expected = " +-----+ \n |olleH| \n +-----+ ";

    assertEquals(expected, TBUtils.toString(block));
  }// horizontallyFlippedAsParameter()

  /*
   * ********************* VerticallyFlipped Tests *********************
   */

  /*
   * Tests to see if HorizontallyFlipped can flip an empty block
   */
  @Test
  void verticallyFlippedEmpty() {
    TextBlock block = new VerticallyFlipped(new TextLine(""));
    String expected = "";

    assertEquals(expected, TBUtils.toString(block));
  }// verticallyFlippedEmpty()

  /*
   * Tests to see if VerticallyFlipped can flip two complex blocks built with a
   * combination of various text blocks that are then VComposed
   */
  @Test
  void verticallyFlippedComplex() {
    TextBlock block1 = new Centered(new BoxedBlock(new TextLine("Hello")), 9);
    TextBlock block2 = new Truncated(new TextLine("truncated"), 3);
    TextBlock actual = new VerticallyFlipped(new VComposition(block1, block2));
    String expected = "tru      \n +-----+ \n |Hello| \n +-----+ ";

    assertEquals(expected, TBUtils.toString(actual));
  }// verticallyFlippedComplex()

  /*
   * Tests VerticallyFlipped as a parameter to other text blocks
   */
  @Test
  void verticallyFlippedAsParameter() {
    TextBlock block = new Truncated(
        new VerticallyFlipped(new VComposition(new TextLine("Hello"), new TextLine("World"))), 4);
    String expected = "Worl\nHell";

    assertEquals(expected, TBUtils.toString(block));
  }// verticallyFlippedAsParameter()

  /*
   * Tests VerticallyFlipped when the block has a height of 1, i.e. it is a
   * TextLine
   */
  @Test
  void verticallyFlippledLine() {
    TextBlock block = new VerticallyFlipped(new TextLine("Hello"));
    String expected = "Hello";

    assertEquals(expected, TBUtils.toString(block));
  }// verticallyFlippedLine()

  /*
   * ********************FillSpace Tests********************
   */

  /*
   * Tests FillSpace on an empty Block
   */
  @Test
  void fillSpaceEmpty() {
    TextBlock block = new FillSpace(new TextLine(""));
    String expected = "";

    assertEquals(expected, TBUtils.toString(block));
  }// fillSpaceEmpty()

  /*
   * Test FillSpace when there is no empty space
   */
  @Test
  void fillSpaceNoEmpty() {
    TextBlock block = new FillSpace(new BoxedBlock(new TextLine("HelloWorld")));
    String expected = "+----------+\n|HelloWorld|\n+----------+";

    assertEquals(expected, TBUtils.toString(block));
  }// fillSpaceNoEmpty()
  /*
   * Tests FillSpace when there is empty space
   */

  @Test
  void fillSpaceExcists() {
    TextBlock block1 = new Centered(new BoxedBlock(new TextLine("Hello")), 9);
    TextBlock block2 = new Truncated(new TextLine("truncated"), 3);
    TextBlock actual = new FillSpace(new HorizontallyFlipped(new HComposition(block1, block2)));
    String expected = "urt*+-----+*\n****|olleH|*\n****+-----+*";

    assertEquals(expected, TBUtils.toString(actual));
  }// fillSpaceExcists

  /*
   * ***************** equal Tests *****************
   */

  /*
   * Tests TBUtils.equal on two blocks that do not contain the same lines
   */
  @Test
  void equalFalse() throws Exception {
    TextBlock block1 = new BoxedBlock(new TextLine("Hello"));
    TextBlock block2 = new BoxedBlock(new TextLine("World"));
    Boolean actual = TBUtils.equal(block1, block2);

    assertEquals(false, actual);
  }// equalFalse()

  /*
   * Tests TBUtils.equal on two block that contain the same lines but built in a
   * different way
   */
  @Test
  void equalTrue() throws Exception {
    TextBlock block1 = new BoxedBlock(new Truncated(new Centered(new TextLine("hello"), 9), 7));
    TextBlock block2 = new BoxedBlock(new RightJustified(new TextLine("hello"), 7));
    Boolean actual = TBUtils.equal(block1, block2);

    assertEquals(true, actual);
  }// equalTrue()

  /*
   * ***************** eqv Tests *****************
   */

  /*
   * Tests TBUtils.eqv on two blocks that are not built the same same way
   * but have the same lines
   */
  @Test
  void eqvFalse() throws Exception {
    TextBlock block1 = new Truncated(new Centered(new TextLine("hello"), 9), 7);
    TextBlock block2 = new RightJustified(new TextLine("hello"), 7);
    Boolean actual = TBUtils.eqv(block1, block2);

    assertEquals(false, actual);
  }// eqvFalse()

  /*
   * Tests TBUtils.eqv on two blocks that are built the same way but do not have
   * the same lines
   */
  @Test
  void eqvTrue() {
    TextBlock block1 = new BoxedBlock(new Truncated(new TextLine("Hello"), 5));
    TextBlock block2 = new BoxedBlock(new Truncated(new TextLine("World"), 3));
    Boolean actual = TBUtils.eqv(block1, block2);

    assertEquals(true, actual);
  }// eqvTrue()

  /*
   * ***************** eq Tests *****************
   */

  /*
   * Tests TBUtils.eq on two blocks that not built in the same way so they
   * will have different memory locations
   */
  @Test
  void eqfalse() {
    TextBlock block1 = new BoxedBlock(new Truncated(new Centered(new TextLine("hello"), 9), 7));
    TextBlock block2 = new BoxedBlock(new RightJustified(new TextLine("hello"), 7));
    Boolean actual = TBUtils.eq(block1, block2);

    assertEquals(false, actual);
  }// eqFalse()

  /*
   * Tests TBUtils.eq on two blocks with the same memory location
   */
  @Test
  void eqTrue() {
    TextBlock block1 = new BoxedBlock(new Truncated(new Centered(new TextLine("hello"), 9), 7));
    TextBlock block2 = block1;
    Boolean actual = TBUtils.eq(block1, block2);

    assertEquals(true, actual);
  }// eqTrue()

}// class TextBlockTests
