/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath


public class Card
{



   /**
    * <pre>
    *           0..1     on top of     0..1
    * Card ------------------------- Card
    *           card               card
    * </pre>
    */
   public static final String PROPERTY_CARD = "card";

   @Property( name = PROPERTY_CARD, partner = Card.PROPERTY_CARD, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card card;

   @Property( name = PROPERTY_CARD )
   public boolean setCard (Card value)
   {
      boolean changed = false;

      if (this.card != value)
      {
      
         Card oldValue = this.card;
         Card source = this;
         if (this.card != null)
         {
            this.card = null;
            oldValue.setCard (null);
         }
         this.card = value;

         if (value != null)
         {
            value.setCard (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_CARD )
   public Card withCard (Card value)
   {
      setCard (value);
      return this;
   }

   public Card getCard ()
   {
      return this.card;
   }

   /**
    * <pre>
    *           0..1     on top     0..1
    * Card ------------------------- Deck
    *           card               deck
    * </pre>
    */
   public static final String PROPERTY_DECK = "deck";

   @Property( name = PROPERTY_DECK, partner = Deck.PROPERTY_CARD, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Deck deck;

   @Property( name = PROPERTY_DECK )
   public boolean setDeck (Deck value)
   {
      boolean changed = false;

      if (this.deck != value)
      {
      
         Deck oldValue = this.deck;
         Card source = this;
         if (this.deck != null)
         {
            this.deck = null;
            oldValue.setCard (null);
         }
         this.deck = value;

         if (value != null)
         {
            value.setCard (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DECK )
   public Card withDeck (Deck value)
   {
      setDeck (value);
      return this;
   }

   public Deck getDeck ()
   {
      return this.deck;
   }

   public static final String PROPERTY_NAME = "name";

   @Property( name = PROPERTY_NAME, kind = ReferenceHandler.ReferenceKind.ATTRIBUTE )
   private String name;

   @Property( name = PROPERTY_NAME )
   public void setName (String value)
   {
      this.name = value;
   }

   public Card withName (String value)
   {
      setName (value);
      return this;
   }

   @Property( name = PROPERTY_NAME )
   public String getName ()
   {
      return this.name;
   }

   /**
    * <pre>
    *           0..n     has     0..1
    * Card ------------------------- Player
    *           card               player
    * </pre>
    */
   public static final String PROPERTY_PLAYER = "player";

   @Property( name = PROPERTY_PLAYER, partner = Player.PROPERTY_CARD, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player player;

   @Property( name = PROPERTY_PLAYER )
   public boolean setPlayer (Player value)
   {
      boolean changed = false;

      if (this.player != value)
      {
      
         Player oldValue = this.player;
         Card source = this;
         if (this.player != null)
         {
            this.player = null;
            oldValue.removeFromCard (this);
         }
         this.player = value;

         if (value != null)
         {
            value.addToCard (this);
         }
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_PLAYER )
   public Card withPlayer (Player value)
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
      this.setCard (null);
      this.setDeck (null);
      this.setPlayer (null);
   }
}


