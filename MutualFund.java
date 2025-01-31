/**
 * Class MutualFunds
 * 
 * Purpose: Receive user input regarding stock Mutual Fund accounts and returns information 
 *          relevant to the customer and Mutual Funds account.
 * 
 * Programmer: Dontez Wherry
 * Course: IS 2043
 */

public class MutualFund extends Security 
{  
  // instance variables
  private String type = ""; // Identifies general type of Mutual Fund: bonds, money market, exchange, etc.
  private double admin = 0.0; /* Administrative fee cap, expressed as a percentage of value of 
                               * funds held (e.g.: 0.0024 or 0.03)
                               */
  private char rptPeriod = ' '; /* Reporting period, expressed as character. The valid values are:
                                 * A: annual
                                 * Q: quarterly
                                 * M: monthly
                                 */
  private boolean mgmt = false; /* Describes whether or not the fund is "actively managed": 
                                 * true = active; false = passive management
                                 */
  
  
  // Full constructor; returns a reference to a fully formed and functional MutualFund object
  public MutualFund(String nbr, int date, double price, double qty, String sym, String sort,
                    double cost, char rpt, boolean style)
  {
    super(nbr, date, price, qty, sym); // call to superclass Security constructor
    setType(sort); // sets the type object
    setAdmin(cost); // sets the cost object
    setRptPeriod(rpt); // sets the rptPeriod object
    setMgmt(style); // sets the mgmt object
    
  }// end constructor MutualFund
        
  
  // setter methods
  
  // Accepts a String object and assigns it to the instances variable sort
  public final void setType(String sort)
  {
    this.type = sort; 
  }// end method setType
  
  // Accepts a double object and assigns it to the instances variable admin
  public final void setAdmin(double cost)
  {
    this.admin = cost;
  }// end method setAdmin
  
  // Accepts a char object and assigns it to the instances variable rptPeriod
  public final void setRptPeriod(char rpt)
  {
    this.rptPeriod = rpt;
  }// end method setRptPeriod
  
  // Accepts a boolean object and assigns it to the instances variable mgmt
  public final void setMgmt(boolean style)
  {
    this.mgmt = style; 
  }// end method setMgmt
  
  
  // getter methods
  
  // Returns the current value of instance variable type
  public final String getType()
  {
    return type;
  }// end method getType
  
  // Returns the current value of instance variable admin
  public final double getAdmin()
  {
    return admin/100;
  }// end method getAdmin
  
  // Returns the current value of instance variable rptPeriod
  public final String getRptPeriod()
  {    
    String rptValue = ""; // holds String value for reporting period 
    
    // receives char and returns a String value representing the reporting period
    switch(rptPeriod) 
    {
      case 'A': 
        rptValue = "Annual"; //annual reporting period 
        break; 
      case 'Q': 
        rptValue = "Quarterly"; //quarterly reporting period
        break;
      case 'M': 
        rptValue = "Monthly"; // monthly reporting period
        break;        
    }// end Switch    
    
       return rptValue; 
  }// end method getRptPeriod
  
  // Returns the current value of instance variable mgmt
  public final String getMgmt()
  {
    // Returns management style for Mutual Funds accounts
    if (mgmt == true) 
    {
      return "actively";
    }
    else 
    {
      return "passively";
    }
        
  }// end method getMgmt
  
  
  // toString method returns a formatted String object describing the MutualFund object
  public String toString()
  {
    return String.format("%nThe %s belongs to Customer# %s; %.3f shares of %s were%n" +
                         "purchased on %d for $%.2f per share.%n" +
                         "This is a %s fund.%n" +
                         "\tAdmin cost are capped at %.6f.%n" +
                         "\tReporting cycle is %s.%n" +
                         "\tThe fund is managed %s.%n",                         
                         getClass().getName(), getCustNumber(), getShares(), getSymbol(),
                         getPurchDt(), getPurchPrc(), getType(), getAdmin(), getRptPeriod(), 
                         getMgmt(), getRptPeriod(), getMgmt()); 
                           
  }// end method toString
  
  
  // concrete implementation of interface method: CostBasis
  public double calcCost()
  {
    return (getShares() * getPurchPrc()) * (1 + getAdmin());
  }// end method calcCost

  
}// end class MutualFund
