/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath
import java.io.File;


public class AbstractFile
{



   public void accept (Visitor visitor )
   {

      return ;
   }

   /**
    * <pre>
    *           0..*     has     1
    * AbstractFile ------------------------- Directory
    *           abstractFile               directory
    * </pre>
    */
   public static final String PROPERTY_DIRECTORY = "directory";

   @Property( name = PROPERTY_DIRECTORY, partner = Directory.PROPERTY_ABSTRACT_FILE, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.PARENT)
   private Directory directory;

   @Property( name = PROPERTY_DIRECTORY )
   public boolean setDirectory (Directory value)
   {
      boolean changed = false;

      if (this.directory != value)
      {
      
         Directory oldValue = this.directory;
         AbstractFile source = this;
         if (this.directory != null)
         {
            this.directory = null;
            oldValue.removeFromAbstractFile (this);
         }
         this.directory = value;

         if (value != null)
         {
            value.addToAbstractFile (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DIRECTORY )
   public AbstractFile withDirectory (Directory value)
   {
      setDirectory (value);
      return this;
   }

   public Directory getDirectory ()
   {
      return this.directory;
   }

   /**
    * <pre>
    *           0..1     file     0..1
    * AbstractFile ------------------------> File
    *           abstractFile               file
    * </pre>
    */
   public static final String PROPERTY_FILE = "file";

   @Property( name = PROPERTY_FILE, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private File file;

   @Property( name = PROPERTY_FILE )
   public boolean setFile (File value)
   {
      boolean changed = false;

      if (this.file != value)
      {
      
         File oldValue = this.file;
         this.file = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_FILE )
   public AbstractFile withFile (File value)
   {
      setFile (value);
      return this;
   }

   public File getFile ()
   {
      return this.file;
   }

   public static final String PROPERTY_NAME = "name";

   @Property( name = PROPERTY_NAME, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private String name;

   @Property( name = PROPERTY_NAME )
   private void setName (String value)
   {
      this.name = value;
   }

   private AbstractFile withName (String value)
   {
      setName (value);
      return this;
   }

   @Property( name = PROPERTY_NAME )
   private String getName ()
   {
      return this.name;
   }

   public void removeYou()
   {
      this.setDirectory (null);
      this.setFile (null);
   }
}

