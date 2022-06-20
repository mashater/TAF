package tests.db;

import dbEntities.Customer;
import dbEntities.CustomersTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import services.CustomerService;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class dbTest extends BaseDBTest{
    Logger logger = LoggerFactory.getLogger(DataBaseService.class);
    @Test
    public void firstTest() {
        logger.info("Test is started...");

        ResultSet rs = customersTable.getCustomers(); // вывожу таблицу

        try {
            while (rs.next()) { // переход на следуюшую стр boolean значение
                String userid = rs.getString("ID");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                logger.info("userid: " + userid);
                logger.info("firstname: " + firstName);
                logger.info("lastname: " + lastName);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }
    @Test
    public void customerByIdTest() {
        logger.info("Test is started...");

        ResultSet rs = customersTable.getCustomerById(2); // вывожу 2ого из табл

        try {
            while (rs.next()) { // переход на следуюшую стр boolean значение
                String userid = rs.getString("ID");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt("age");

                logger.info("userid: " + userid);
                logger.info("firstname: " + firstName);
                logger.info("lastname: " + lastName);
                logger.info("email: " + email);
                logger.info("age: " + age);
            }
        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }

    @Test
    public void hibernateTest(){
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Gleb", "Zhiglov", "military@gmail.com", 44);
        customerService.saveUser(customer);

        List <Customer> customerList = customerService.findAllUsers();
        for (Customer cust: customerList){
            logger.info(cust.toString());
        }
    }
}

