/*
 * generated by Fujaba - CodeGen2
 */
import junit.framework.TestSuite;
import de.upb.tools.sdm.*; // requires Fujaba5/libs/RuntimeTools.jar in classpath
import junit.framework.Test;


public class maumauAllTests
{



   public static Test suite ()
   {
      boolean fujaba__Success = false;
      TestSuite suite = null;

      // add all tests to suite
      // story pattern usecasestep
      try 
      {
         fujaba__Success = false; 

         // create object suite
         suite = new TestSuite ( );

         // collabStat call
         suite.addTestSuite (UlnoPlaysAnJAndChoosesASuitTest.class);
         // collabStat call
         suite.addTestSuite (EeroDealsOneRoundTest.class);
         // collabStat call
         suite.addTestSuite (ArtjomPlaysAn8AndEeroSkipsATurnTest.class);
         // collabStat call
         suite.setName ("maumauAllTests");
         // collabStat call
         suite.addTestSuite (UulnoPlays7ForcingArtjomDraw2CardsTest.class);
         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      return suite;
   }

   public void removeYou()
   {
   }
}


