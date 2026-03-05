import java.sql.*;
import java.util.ArrayList;

public class TarefaDAO {

    Connection conn = Database.conectar();

    public void criarTarefa(String titulo, String categoria) {

        try {

            String sql = "INSERT INTO tarefas (titulo, categoria, status) VALUES (?, ?, 'Pendente')";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, titulo);
            ps.setString(2, categoria);

            ps.executeUpdate();

            System.out.println("Tarefa criada!");

        } catch (Exception e) {
            System.out.println("Erro ao criar tarefa");
        }
    }

    public void listarTarefas() {

        try {

            String sql = "SELECT * FROM tarefas";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("titulo") + " | " +
                                rs.getString("categoria") + " | " +
                                rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar tarefas");
        }
    }

    public void concluirTarefa(int id) {

        try {

            String sql = "UPDATE tarefas SET status = 'Concluída' WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Tarefa concluída!");

        } catch (Exception e) {
            System.out.println("Erro ao concluir tarefa");
        }
    }

    public void excluirTarefa(int id) {

        try {

            String sql = "DELETE FROM tarefas WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Tarefa excluída!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir tarefa");
        }
    }

    public void filtrarCategoria(String categoria) {

        try {

            String sql = "SELECT * FROM tarefas WHERE categoria = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, categoria);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("titulo") + " | " +
                                rs.getString("categoria") + " | " +
                                rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no filtro");
        }
    }

    public void filtrarStatus(String status) {

        try {

            String sql = "SELECT * FROM tarefas WHERE status = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, status);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("titulo") + " | " +
                                rs.getString("categoria") + " | " +
                                rs.getString("status")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no filtro");
        }
    }
}