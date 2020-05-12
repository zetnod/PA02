/**
 * Abstract class Security
 * 
 * Purpose: Receive user input regarding investment accounts and returns information 
 *          relevant to the customer and security accounts.
 * 
 * Programmer: Dontez Wherry
 * Course: IS 2043
 */

public abstract class Security implements CostBasis
{
  // instance variables 
  private String custNumber = ""; /* A unique identifier for a customer; must be 7 digits in length; 
                                   * must be greater than 10000
                                   */
  private int purchDt; /* Purchase date of Security in Julian date format: yyyyddd. 
                        * The value for year must be greater than 1900. The value for days must be between 
                        * 1 and 365, inclusive
                        */
  private double purchPrc = 0.0; // Purchase price of Security, per share, in dollars
  private double shares = 0.0; /* Number of shares purchased; for display purposed, 
                                * decimal positions should be limited to three (3)
                                */
  private String symbol = ""; // Market symbol of Security
  
  
  // Full constructor; returns a reference to a fully formed and functional Security object
  public Security (String nbr, int date, double price, double qty, String sym)
  {
    setCustNumber(nbr); // sets the customer number object
    setPurchDt(date); // sets the purchase date object
    setPurchPrc(price); // sets the purchase price object
    setShares(qty); // sets the # of shares object
    setSymbol(sym); // sets the security symbol object
  }
  
  // setter methods
  
  // Accepts a String object and assigns it to the instances variable custName
  public final void setCustNumber(String nbr)
  {
    this.custNumber = nbr;
  }// end method setCustNumber
  
  // Accepts an int object and assigns it to the instances variable purchDt 
  public final void setPurchDt(int date)
  {
    this.purchDt = date;
  }// end method setPurchDt
  
  // Accepts a double object and assigns it to the instances variable purchPrc
  public final void setPurchPrc(double price)
  {
    this.purchPrc = price; 
  }// end method setPurchPrc
  
  // Accepts a double object and assigns it to the instances variable shares
  public final void setShares(double qty)
  {
    this.shares = qty; 
  }// end method setShares
  
  // Accepts a String object and assigns it to the instances variable symbol
  public final void setSymbol(String sym)
  {
    this.symbol = sym; 
  }// end method setSymbol
  
  
  //getter methods
  
  // Returns the current value of instance variable custNumber
  public final String getCustNumber()
  {
    return custNumber;
  }// end method getCustNumber
  
  // Returns the current value of instance variable purchDt
  public final int getPurchDt()
  {
    return purchDt;
  }// end method getPurchDt
  
  // Returns the current value of instance variable purchPrc
  public final double getPurchPrc()
  {
    return purchPrc;
  }// end method getPurchPrc
  
  // Returns the current value of instance variable shares
  public final double getShares()
  {
    return shares;
  }// end method getShares
  
  // Returns the current value of instance variable symbol
  public final String getSymbol()
  {
    return symbol;
  }// end method getSymbol
  
  
  /* Returns a formatted String object describing the Security object:  The Security belongs to Customer# 
   * custNumber; shares shares of symbol were purchased on purchDt for $purchPrc per share
   */   
  public String toString()
  {
    return String.format("%nThe %s belongs to Customer# %s; %.3f shares of %s were %n" +
                         "purchased on %d for $%.2f per share.", getClass().getName(), getCustNumber(), 
                          getShares(), getSymbol(), getPurchDt(), getPurchPrc());
                         
  }// end method toString
  
}// end abstract class Security 
