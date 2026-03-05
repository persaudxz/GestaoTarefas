import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    public static Connection conectar() {

        try {

            String url = "jdbc:sqlite:tarefas.db";
            Connection conn = DriverManager.getConnection(url);

            String sql = """
                    CREATE TABLE IF NOT EXISTS tarefas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    titulo TEXT,
                    categoria TEXT,
                    status TEXT
                    );
                    """;

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            return conn;

        } catch (Exception e) {
            System.out.println("Erro no banco de dados");
            return null;
        }
    }
}
