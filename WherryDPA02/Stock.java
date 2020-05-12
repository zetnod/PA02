/**
 * Class Stock
 * 
 * Purpose: Receive user input regarding stock investment accounts and returns
 *          relevant customer and stock account information.
 * 
 * Programmer: Dontez Wherry
 * Course: IS 2043
 */

public class Stock extends Security
{  
  // instance variables
  private String exchange = ""; // The exchange on which the stock trades (e.g.: NASDAQ, Nikkei, etc.)
  private boolean dividends = false; /* Indicates whether or not the stock pays dvidends: 
                                      * true = dividends paid; false = no dividends paid 
                                      */
  private int divDate; /* Indicates when dividends are paid by quarter; 
                        * allowed values are 0 (if dividends = false) through 4  
                        */
  private double divAmount = 0.0; /* Dollar value of dividents/share; 
                                   * 0 if dividends = false and/or divDate is invalid
                                   */
  
  
  // Full constructor; returns a reference to a fully formed and functional Stock object
  public Stock (String nbr, int date, double prc, double qty, String sym, String xchg, 
                     boolean div, int divDt, double amt)
  {
    super(nbr, date, prc, qty, sym); // call to superclass Security constructor
    setExchange(xchg); // sets the exchange object
    setDividends(div); // sets the dividend object
    setDivDate(divDt); // sets the divDate object
    setDivAmount(amt); // sets the divAmount object
  }// end constructor MutualFund
  
  
  // setter methods
  
  // Accepts a String object and assigns it to the instances variable exchange
  public final void setExchange(String xchg)
  {
    this.exchange = xchg;
  }// end method setExchange
  
  // Accepts a boolean object and assigns it to the instances variable dividends
  public final void setDividends(boolean div)
  {
    this.dividends = div;
  }// end method setDividends
  
  // Accepts an int object and assigns it to the instances variable divDate
  public final void setDivDate(int divDt)
  {
    this.divDate = divDt;
  }// end method setDivDate
  
  // Accepts a double object and assigns it to the instances variable divAmount
  public final void setDivAmount(double amt)
  {
    this.divAmount = amt; 
  }// end method setDivAmount
  
  
  //getter methods
  
  // Returns the current value of instance variable exchange
  public final String getExchange()
  {
    return exchange;
  }// end method getExhange
  
  // Returns the current value of instance variable dividends
  public final boolean getDividends()
  {
    return dividends; 
  }// end method getDividends
  
  // Returns the current value of instance variable divDate
  public final int getDivDate()
  {
    return divDate;
  }// end method getDivDate
  
  // Returns the current value of instance variable divAmount
  public final double getDivAmount()
  {
    // returns the dividend payment cycle if dividends are paid
    if (dividends == false || divDate > 4) 
    {
      return 0; 
    }// end if
    else 
    {
      return divAmount;   
    }// end else
  }// end method getDivAmount
  
  
  // toString method: Returns a formatted String object describing this Stock object:
  public String toString()
  {
    if(getDividends() == true) 
    {
      return String.format("%nThe %s belongs to Customer# %s; %.3f shares of %s were purchased%n" +
                           "on %d for $%.2f per share.%n" +
                           "This %s is traded on the %s exchange.%n" +
                           "\tA dividend of $%.2f will be paid in the %s quarter.%n", 
                         getClass().getName(), getCustNumber(), getShares(), getSymbol(), getPurchDt(),
                         getPurchPrc(), getClass().getName(), getExchange(), getDivAmount(), getDivDate());
    }// end if
    else
    {
      return String.format("%nThe %s belongs to Customer# %s; %.3f shares of %s were purchased%n" +
                           "on %d for $%.2f per share.%n" +
                           "This %s is traded on the %s exchange.%n" +
                           "\tThis %s does not pay a dividend.%n",
                         getClass().getName(), getCustNumber(), getShares(), getSymbol(), getPurchDt(),
                         getPurchPrc(), getClass().getName(), getExchange(), getClass().getName());
                         
    }// end else
    
  }// end method toString
  
  
  // concrete implementation of interface method: CostBasis
  public double calcCost()
  {
    return (getShares() * (getPurchPrc() - divAmount)); 
  }// end method calcCost
  
}// end class Stock
