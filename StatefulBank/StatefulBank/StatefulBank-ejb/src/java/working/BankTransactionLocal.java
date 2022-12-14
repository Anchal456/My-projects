/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package working;

import javax.ejb.Local;

@Local
public interface BankTransactionLocal {

    int deposit(int amount);

    int withdraw(int amount);

    int getbal();
    
}
