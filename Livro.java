import java.time.Year;

public abstract class Livro {
    private static int contador = 1; // ID começa em 1
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numeroPaginas;

    public Livro(String titulo, String autor, int anoPublicacao, int numeroPaginas) {
        this.id = contador++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public abstract String getFormato();

    public final int calcularTempoPublicacao() {
        return Year.now().getValue() - anoPublicacao;
    }

    @Override
    public String toString() {
        return "ID: " + id +
            "\nTítulo: " + titulo +
            "\nAutor: " + autor +
            "\nAno: " + anoPublicacao +
            "\nPáginas: " + numeroPaginas +
            "\nFormato: " + getFormato() +
            "\nTempo desde publicação: " + calcularTempoPublicacao() + " anos";
    }
}
