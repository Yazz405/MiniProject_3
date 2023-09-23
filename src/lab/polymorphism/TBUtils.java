package lab.polymorphism;

import java.io.PrintWriter;

/**
 * Utilities for TextBlocks.
 * 
 * @author Samuel A. Rebelsky
 * @version 1.3 of September 2014
 */
public class TBUtils {
  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  /**
   * A really big sequence of dashes. This sequence may grow as the program operates.
   */
  static String lotsOfDashes = "--";

  /**
   * A really big sequence of spaces. This sequence may grow as the program operates.
   */
  static String lotsOfSpaces = "  ";

  // +----------------+----------------------------------------------------
  // | Static Methods |
  // +----------------+

  /**
   * Build a sequence of dashes of a specified length.
   */
  static String dashes(int len) {
    // Note: This strategy probably represents an overkill in
    // attempts at efficiency.
    // Make sure the collection of dashes is big enough
    while (lotsOfDashes.length() < len) {
      lotsOfDashes = lotsOfDashes.concat(lotsOfDashes);
    } // while
    // Extract an appropriate length substring
    return lotsOfDashes.substring(0, len);
  } // dashes(int)

  /**
   * Print a TextBlock to the specified destination.
   */
  public static void print(PrintWriter pen, TextBlock block) {
    for (int i = 0; i < block.height(); i++) {
      // Even though we only call block.row with a valid i,
      // we need to put the call in a try/catch block.
      try {
        pen.println(block.row(i));
      } catch (Exception e) {
        pen.println();
      } // catch (Exception)
    } // for
  } // print(PrintWriter, TextBlock)

  /**
   * Build a sequence of spaces of a specified length.
   */
  static String spaces(int len) {
    // As with dashes, this is probably overkill.
    // Make sure the collection of dashes is big enough
    while (lotsOfSpaces.length() < len) {
      lotsOfSpaces = lotsOfSpaces.concat(lotsOfSpaces);
    } // while
    // Extract an appropriate length substring
    return lotsOfSpaces.substring(0, len);
  } // spaces(int)

  /*
   * Two TextBlocks will be equal if their rows are equal
   */
  public static boolean equal(TextBlock t1, TextBlock t2) throws Exception{

    //if the don't have the same amount of rows then they aren't the same
    if(t1.height() != t2.height()){
      return false;
    }//if

    //return false when you encounter a row where t1.row does not equal t2.row
    for(int j = 0; j < t1.height(); j++){
      if(!(t1.row(j).equals(t2.row(j)))){
        return false;
      }//if
    }//for

    return true;
  }//equal(TextBlock, TextBlock)

  /*
   * Two TextBlocks are equal if they are built the same way
   */
  public static boolean eqv(TextBlock t1, TextBlock t2) {
    return t1.eqv(t2);
  }//eqv(TextBlock, TextBlock)

  /*
   * Two TextBlocks are equal if there are stored in the same memory location
   */
  public static boolean eq(TextBlock t1, TextBlock t2){
    
    return t1 == t2;
  }//eq(TextBlock, TextBlock)



} // class TBUtils
