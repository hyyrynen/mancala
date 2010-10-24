/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath
import java.util.*;
import de.upb.tools.fca.*; // requires Fujaba5/libs/RuntimeTools.jar in classpath
import de.upb.tools.sdm.*; // requires Fujaba5/libs/RuntimeTools.jar in classpath


public class Root
{



   private  Root ()
   {
   }

   /**
    * <pre>
    *           0..1     root     0..n
    * Root ------------------------- Directory
    *           root               abstractFile
    * </pre>
    */
   public static final String PROPERTY_ABSTRACT_FILE = "abstractFile";

   @Property( name = PROPERTY_ABSTRACT_FILE, partner = Directory.PROPERTY_ROOT, kind = ReferenceHandler.ReferenceKind.TO_MANY,
         adornment = ReferenceHandler.Adornment.COMPOSITION)
   private FHashSet<Directory> abstractFile;

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public Set<? extends Directory> getAbstractFile()
   {
      return ((this.abstractFile == null)
              ? Collections.EMPTY_SET
              : Collections.unmodifiableSet(this.abstractFile));
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public boolean addToAbstractFile (Directory value)
   {
      boolean changed = false;

      if (value != null)
      {
         if (this.abstractFile == null)
         {
            this.abstractFile = new FHashSet<Directory> ();

         }
      
         changed = this.abstractFile.add (value);
         if (changed)
         {
            value.setRoot (this);
         }
      
      }
      return changed;
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public Root withAbstractFile (Directory value)
   {
      addToAbstractFile (value);
      return this;
   }

   public Root withoutAbstractFile (Directory value)
   {
      removeFromAbstractFile (value);
      return this;
   }


   public boolean removeFromAbstractFile (Directory value)
   {
      boolean changed = false;

      if ((this.abstractFile != null) && (value != null))
      {
      
         changed = this.abstractFile.remove (value);
         if (changed)
         {
            value.setRoot (null);
         }
      
      }
      return changed;
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public void removeAllFromAbstractFile (){
   
      Directory tmpValue;
      Iterator<? extends Directory> iter = this.iteratorOfAbstractFile ();
      while (iter.hasNext ())
      {
         tmpValue = (Directory) iter.next ();
         this.removeFromAbstractFile (tmpValue);
      }
   
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public boolean hasInAbstractFile (Directory value)
   {
      return ((this.abstractFile != null) &&
              (value != null) &&
              this.abstractFile.contains (value));
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public Iterator<? extends Directory> iteratorOfAbstractFile ()
   {
      return ((this.abstractFile == null)
              ? FEmptyIterator.<Directory>get ()
              : this.abstractFile.iterator ());
   }

   @Property( name = PROPERTY_ABSTRACT_FILE )
   public int sizeOfAbstractFile ()
   {
      return ((this.abstractFile == null)
              ? 0
              : this.abstractFile.size ());
   }

   public void accept (Visitor visitor )
   {
      boolean fujaba__Success = false;

      // story pattern storypatternwiththis
      try 
      {
         fujaba__Success = false; 

         // collabStat call
         this.visitor.visit(this);
         // collabStat call
         for ( int i = 0;i <= this.childNodes.length;++i )
         {
         this.this.childNodes[i].accept(visitor);
         }
         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

      return ;
   }

   public static Root getInstance ()
   {
   }

   public static final String PROPERTY_INSTANCE = "instance";

   @Property( name = PROPERTY_INSTANCE, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private static Root instance;


   public void removeYou()
   {
      for (Iterator iterAbstractFile = this.iteratorOfAbstractFile (); iterAbstractFile.hasNext ();)
      {
         ((Directory)iterAbstractFile.next ()).removeYou ();
      }
   }
}


