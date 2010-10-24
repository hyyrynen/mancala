/*
 * generated by Fujaba - CodeGen2
 */
import java.io.File;
import de.upb.tools.sdm.*; // requires Fujaba5/libs/RuntimeTools.jar in classpath


public class RegularFile extends AbstractFile
{



   public  RegularFile (String name )
   {
      boolean fujaba__Success = false;
      File f = null;

      // story pattern storypatternwiththis
      try 
      {
         fujaba__Success = false; 

         // create object f
         f = new java.io.File(name);

         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      if ( !( fujaba__Success ) )
      {
         return ;

      }
      // // <add comment>
      // story pattern storypatternwiththis
      try 
      {
         fujaba__Success = false; 

         // check object f is really bound
         JavaSDM.ensure ( f != null );
         // constraint f.isFile()
         JavaSDM.ensure ( f.isFile() );
         // create link file from this to f
         this.setIoFile (f);

         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      if ( !( fujaba__Success ) )
      {
         return ;

      }
      return ;
   }

   public void accept (Visitor visitor )
   {
      boolean fujaba__Success = false;

      // story pattern storypatternwiththis
      try 
      {
         fujaba__Success = false; 

         // check object visitor is really bound
         JavaSDM.ensure ( visitor != null );
         // collabStat call
         visitor.visit(this);
         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      return ;
   }

   public long getFileSize ()
   {
      boolean fujaba__Success = false;
      File f = null;

      // story pattern storypatternwiththis
      try 
      {
         fujaba__Success = false; 

         // search to-one link file from this to f
         f = this.getIoFile ();

         // check object f is really bound
         JavaSDM.ensure ( f != null );


         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      return f.length();
   }

}


