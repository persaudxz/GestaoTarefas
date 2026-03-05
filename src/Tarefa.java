public class Tarefa {

    int id;
    String titulo;
    String categoria;
    String status;

    public Tarefa(int id, String titulo, String categoria, String status) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.status = status;
    }

    @Override
    public String toString() {

        return id +
                " | " + titulo +
                " | " + categoria +
                " | " + status;
    }
}