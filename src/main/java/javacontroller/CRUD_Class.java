package javacontroller;

import java.util.List;

public interface CRUD_Class {
    public Account Create(int __id_account);
    public List<Account> Read();
    public void Update(Account account);
    public void Delete(int __id_account);
}
