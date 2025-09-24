public final class LivroDigital extends Livro {
    private String formatoArquivo;
    private double tamanhoMB;

    public LivroDigital(String titulo, String autor, int anoPublicacao, int numeroPaginas,
                        String formatoArquivo, double tamanhoMB) {
        super(titulo, autor, anoPublicacao, numeroPaginas);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoMB = tamanhoMB;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public double getTamanhoMB() {
        return tamanhoMB;
    }

    public void setTamanhoMB(double tamanhoMB) {
        this.tamanhoMB = tamanhoMB;
    }

    @Override
    public String getFormato() {
        return "Digital";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nFormato do arquivo: " + formatoArquivo +
               "\nTamanho do arquivo: " + tamanhoMB + " MB";
    }
}
