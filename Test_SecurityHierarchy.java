/**
 * This is a SIMPLE test harness for the Security class.
 * 
 * Keyboard input is accepted from the user and then used to instantiate a Security object.
 *   Once an object has been instantiated, it will be stored in an array.
 *   An enhanced for loop will then be used to output information about all objects in the array.
 */

import java.util.Scanner;                                      // to accept keboard input

public class Test_SecurityHierarchy 
{
  private static int        limit     = 2;
  private static Security[] custArray = new Security[ limit ]; // declared globally for simplicity
    
  public static void main(String[] args) 
  { 
    loadArray( );
    outputSecuritys( );    
  }  // end main
  
  private static void loadArray( )
  {
    /************************************************************************************************************
     *  The first part of this method is simply 'set up' for the real work to be done later.
     *   We will:
     *      > Instantiate the Scanner here to accept keyboard input
     *      > Create a 'holding' space for the Security object(s) to be isntantiated
     *      > Declare variables to hold the user responses
     *      > Declare a variable to use in controlling the input loop
     ************************************************************************************************************/
    Scanner input = new Scanner( System.in );                  // instantiate Scanner for use; tie to keyboard
    
    Security newSecurity;                                      // "holding reference" for the Security object
                                                               // Both Stock AND MutualFund objects 'fit' here
    
    /*
     *  Create prompts for use in input loop
     */
    // Aks what type of object
    String askObjType     = "Do you wish to enter a Stock (1) or a MutualFund (2) ?: ";
    
    // Security-level prompts  (for SUPERclass instance values)
    String askCustNumber  = "Enter a Customer Number as 7 digits: ";
    String askPurchDt     = "Enter a purchase date in yyyyddd (Julian) format: ";
    String askPurchPrc    = "Enter the purchase price per share: ";
    String askShares      = "Enter the number of shares purchased: ";
    String askSymbol      = "Enter the symbol for the Security: ";
    
    // MutualFund prompts      (for SUBclass instance values)
    String askType        = "What type of Mutual Fund is this?: ";
    String askAdmin       = "What is the administrative cost cap? Enter as cents per dollar: ";
    String askRptPeriod   = "What is the reporting Period? Enter A (annual), Q (quarterly), or M (monthly): ";
    String askMgmt        = "Is this fund actively (true) or passively (false) managed?: ";
    
    // Stock prompts           (for SUBclass instance values)
    String askExchg       = "On which exchange is this Stock traded?: ";
    String askDividends   = "Does this Stock pay dividends? (true or false): ";
    String askDivDate     = "In which quarter are dividends paid? Enter 0 if no dividends: ";
    String askDivAmount   = "What is the expectged dividend per share? Enter 0 if no dividends: ";
    
    
    /*
     *  Declare variables to hold the user responses
    */
    // to hold SUPERclass instance values
    String  custNumber;
    int     purchDt;
    double  purchPrc;
    double  shares;
    String  symbol;
    //==================
    // to hold MutualFund SUBclass instance values
    String  type;
    double  admin;
    char    rptPeriod;
    boolean mgmt;
    //==================
    // to hold Stock SUBclass instance values
    String  exchange;
    boolean dividends;
    int     divDate;
    double  divAmount;
    
    // Declare a variable to test type of object
    int  objType = 0;
    
    // Declare a loop control variable
    int countObjects = 0;
    

    /************************************************************************************************************
     *  The data input loop will continue until the array has been filled.
     *  
     *  Each prompt is offered in turn; the response from the user is stored in the appropriate variable
     ************************************************************************************************************/
    while( countObjects < limit )
    {
      // Collect the basic Security level information
      System.out.printf( "%s%n", askCustNumber );
      custNumber = input.next( );
      System.out.printf( "%s%n", askPurchDt );
      purchDt    = input.nextInt( ); input.nextLine( );
      System.out.printf( "%s%n", askPurchPrc );
      purchPrc   = input.nextDouble( ); input.nextLine( );
      System.out.printf( "%s%n", askShares );
      shares     = input.nextDouble( ); input.nextLine( );
      System.out.printf( "%s%n", askSymbol );
      symbol     = input.next( );
    
      
      // Ask what type of object
      System.out.printf( "%s%n", askObjType );
      objType = input.nextInt( ); input.nextLine( );
      
      if( objType == 1)
      {
        System.out.printf( "%s%n", askExchg );
        exchange      = input.next( );
        System.out.printf( "%s%n", askDividends );
        dividends     = input.nextBoolean( ); 
        System.out.printf( "%s%n", askDivDate);
        divDate       = input.nextInt( ); input.nextLine( );
        System.out.printf( "%s%n", askDivAmount );
        divAmount     = input.nextDouble( ); input.nextLine( );
        
        newSecurity = new Stock( custNumber,
                                 purchDt,
                                 purchPrc,
                                 shares,
                                 symbol,
                                 exchange,
                                 dividends,
                                 divDate,
                                 divAmount );
        
      }  // end Stock
      else
      {
        System.out.printf( "%s%n", askType );
        type          = input.next( );
        System.out.printf( "%s%n", askAdmin );
        admin         = input.nextDouble( ); input.nextLine( );
        System.out.printf( "%s%n", askRptPeriod );
        rptPeriod     = input.next( ).charAt( 0 );
        System.out.printf( "%s%n", askMgmt );
        mgmt          = input.nextBoolean( );
        
        newSecurity = new MutualFund( custNumber,
                                      purchDt,
                                      purchPrc,
                                      shares,
                                      symbol,
                                      type,
                                      admin,
                                      rptPeriod,
                                      mgmt );
        
      }  // end MutualFund
      
            
      /*
       *  Add newly instantiated object (Stock OR MutualFund) to the array
       */
      custArray[ countObjects ] = newSecurity;
      countObjects += 1;      
    } // end of loop
    
    // Reflect to user that loop has ended
    System.out.printf( "%nData input complete. Thank you.%n" );
    
  } // end loadArray
  
  private static void outputSecuritys( )
  {
    /************************************************************************************************************
     *  An ENHANCED FOR LOOP is used to process each object in the array.
     *     The toString method of each object is called; the return value is then output to the console.
     ************************************************************************************************************/

    for( Security someone: custArray )
    {
      System.out.printf( "%s",
                          someone.toString( ) );
      System.out.printf( "The cost basis for this investment is: $%,.2f%n",
                         someone.calcCost( ) );
    }
  } // end outputSecuritys
    
}  // end Test_SecurityHierarchy