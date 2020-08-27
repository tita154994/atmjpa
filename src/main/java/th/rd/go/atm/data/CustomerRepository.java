package th.rd.go.atm.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import th.rd.go.atm.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

//
//public class CustomerRepository implements JdbcRepository {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public CustomerRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public List<Customer> findAll() {
//        String query = "SELECT * FROM customer";
//        List<Customer> customers =
//                jdbcTemplate.query(query, new CustomerMapper());
//        return customers;
//
//        //return null;
//
//    }
//
//    @Override
//    public Customer findById(int id) {
//        String query = "SELECT * FROM customer WHERE id = " + id;
//        Customer customer =
//                jdbcTemplate.queryForObject(query, new CustomerMapper());
//        return customer;
//
//    }
//
//    @Override
//    public void save(Customer customer) {
//        String query = "INSERT INTO customer (id,name,pin) VALUES (?,?,?);";
//        Object[] data = new Object[]
//                { customer.getId(), customer.getName(), customer.getPin() };
//        jdbcTemplate.update(query, data);
//
//    }
//
//    @Override
//    public void update(int id, Customer customer) {
////        String query = "UPDATE customer (id,name,pin) VALUES (?,?,?);";
////        Object[] data = new Object[]
////                { customer.getId(), customer.getName(), customer.getPin() };
////        jdbcTemplate.update(query, data);
//   }
//
//    @Override
//    public void deleteById(int id) {
//        String query = "Delete FROM customer WHERE id = ?";
//        Object[] data = new Object[]
//                {id};
//        jdbcTemplate.update(query, data);
//
//
//    }
//
//    class CustomerMapper implements RowMapper<Customer> {
//
//        @Override
//        public Customer mapRow(ResultSet resultSet, int i)
//                throws SQLException {
//
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            String pin = resultSet.getString("pin");
//
//            Customer customer = new Customer(id, name, pin);
//            return customer;
//        }
//    }
//
//
//}