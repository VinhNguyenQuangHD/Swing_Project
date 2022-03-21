package javacontroller;

import org.hibernate.exception.DataException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Account_CRUD_imp implements CRUD_Class{

    private JdbcTemplate template;

    public Account_CRUD_imp(DataSource dataSource){
        template = new JdbcTemplate();
    }

    @Override
    public Account Create(int __id_account) {
        String MySQL_query = "select * from account where __id_account=" + __id_account;

        return template.query(MySQL_query, new ResultSetExtractor<Account>() {
            @Override
            public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
               if(rs.next()){
                   Account query_account = new Account();

                   query_account.set__id_account(rs.getInt("__id_account"));
                   query_account.setUsername_account(rs.getString("username_account"));
                   query_account.setEmail_account(rs.getString("email_account"));
                   query_account.setPassword_account(rs.getString("password_account"));
                   return query_account;
               }
                return null;
            }
        });
    }

    @Override
    public List<Account> Read() {
        String MySQL_query = "select * from account";
        List<Account> view_all_account = template.query(MySQL_query, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
                Account query_account = new Account();

                query_account.set__id_account(rs.getInt("__id_account"));
                query_account.setUsername_account(rs.getString("username_account"));
                query_account.setEmail_account(rs.getString("email_account"));
                query_account.setPassword_account(rs.getString("password_account"));
                return query_account;
            }
        });
        return view_all_account;
    }

    @Override
    public void Update(Account account) {
        if(account.get__id_account() >0){
            String MySQL_query = "update account set username_account =?, where __id_account=?";
            template.update(MySQL_query,account.getUsername_account());
        }
    }

    @Override
    public void Delete(int __id_account) {
        String MySQL_query = "delete from account where __id_account=?";
    }
}
