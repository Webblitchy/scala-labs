package Data

import scala.collection.mutable

trait AccountService:
  /**
    * Retrieve the balance of a given account
    * @param user the name of the user whose account will be retrieve
    * @return the current balance of the user
    */
  def getAccountBalance(user: String): Double

  /**
    * Add an account to the existing accounts
    * @param user the name of the user
    * @param balance the initial balance value
    */
  def addAccount(user: String, balance: Double): Unit

  /**
    * Indicate is an account exist
    * @param user the name of the user whose account is checked to exist
    * @return whether the account exists or not
    */
  def isAccountExisting(user: String): Boolean

  /**
    * Update an account by decreasing its balance.
    * @param user the name of the user whose account will be updated
    * @param amount the amount to decrease
    * @return the new balance
    */
  def purchase(user: String, amount: Double): Double

class AccountImpl extends AccountService:
  // DONE - Part 2 Step 2
  val map = synchronized{ mutable.Map[String, Double]()}
  def getAccountBalance(user: String): Double = 
    synchronized {map.getOrElse(user, 0.0)}
  def addAccount(user: String, balance: Double): Unit = 
    synchronized{ if !isAccountExisting(user) then 
      map.put(user, balance)}
  def isAccountExisting(user: String): Boolean = 
    synchronized{map.contains(user)}
  def purchase(user: String, amount: Double): Double = 
    synchronized {
      if isAccountExisting(user) && getAccountBalance(user) >= amount then 
        val new_amount = getAccountBalance(user)-amount;
        map.put(user,  new_amount);
        new_amount
      else
        0.0
    }
    
end AccountImpl
