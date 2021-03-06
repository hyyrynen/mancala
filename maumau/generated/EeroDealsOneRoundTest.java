/*
 * generated by Fujaba - CodeGen2
 */
import de.uni_kassel.features.annotation.util.Property; // requires Fujaba5/libs/features.jar in classpath
import de.uni_kassel.features.ReferenceHandler; // requires Fujaba5/libs/features.jar in classpath
import de.upb.tools.sdm.*; // requires Fujaba5/libs/RuntimeTools.jar in classpath
import junit.framework.TestCase;


public class EeroDealsOneRoundTest extends TestCase
{



   /**
    * <pre>
    *           0..1     object_Artjom     0..1
    * EeroDealsOneRoundTest ------------------------> Player
    *           test               Artjom
    * </pre>
    */
   public static final String PROPERTY_ARTJOM = "Artjom";

   @Property( name = PROPERTY_ARTJOM, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player Artjom;

   @Property( name = PROPERTY_ARTJOM )
   public boolean setArtjom (Player value)
   {
      boolean changed = false;

      if (this.Artjom != value)
      {
      
         Player oldValue = this.Artjom;
         this.Artjom = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_ARTJOM )
   public EeroDealsOneRoundTest withArtjom (Player value)
   {
      setArtjom (value);
      return this;
   }

   public Player getArtjom ()
   {
      return this.Artjom;
   }

   /**
    * <pre>
    *           0..1     object_C7     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               C7
    * </pre>
    */
   public static final String PROPERTY_C7 = "C7";

   @Property( name = PROPERTY_C7, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card C7;

   @Property( name = PROPERTY_C7 )
   public boolean setC7 (Card value)
   {
      boolean changed = false;

      if (this.C7 != value)
      {
      
         Card oldValue = this.C7;
         this.C7 = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_C7 )
   public EeroDealsOneRoundTest withC7 (Card value)
   {
      setC7 (value);
      return this;
   }

   public Card getC7 ()
   {
      return this.C7;
   }

   /**
    * <pre>
    *           0..1     object_C8     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               C8
    * </pre>
    */
   public static final String PROPERTY_C8 = "C8";

   @Property( name = PROPERTY_C8, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card C8;

   @Property( name = PROPERTY_C8 )
   public boolean setC8 (Card value)
   {
      boolean changed = false;

      if (this.C8 != value)
      {
      
         Card oldValue = this.C8;
         this.C8 = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_C8 )
   public EeroDealsOneRoundTest withC8 (Card value)
   {
      setC8 (value);
      return this;
   }

   public Card getC8 ()
   {
      return this.C8;
   }

   /**
    * <pre>
    *           0..1     object_CA     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               CA
    * </pre>
    */
   public static final String PROPERTY_CA = "CA";

   @Property( name = PROPERTY_CA, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card CA;

   @Property( name = PROPERTY_CA )
   public boolean setCA (Card value)
   {
      boolean changed = false;

      if (this.CA != value)
      {
      
         Card oldValue = this.CA;
         this.CA = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_CA )
   public EeroDealsOneRoundTest withCA (Card value)
   {
      setCA (value);
      return this;
   }

   public Card getCA ()
   {
      return this.CA;
   }

   /**
    * <pre>
    *           0..1     object_DA     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               DA
    * </pre>
    */
   public static final String PROPERTY_DA = "DA";

   @Property( name = PROPERTY_DA, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card DA;

   @Property( name = PROPERTY_DA )
   public boolean setDA (Card value)
   {
      boolean changed = false;

      if (this.DA != value)
      {
      
         Card oldValue = this.DA;
         this.DA = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DA )
   public EeroDealsOneRoundTest withDA (Card value)
   {
      setDA (value);
      return this;
   }

   public Card getDA ()
   {
      return this.DA;
   }

   /**
    * <pre>
    *           0..1     object_DJ     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               DJ
    * </pre>
    */
   public static final String PROPERTY_DJ = "DJ";

   @Property( name = PROPERTY_DJ, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card DJ;

   @Property( name = PROPERTY_DJ )
   public boolean setDJ (Card value)
   {
      boolean changed = false;

      if (this.DJ != value)
      {
      
         Card oldValue = this.DJ;
         this.DJ = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DJ )
   public EeroDealsOneRoundTest withDJ (Card value)
   {
      setDJ (value);
      return this;
   }

   public Card getDJ ()
   {
      return this.DJ;
   }

   /**
    * <pre>
    *           0..1     object_DK     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               DK
    * </pre>
    */
   public static final String PROPERTY_DK = "DK";

   @Property( name = PROPERTY_DK, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card DK;

   @Property( name = PROPERTY_DK )
   public boolean setDK (Card value)
   {
      boolean changed = false;

      if (this.DK != value)
      {
      
         Card oldValue = this.DK;
         this.DK = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DK )
   public EeroDealsOneRoundTest withDK (Card value)
   {
      setDK (value);
      return this;
   }

   public Card getDK ()
   {
      return this.DK;
   }

   /**
    * <pre>
    *           0..1     object_Dealer     0..1
    * EeroDealsOneRoundTest ------------------------> Dealer
    *           test               Dealer
    * </pre>
    */
   public static final String PROPERTY_DEALER = "Dealer";

   @Property( name = PROPERTY_DEALER, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Dealer Dealer;

   @Property( name = PROPERTY_DEALER )
   public boolean setDealer (Dealer value)
   {
      boolean changed = false;

      if (this.Dealer != value)
      {
      
         Dealer oldValue = this.Dealer;
         this.Dealer = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DEALER )
   public EeroDealsOneRoundTest withDealer (Dealer value)
   {
      setDealer (value);
      return this;
   }

   public Dealer getDealer ()
   {
      return this.Dealer;
   }

   /**
    * <pre>
    *           0..1     object_Deck     0..1
    * EeroDealsOneRoundTest ------------------------> Deck
    *           test               Deck
    * </pre>
    */
   public static final String PROPERTY_DECK = "Deck";

   @Property( name = PROPERTY_DECK, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Deck Deck;

   @Property( name = PROPERTY_DECK )
   public boolean setDeck (Deck value)
   {
      boolean changed = false;

      if (this.Deck != value)
      {
      
         Deck oldValue = this.Deck;
         this.Deck = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_DECK )
   public EeroDealsOneRoundTest withDeck (Deck value)
   {
      setDeck (value);
      return this;
   }

   public Deck getDeck ()
   {
      return this.Deck;
   }

   /**
    * <pre>
    *           0..1     object_Eero     0..1
    * EeroDealsOneRoundTest ------------------------> Player
    *           test               Eero
    * </pre>
    */
   public static final String PROPERTY_EERO = "Eero";

   @Property( name = PROPERTY_EERO, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player Eero;

   @Property( name = PROPERTY_EERO )
   public boolean setEero (Player value)
   {
      boolean changed = false;

      if (this.Eero != value)
      {
      
         Player oldValue = this.Eero;
         this.Eero = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_EERO )
   public EeroDealsOneRoundTest withEero (Player value)
   {
      setEero (value);
      return this;
   }

   public Player getEero ()
   {
      return this.Eero;
   }

   /**
    * <pre>
    *           0..1     object_H10     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               H10
    * </pre>
    */
   public static final String PROPERTY_H10 = "H10";

   @Property( name = PROPERTY_H10, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card H10;

   @Property( name = PROPERTY_H10 )
   public boolean setH10 (Card value)
   {
      boolean changed = false;

      if (this.H10 != value)
      {
      
         Card oldValue = this.H10;
         this.H10 = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_H10 )
   public EeroDealsOneRoundTest withH10 (Card value)
   {
      setH10 (value);
      return this;
   }

   public Card getH10 ()
   {
      return this.H10;
   }

   /**
    * <pre>
    *           0..1     object_H7     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               H7
    * </pre>
    */
   public static final String PROPERTY_H7 = "H7";

   @Property( name = PROPERTY_H7, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card H7;

   @Property( name = PROPERTY_H7 )
   public boolean setH7 (Card value)
   {
      boolean changed = false;

      if (this.H7 != value)
      {
      
         Card oldValue = this.H7;
         this.H7 = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_H7 )
   public EeroDealsOneRoundTest withH7 (Card value)
   {
      setH7 (value);
      return this;
   }

   public Card getH7 ()
   {
      return this.H7;
   }

   /**
    * <pre>
    *           0..1     object_HA     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               HA
    * </pre>
    */
   public static final String PROPERTY_HA = "HA";

   @Property( name = PROPERTY_HA, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card HA;

   @Property( name = PROPERTY_HA )
   public boolean setHA (Card value)
   {
      boolean changed = false;

      if (this.HA != value)
      {
      
         Card oldValue = this.HA;
         this.HA = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_HA )
   public EeroDealsOneRoundTest withHA (Card value)
   {
      setHA (value);
      return this;
   }

   public Card getHA ()
   {
      return this.HA;
   }

   /**
    * <pre>
    *           0..1     object_HJ     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               HJ
    * </pre>
    */
   public static final String PROPERTY_HJ = "HJ";

   @Property( name = PROPERTY_HJ, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card HJ;

   @Property( name = PROPERTY_HJ )
   public boolean setHJ (Card value)
   {
      boolean changed = false;

      if (this.HJ != value)
      {
      
         Card oldValue = this.HJ;
         this.HJ = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_HJ )
   public EeroDealsOneRoundTest withHJ (Card value)
   {
      setHJ (value);
      return this;
   }

   public Card getHJ ()
   {
      return this.HJ;
   }

   /**
    * <pre>
    *           0..1     object_HK     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               HK
    * </pre>
    */
   public static final String PROPERTY_HK = "HK";

   @Property( name = PROPERTY_HK, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card HK;

   @Property( name = PROPERTY_HK )
   public boolean setHK (Card value)
   {
      boolean changed = false;

      if (this.HK != value)
      {
      
         Card oldValue = this.HK;
         this.HK = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_HK )
   public EeroDealsOneRoundTest withHK (Card value)
   {
      setHK (value);
      return this;
   }

   public Card getHK ()
   {
      return this.HK;
   }

   /**
    * <pre>
    *           0..1     object_HQ     0..1
    * EeroDealsOneRoundTest ------------------------> Card
    *           test               HQ
    * </pre>
    */
   public static final String PROPERTY_HQ = "HQ";

   @Property( name = PROPERTY_HQ, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Card HQ;

   @Property( name = PROPERTY_HQ )
   public boolean setHQ (Card value)
   {
      boolean changed = false;

      if (this.HQ != value)
      {
      
         Card oldValue = this.HQ;
         this.HQ = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_HQ )
   public EeroDealsOneRoundTest withHQ (Card value)
   {
      setHQ (value);
      return this;
   }

   public Card getHQ ()
   {
      return this.HQ;
   }

   /**
    * <pre>
    *           0..1     object_Ulno     0..1
    * EeroDealsOneRoundTest ------------------------> Player
    *           test               Ulno
    * </pre>
    */
   public static final String PROPERTY_ULNO = "Ulno";

   @Property( name = PROPERTY_ULNO, kind = ReferenceHandler.ReferenceKind.TO_ONE,
         adornment = ReferenceHandler.Adornment.NONE)
   private Player Ulno;

   @Property( name = PROPERTY_ULNO )
   public boolean setUlno (Player value)
   {
      boolean changed = false;

      if (this.Ulno != value)
      {
      
         Player oldValue = this.Ulno;
         this.Ulno = value;
         changed = true;
      
      }
      return changed;
   }

   @Property( name = PROPERTY_ULNO )
   public EeroDealsOneRoundTest withUlno (Player value)
   {
      setUlno (value);
      return this;
   }

   public Player getUlno ()
   {
      return this.Ulno;
   }

   public void setUp ()
   {
      boolean fujaba__Success = false;
      Player Eero = null;
      Player Ulno = null;
      Dealer Dealer = null;
      Player Artjom = null;
      Deck Deck = null;
      Card C8 = null;
      Card C7 = null;
      Card H7 = null;
      Card HA = null;
      Card CA = null;
      Card H10 = null;
      Card DA = null;
      Card DJ = null;
      Card HJ = null;
      Card HQ = null;
      Card HK = null;
      Card DK = null;

      // story pattern 
      try 
      {
         fujaba__Success = false; 

         // create object Eero
         Eero = new Player ( );

         // create object Ulno
         Ulno = new Player ( );

         // create object Dealer
         Dealer = new Dealer ( );

         // create object Artjom
         Artjom = new Player ( );

         // create object Deck
         Deck = new Deck ( );

         // create object C8
         C8 = new Card ( );

         // create object C7
         C7 = new Card ( );

         // create object H7
         H7 = new Card ( );

         // create object HA
         HA = new Card ( );

         // create object CA
         CA = new Card ( );

         // create object H10
         H10 = new Card ( );

         // create object DA
         DA = new Card ( );

         // create object DJ
         DJ = new Card ( );

         // create object HJ
         HJ = new Card ( );

         // create object HQ
         HQ = new Card ( );

         // create object HK
         HK = new Card ( );

         // create object DK
         DK = new Card ( );

         // create link right of from Ulno to Eero
         Ulno.setPlayer (Eero);

         // create link is from Dealer to Eero
         Dealer.setPlayer (Eero);

         // create link right of from Artjom to Eero
         Artjom.setPlayer (Eero);

         // create link object_Eero from this to Eero
         this.setEero (Eero);

         // create link right of from Ulno to Artjom
         Ulno.setPlayer (Artjom);

         // create link object_Artjom from this to Artjom
         this.setArtjom (Artjom);

         // create link object_Ulno from this to Ulno
         this.setUlno (Ulno);

         // create link on top from C8 to Deck
         C8.setDeck (Deck);

         // create link object_Deck from this to Deck
         this.setDeck (Deck);

         // create link on top of from C7 to C8
         C7.setCard (C8);

         // create link object_C8 from this to C8
         this.setC8 (C8);

         // create link on top of from H7 to C7
         H7.setCard (C7);

         // create link object_C7 from this to C7
         this.setC7 (C7);

         // create link on top of from HA to H7
         HA.setCard (H7);

         // create link object_H7 from this to H7
         this.setH7 (H7);

         // create link on top of from CA to HA
         CA.setCard (HA);

         // create link object_HA from this to HA
         this.setHA (HA);

         // create link on top of from H10 to CA
         H10.setCard (CA);

         // create link object_CA from this to CA
         this.setCA (CA);

         // create link on top of from DA to H10
         DA.setCard (H10);

         // create link object_H10 from this to H10
         this.setH10 (H10);

         // create link on top of from DJ to DA
         DJ.setCard (DA);

         // create link object_DA from this to DA
         this.setDA (DA);

         // create link on top of from HJ to DJ
         HJ.setCard (DJ);

         // create link object_DJ from this to DJ
         this.setDJ (DJ);

         // create link on top of from HQ to HJ
         HQ.setCard (HJ);

         // create link object_HJ from this to HJ
         this.setHJ (HJ);

         // create link on top of from HK to HQ
         HK.setCard (HQ);

         // create link object_HQ from this to HQ
         this.setHQ (HQ);

         // create link on top of from DK to HK
         DK.setCard (HK);

         // create link object_HK from this to HK
         this.setHK (HK);

         // create link object_DK from this to DK
         this.setDK (DK);

         // create link object_Dealer from this to Dealer
         this.setDealer (Dealer);

         fujaba__Success = true;
      }
      catch ( JavaSDMException fujaba__InternalException )
      {
         fujaba__Success = false;
      }

   }

   public void testEeroDealsOneRound ()
   {
      boolean fujaba__Success = false;

      // assert result situation
   }

   public void removeYou()
   {
      this.setArtjom (null);
      this.setC7 (null);
      this.setC8 (null);
      this.setCA (null);
      this.setDA (null);
      this.setDJ (null);
      this.setDK (null);
      this.setDealer (null);
      this.setDeck (null);
      this.setEero (null);
      this.setH10 (null);
      this.setH7 (null);
      this.setHA (null);
      this.setHJ (null);
      this.setHK (null);
      this.setHQ (null);
      this.setUlno (null);
   }
}


