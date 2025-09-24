public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n--- Menu da Biblioteca ---");
            System.out.println("1 - Adicionar Livro");
            System.out.println("2 - Listar Acervo");
            System.out.println("3 - Pesquisar por Título");
            System.out.println("4 - Remover Livro");
            System.out.println("5 - Atualizar Livro");
            System.out.println("6 - Contagem de Livros");
            System.out.println("7 - Pesquisar por Ano");
            System.out.println("8 - Livro Mais Antigo e Mais Novo");
            System.out.println("0 - Sair");

            opcao = Input.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    String tipo;
                    do {
                        tipo = Input.lerString("Digite o tipo do livro (Fisico/Digital): ");
                        if (!tipo.equalsIgnoreCase("Fisico") && !tipo.equalsIgnoreCase("Digital")) {
                            System.out.println("Tipo inválido! Digite 'Fisico' ou 'Digital'.");
                        }
                    } while (!tipo.equalsIgnoreCase("Fisico") && !tipo.equalsIgnoreCase("Digital"));

                    String titulo;
                    do {
                        titulo = Input.lerString("Título: ");
                        if (titulo.trim().isEmpty()) System.out.println("Título não pode ser vazio!");
                    } while (titulo.trim().isEmpty());

                    String autor;
                    do {
                        autor = Input.lerString("Autor: ");
                        if (autor.trim().isEmpty()) System.out.println("Autor não pode ser vazio!");
                    } while (autor.trim().isEmpty());

                    int ano;
                    do {
                        ano = Input.lerInt("Ano de publicação: ");
                        if (ano < Biblioteca.ANO_PUBLICACAO_MINIMO) {
                            System.out.println("Ano inválido! Deve ser >= " + Biblioteca.ANO_PUBLICACAO_MINIMO);
                        }
                    } while (ano < Biblioteca.ANO_PUBLICACAO_MINIMO);

                    int paginas;
                    do {
                        paginas = Input.lerInt("Número de páginas: ");
                        if (paginas <= 0) System.out.println("Número de páginas deve ser positivo!");
                    } while (paginas <= 0);

                    if (tipo.equalsIgnoreCase("Fisico")) {
                        int exemplares;
                        do {
                            exemplares = Input.lerInt("Número de exemplares: ");
                            if (exemplares <= 0) System.out.println("Deve ser maior que zero!");
                        } while (exemplares <= 0);

                        double altura = Input.lerDouble("Altura (cm): ");
                        double largura = Input.lerDouble("Largura (cm): ");
                        double profundidade = Input.lerDouble("Profundidade (cm): ");

                        biblioteca.adicionarLivro(new LivroFisico(titulo, autor, ano, paginas,
                                exemplares, altura, largura, profundidade));

                    } else { 
                        String formatoArquivo;
                        do {
                            formatoArquivo = Input.lerString("Formato do arquivo: ");
                            if (formatoArquivo.trim().isEmpty())
                                System.out.println("Formato não pode ser vazio!");
                        } while (formatoArquivo.trim().isEmpty());

                        double tamanhoMB;
                        do {
                            tamanhoMB = Input.lerDouble("Tamanho do arquivo (MB): ");
                            if (tamanhoMB <= 0) System.out.println("Tamanho deve ser positivo!");
                        } while (tamanhoMB <= 0);

                        biblioteca.adicionarLivro(new LivroDigital(titulo, autor, ano, paginas,
                                formatoArquivo, tamanhoMB));
                    }
                    break;

                case 2:
                    biblioteca.listarAcervo();
                    break;

                case 3:
                    String tituloPesquisa = Input.lerString("Digite o título para pesquisa: ");
                    biblioteca.pesquisarPorTitulo(tituloPesquisa);
                    break;

                case 4:
                    int idRemover = Input.lerInt("Digite o ID do livro a remover: ");
                    biblioteca.removerLivro(idRemover);
                    break;

                case 5:
                    int idAtualizar = Input.lerInt("Digite o ID do livro a atualizar: ");

                    String novoTipo;
                    do {
                        novoTipo = Input.lerString("Digite o novo tipo (Fisico/Digital): ");
                        if (!novoTipo.equalsIgnoreCase("Fisico") && !novoTipo.equalsIgnoreCase("Digital")) {
                            System.out.println("Tipo inválido! Digite 'Fisico' ou 'Digital'.");
                        }
                    } while (!novoTipo.equalsIgnoreCase("Fisico") && !novoTipo.equalsIgnoreCase("Digital"));

                    String novoTitulo;
                    do {
                        novoTitulo = Input.lerString("Novo título: ");
                        if (novoTitulo.trim().isEmpty()) System.out.println("Título não pode ser vazio!");
                    } while (novoTitulo.trim().isEmpty());

                    String novoAutor;
                    do {
                        novoAutor = Input.lerString("Novo autor: ");
                        if (novoAutor.trim().isEmpty()) System.out.println("Autor não pode ser vazio!");
                    } while (novoAutor.trim().isEmpty());

                    int novoAno;
                    do {
                        novoAno = Input.lerInt("Novo ano de publicação: ");
                        if (novoAno < Biblioteca.ANO_PUBLICACAO_MINIMO) {
                            System.out.println("Ano inválido! Deve ser >= " + Biblioteca.ANO_PUBLICACAO_MINIMO);
                        }
                    } while (novoAno < Biblioteca.ANO_PUBLICACAO_MINIMO);

                    int novoPaginas;
                    do {
                        novoPaginas = Input.lerInt("Novo número de páginas: ");
                        if (novoPaginas <= 0) System.out.println("Número de páginas deve ser positivo!");
                    } while (novoPaginas <= 0);

                    Livro novoLivro;
                    if (novoTipo.equalsIgnoreCase("Fisico")) {
                        int exemplares = Input.lerInt("Número de exemplares: ");
                        double altura = Input.lerDouble("Altura (cm): ");
                        double largura = Input.lerDouble("Largura (cm): ");
                        double profundidade = Input.lerDouble("Profundidade (cm): ");
                        novoLivro = new LivroFisico(novoTitulo, novoAutor, novoAno, novoPaginas,
                                exemplares, altura, largura, profundidade);
                    } else { // Digital
                        String formatoArquivo = Input.lerString("Formato do arquivo (PDF/EPUB/MOBI): ");
                        double tamanhoMB = Input.lerDouble("Tamanho do arquivo (MB): ");
                        novoLivro = new LivroDigital(novoTitulo, novoAutor, novoAno, novoPaginas,
                                formatoArquivo, tamanhoMB);
                    }

                    biblioteca.atualizarLivro(idAtualizar, novoLivro);
                    break;

                case 6:
                    biblioteca.contagemLivros();
                    break;

                case 7:
                    int anoInicio = Input.lerInt("Ano início: ");
                    int anoFim = Input.lerInt("Ano fim: ");
                    biblioteca.pesquisarPorAno(anoInicio, anoFim);
                    break;

                case 8:
                    biblioteca.livroMaisAntigoEMaisNovo();
                    break;

                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida! Digite um número entre 0 e 8.");
            }

        } while (opcao != 0);
    }
}
