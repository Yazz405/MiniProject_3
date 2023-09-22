package lab.polymorphism;

import java.io.PrintWriter;

import org.w3c.dom.Text;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    TextBlock block = new TextLine("Hello");
    TextBlock truncate_test = new Truncated(new BoxedBlock(new TextLine("tester")), 5);
    TextBlock centered_test = new BoxedBlock(new Centered(new TextLine("Hello"), 7));
    TextBlock right_test = new BoxedBlock(new RightJustified(new TextLine("rigth justified"), 21));
    TextBlock VFlip_test = new VerticallyFlipped(new VComposition(centered_test, right_test));
    TextBlock HFlip_test = new HorizontallyFlipped(new TextLine("hello"));



    // Print out the block
    TBUtils.print(pen, block);
    TBUtils.print(pen, truncate_test);
    TBUtils.print(pen, centered_test);
    TBUtils.print(pen, right_test);
    TBUtils.print(pen, VFlip_test);
    TBUtils.print(pen, HFlip_test);

    

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt