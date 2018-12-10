//import static test.Tables.*;
import org.jooq.impl.DSL.*;

import java.sql.*;
import org.jooq.*;
import org.jooq.impl.*;
public class JooqTest {

        public static void main(String[] args) {
            String userName = "sa";
            String password = "";
            String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";

            try (Connection conn = DriverManager.getConnection(url, userName, password)) {
                DSLContext create = DSL.using(conn, SQLDialect.H2);
                Result<Record> result = create.select().from(City).fetch();

                for (Record r : result) {
                    Integer id = r.getValue(City.ID);
                    String firstName = r.getValue(City.FIRST_NAME);
                    String lastName = r.getValue(City.LAST_NAME);

                    System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
                }
            }

            // For the sake of this tutorial, let's keep exception handling simple
            catch (Exception e) {
                e.printStackTrace();
            }
        }
}
