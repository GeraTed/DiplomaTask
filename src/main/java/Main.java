import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Asus on 24.04.2017.
 */
public class Main {
    static final String USERNAME = "root";
    static final String PASSWORD = "root";
    static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException, IOException {

        Result.result(Marks.getMarks(VecotorSize.toVectorSize(Memory.memoryAir())));

    }

}
