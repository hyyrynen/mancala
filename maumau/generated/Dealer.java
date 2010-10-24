/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath


public class Dealer
{



   private  Dealer ()
   {
   }

   public static final String PROPERTY_DEALER = "dealer";

   @Property( name = PROPERTY_DEALER, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private static Dealer dealer = new Dealer();


   public static Dealer getInstance ()
   {

      return dealer;
   }

   /**
    * <pre>
    *           0..1     is     0..1
    * Dealer ------------------------- Player
    *           dealer               player
    * </pre>
    */
   public static final String PROPERTY_PLAYER = "player";

   @Property( name = PROPERTY_PLAYER, partner = Player.PROPERTY_DEALER, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player player;

   @Property( name = PROPERTY_PLAYER )
   public boolean setPlayer (Player value)
   {
      boolean changed = false;

      if (this.player != value)
      {
      
         Player oldValue = this.player;
         Dealer source = this;
         if (this.player != null)
         {
            this.player = null;
            oldValue.setDealer (null);
         }
         this.player = value;

         if (value != null)
         {
            value.setDealer (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_PLAYER )
   public Dealer withPlayer (Player value)
   {
      setPlayer (value);
      return this;
   }

   public Player getPlayer ()
   {
      return this.player;
   }

   public void removeYou()
   {
      this.setPlayer (null);
   }
}


