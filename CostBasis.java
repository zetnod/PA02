/**
 * Interface CostBasis
 * 
 * Purpose: The interface will be used in the classes of the Security hierarchy 
 *          to calculate the cost basis for a given investment.
 * 
 * Programmer: Dontez Wherry
 * Course: IS 2043
 */

public interface CostBasis {
  
  //Returns the cost basis for the security.
  public double calcCost(); 
  
}// end interface CostBasis
