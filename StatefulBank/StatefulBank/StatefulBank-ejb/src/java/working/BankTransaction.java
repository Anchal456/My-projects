/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package working;
import javax.ejb.Stateful;
@Stateful
public class BankTransaction implements BankTransactionLocal {
    int bal = 500;
    @Override
    public int deposit(int amount) {
        bal = bal + amount;
        return bal;
    }

    @Override
    public int withdraw(int amount) {
        bal =  bal - amount;
        return bal;
    }

    @Override
    public int getbal() {
        return bal;
    }
    
}