/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    //beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
  //  temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  public static void testMirrorArms()
  {
      Picture caterpillar = new Picture("snowman.jpg");
      caterpillar.explore();
      caterpillar.mirrorArms();
      caterpillar.explore();
  }
  
  
  
  
  
  public static void testPictureLab()
  {
      Picture tiger = new Picture("tiger.jpg");
      tiger.explore();
      tiger.cropAndCopy(tiger,122,383,530,870,373,846);
      tiger.grayscale(373,634,846,1186);
      tiger.cropAndCopy(tiger,109,632,610,1187,1,1);
      tiger.zeroBlue(1,524,1,578); 
      tiger.mirrorHorizontal();
      tiger.mirrorVertical();
      tiger.grayscale(0,264,0,274);
      tiger.bluescale(502,766,0,274);
      tiger.greenscale(0,264,1086,1364);
      tiger.redscale(502,766,1086,1364);
      //tiger.mirrorTemple(0,264,0,274);
      //tiger.mirrorTemple(506,766,0,274);
      tiger.explore();
  }
  
  
  
  
  
  
  public static void testCropAndCopy()
  {
      Picture caterpillar = new Picture("water.jpg");
      Picture snowman = new Picture("snowman.jpg");
      caterpillar.explore();
      caterpillar.cropAndCopy(snowman, 10, 100, 10, 100,5, 5);
      caterpillar.explore();
  }
  
  public static void testFixUnderwater()
  {
      Picture caterpillar = new Picture("water.jpg");
      caterpillar.explore();
      caterpillar.fixUnderwater();
      caterpillar.explore();
  }
  public static void testGrayscale()
  {
      Picture caterpillar = new Picture("snowman.jpg");
      caterpillar.explore();
      //caterpillar.grayscale();
      caterpillar.explore();
  }
  public static void testNegate()
  {
      Picture caterpillar = new Picture("snowman.jpg");
      caterpillar.explore();
      caterpillar.negate();
      caterpillar.explore();
  }
  public static void testKeepOnlyBlue()
  {
      Picture caterpillar = new Picture("snowman.jpg");
      caterpillar.explore();
      caterpillar.keepOnlyBlue();
      caterpillar.explore();
  }
  public static void testMirrorDiagonal()
  {
      Picture caterpillar = new Picture("caterpillar.jpg");
      caterpillar.explore();
      caterpillar.mirrorDiagonal();
      caterpillar.explore();
  }
  public static void testMirrorHorizontalBotToTop()
  {
      Picture caterpillar = new Picture("caterpillar.jpg");
      caterpillar.explore   ();
      caterpillar.mirrorHorizontalBotToTop();
      caterpillar.explore();
  }
  public static void testMirrorVerticalRightToLeft()
  { 
      Picture caterpillar = new Picture("caterpillar.jpg");
      caterpillar.explore();
      caterpillar.mirrorVerticalRightToLeft();
      caterpillar.explore(); 
  }
  public static void testMirrorHorizontal()
  { 
      Picture caterpillar = new Picture("caterpillar.jpg");
      caterpillar.explore();
      caterpillar.mirrorHorizontal();
      caterpillar.explore(); 
  }
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorDiagonal();
    //testMirrorHorizontalBotToTop();
    //testMirrorHorizontal();
    //testMirrorVerticalRightToLeft();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCropAndCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    testPictureLab();
  }
}