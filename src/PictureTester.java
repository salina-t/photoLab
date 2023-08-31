/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester {
  public static void main(String[] args) {
    //testMirrorDiagonal();
    //testFadeBorder();
    testRedColorPop();
    //testNegate();
    //testGrayScale();
    //testColorReplacement();
    //testOwnFilter();
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testAllRed();
    //testZeroBlue();
    //testPixelate();
  }

  /**
   * Method to test zeroBlue
   */
  public static void testZeroBlue() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }

  public static void testAllRed() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.allRed();
    beach.explore();
  }

  public static void testNegate() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }

  public static void testGrayScale() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }

  public static void testMirrorHorizontal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontal();
    beach.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorHorizontalBotToTop();
    beach.explore();
  }

  public static void testMirrorVerticalRightToLeft() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorVerticalRightToLeft();
    beach.explore();
  }

  public static void testColorReplacement() {
    Picture motor = new Picture("blueMotorcycle.jpg");
    motor.explore();
    motor.colorReplacement();
    motor.explore();
  }

  public static void testRedColorPop() {
    Picture arch = new Picture("arch.jpg");
    arch.explore();
    arch.redColorPop();
    arch.explore();
  }

  public static void testMirrorDiagonal() {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.mirrorDiagonal();
    beach.explore();
  }

  public static void testFadeBorder() {
    Picture wall = new Picture("wall.jpg");
    wall.explore();
    wall.fadeBorder();
    wall.explore();
  }

  public static void testOwnFilter() {
    Picture arch = new Picture("arch.jpg");
    arch.explore();
    arch.ownFilter();
    arch.explore();
  }

  public static void testPixelate () {
    Picture wall = new Picture("wall.jpg");
    wall.explore();
    wall.pixelate();
    wall.explore();
  }

}