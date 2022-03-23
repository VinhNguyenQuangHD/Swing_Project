package javacontroller;

import java.util.List;

public interface CRUD_Controller {
    public void CreateAccount(Account account);
    public List<Account> ReadAccount();
    public void UpdateAccount(Account account);
    public void DeleteAccount(int __id_account);
    public Account GetOneAccount(int __id_account);

}
