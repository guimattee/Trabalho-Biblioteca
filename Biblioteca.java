import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    public static final int ANO_PUBLICACAO_MINIMO = 1900;

    public Biblioteca() {
        livros = new ArrayList<>();
    }

    public boolean adicionarLivro(Livro livro) {
        for (Livro livroAtual : livros) {
            if (livroAtual.getTitulo().equalsIgnoreCase(livro.getTitulo()) &&
                livroAtual.getAutor().equalsIgnoreCase(livro.getAutor()) &&
                livroAtual.getAnoPublicacao() == livro.getAnoPublicacao()) {
                System.out.println("Livro duplicado não permitido!");
                return false;
            }
        }
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
        return true;
    }

    public void listarAcervo() {
        if (livros.isEmpty()) {
            System.out.println("Acervo vazio!");
            return;
        }
        for (Livro livroAtual : livros) {
            System.out.println(livroAtual); 
        }
    }

    public void pesquisarPorTitulo(String titulo) {
        boolean encontrado = false;
        for (Livro livroAtual : livros) {
            if (livroAtual.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livroAtual);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Nenhum livro encontrado com esse título!");
    }

    public void removerLivro(int id) {
        Livro livroParaRemover = null;
        for (Livro livroAtual : livros) {
            if (livroAtual.getId() == id) {
                livroParaRemover = livroAtual;
                break;
            }
        }
        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            System.out.println("Livro removido!");
        } else {
            System.out.println("ID inválido!");
        }
    }

    public void atualizarLivro(int id, Livro novoLivro) {
        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if (livroAtual.getId() == id) {
                livros.set(i, novoLivro);
                System.out.println("Livro atualizado!");
                return;
            }
        }
        System.out.println("ID inválido!");
    }

    public void contagemLivros() {
        System.out.println("Total de livros no acervo: " + livros.size());
    }

    public void pesquisarPorAno(int anoInicio, int anoFim) {
        boolean encontrado = false;
        for (Livro livroAtual : livros) {
            if (livroAtual.getAnoPublicacao() >= anoInicio && livroAtual.getAnoPublicacao() <= anoFim) {
                System.out.println(livroAtual);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Nenhum livro encontrado nesse intervalo de anos!");
    }

    public void livroMaisAntigoEMaisNovo() {
        if (livros.isEmpty()) {
            System.out.println("Acervo vazio!");
            return;
        }

        Livro maisAntigo = livros.get(0);
        Livro maisNovo = livros.get(0);

        for (int i = 1; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if (livroAtual.getAnoPublicacao() < maisAntigo.getAnoPublicacao()) maisAntigo = livroAtual;
            if (livroAtual.getAnoPublicacao() > maisNovo.getAnoPublicacao()) maisNovo = livroAtual;
        }

        System.out.println("Livro mais antigo:\n" + maisAntigo);
        System.out.println("Livro mais novo:\n" + maisNovo);
    }
}
