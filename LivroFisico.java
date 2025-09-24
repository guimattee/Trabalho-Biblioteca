public final class LivroFisico extends Livro {
    private int numeroExemplares;
    private double altura, largura, profundidade; // cm

    public LivroFisico(String titulo, String autor, int anoPublicacao, int numeroPaginas,
            int numeroExemplares, double altura, double largura, double profundidade) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.numeroExemplares = numeroExemplares;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }

    public int getNumeroExemplares() {
        return numeroExemplares;
    }

    public void setNumeroExemplares(int numeroExemplares) {
        this.numeroExemplares = numeroExemplares;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }

    @Override
    public String getFormato() {
        return "Físico";
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nNúmero de exemplares: " + numeroExemplares +
            "\nDimensões (A-L-P cm): " + altura + "×" + largura + "×" + profundidade;
    }
}
