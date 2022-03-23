package javacontroller;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CRUD_Implement implements CRUD_Controller{

    private JdbcTemplate template;

    public CRUD_Implement(DataSource dataSource){
        template = new JdbcTemplate(dataSource);
    }
    @Override
    public void CreateAccount(Account account) {
        if(account.get__id_account()<0){
            String SQL_Query = "Insert into Account_user(__id_account, username_account, email_account, password_account)" +
                    " values(?,?,?,?)";
            template.update(SQL_Query,account.get__id_account(),account.getUsername_account()
                    ,account.getEmail_account(),account.getPassword_account());
        }else{
            return;
        }
    }

    @Override
    public List<Account> ReadAccount() {
        String SQL_Query = "Select *  from Account_user";
        List<Account> list = template.query(SQL_Query, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account account = new Account();
                account.set__id_account(rs.getInt("__id_account"));
                account.setUsername_account(rs.getString("username_account"));
                account.setEmail_account(rs.getString("email_account"));
                account.setPassword_account(rs.getString("password_account"));
                return account;
            }
        });
        return list;
    }

    @Override
    public void UpdateAccount(Account account) {
        if(account.get__id_account()>0){
            String SQL_Query = "Update Account_user set username_account=?, email_account=?";
            template.update(SQL_Query, account.getUsername_account(),account.getEmail_account());
        }else{
            String SQL_Query = "Insert into Account_user(__id_account, username_account, email_account, password_account)" +
                    " values(?,?,?,?)";
            template.update(SQL_Query,account.get__id_account(),account.getUsername_account()
                    ,account.getEmail_account(),account.getPassword_account());
        }
    }

    @Override
    public void DeleteAccount(int __id_account) {
        String SQL_Query = "Delete from Account_user where __id_account = ?";
        template.update(SQL_Query);
    }

    @Override
    public Account GetOneAccount(int __id_account) {
        String SQL_Query = "Select *  from Account_user where __id_account = " + __id_account;

        return template.query(SQL_Query, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
                Account account = new Account();
                account.set__id_account(rs.getInt("__id_account"));
                account.setUsername_account(rs.getString("username_account"));
                account.setEmail_account(rs.getString("email_account"));
                account.setPassword_account(rs.getString("password_account"));
                return account;
            }
        });
    }
}
