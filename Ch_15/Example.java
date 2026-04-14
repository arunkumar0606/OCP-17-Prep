package Ch_15;

public class Example {
    public static void main(String[] args) {
        /*
        2 ways to connect to DB
        1)JDBC
        2)JPA
         */
        /*
        JDBC main classes :
        Driver: Establishes a connection to the database
        Connection: Sends commands to a database
        PreparedStatement: Executes a SQL query
        CallableStatement: Executes commands stored in the database
        ResultSet: Reads the results of a query
         */

        /*
        PreparedStatement requires sql query as mandatory parameter
        executeUpdate() -> It returns the number of rows that were inserted, deleted, or changed.
        executeQuery() -> returns resultSet
        execute() -> we can get both updatecount and resultset

         */

        //For dynamic params - it always starts with 1
//        var sql = "INSERT INTO names VALUES(?, ?, ?)";
//        try (var ps = conn.prepareStatement(sql)) {
//            ps.setInt(1, key);
//            ps.setInt(2, type);
//            ps.setString(3, name);
//            ps.executeUpdate();
//        }


        /*
        Callable
        A stored procedure is called by putting the word
        call and the procedure name in braces ({}).

        cs.setString(1, "Z");
        cs.setString("prefix", "Z");
         */
        /*
        OUT parameter in stored procedure
        1)var sql = "{?= call magic_number(?) }";
        2)cs.registerOutParameter(1, Types.INTEGER);
        Both are required
         */
        //Commit & rollback
        /*
        SavePoints
        1) use setAutoCommit(false) while working with transactions
        2) order of rolling back savepoint matters else exception is thrown
        //Closing order : Connection / preparedstatment / resultSet
         */
    }
}
