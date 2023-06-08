import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
    
    public static void main(String[] args) {
        String produtosTxt = "assets/Produtos.txt";
        String produtosCsv = "assets/produtos.csvX";
        String produtosJson = "assets/produtos.jsonX";



        List<Produto> listaProdutos = new ArrayList<>();


        Scanner scan = new Scanner(System.in);
        String nomeProduto;

        int index = 0;

        //Entrada txt
        try (BufferedReader reader = new BufferedReader(new FileReader(produtosTxt))) {
            String line;
            int i = 0;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Produto produtoAtual = new Produto();

                if (data.length >= 4) {
                    produtoAtual.setNome(data[0].trim());
                    produtoAtual.setDescricao(data[1].trim());
                    produtoAtual.setPreco(Float.parseFloat(data[2].trim()));
                    produtoAtual.setQuantidade(Integer.parseInt(data[3].trim()));
                    listaProdutos.add(produtoAtual);
                    i++;
                    index += 1;
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(produtosCsv))) {
            String linha;
            String separador = ",";
            // Ler as linhas do arquivo CSV
            while ((linha = br.readLine()) != null) {
                // Dividir a linha usando o separador
                String[] dados = linha.split(separador);

                // Criar um objeto Produto com os dados lidos
                String nomeDoProduto = dados[0].trim();
                String descricaoDoProduto = dados[1].trim();
                float preco = Float.parseFloat(dados[2].trim());
                int quantidade = Integer.parseInt(dados[3].trim());

                Produto produtoAtual = new Produto(nomeDoProduto, descricaoDoProduto, preco, quantidade);

                System.out.println(nomeDoProduto + " " + descricaoDoProduto + " " + preco + " " + quantidade);
                
                //listaProdutos.add(produtoAtual);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        try {
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(new FileReader(produtosJson));
            Produto produtoAtual = new Produto();
            int i = 1;

            System.out.println(jsonObject.get("Produto" + i));

            while (jsonObject.get("Produto" + i) != null){
                JSONObject jsonAtual = (JSONObject) jsonObject.get("Produto" + i);
                System.out.println(jsonAtual);

                //Salva nas variaveis os dados retirados do arquivo
                produtoAtual.setNome((String) jsonAtual.get("NomeDoProduto"));
                produtoAtual.setDescricao((String) jsonAtual.get("descri\u00e7\u00e3oDoProduto"));
                produtoAtual.setPreco(Float.parseFloat((String) jsonAtual.get("preco")));
                produtoAtual.setQuantidade(Integer.parseInt((String) jsonAtual.get("quantidade")));

                //listaProdutos.add(produtoAtual);
                i++;
            }

        }
        //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("asdaasdasd");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println("asdasdsad");
            e.printStackTrace();
        }
        index = 0;

        
        while (true) {
            HeapSortAlfabetico.heapSort(listaProdutos);
            System.out.println("##########");
            System.out.println("*  Menu  *");
            System.out.println("1 - Adicionar Produto");
            System.out.println("2 - Remover Produto");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Buscar Produto");
            System.out.println("5 - Visualizar Produtos");
            System.out.println("##########");
            System.out.print("R: ");

            switch (scan.nextInt()) {
                case 1:
                    Produto produtoAtual = new Produto();
                    System.out.println("##########");

                    System.out.println("Nome do Produto: ");
                    produtoAtual.setNome(scan.next());

                    System.out.println("Descrição do Produto: ");
                    produtoAtual.setDescricao(scan.next());

                    System.out.println("Preço do Produto: ");
                    produtoAtual.setPreco(scan.nextFloat());

                    System.out.println("Quantidade do produto: ");
                    produtoAtual.setQuantidade(scan.nextInt());

                    System.out.println("##########");
                    listaProdutos.add(produtoAtual);

                    break;
                
                case 2:
                    System.out.println();
                    System.out.println("Digite o nome do produto que voce deseja remover: ");
                    nomeProduto = scan.next();
                    if (BinarySearch.binarySearch(listaProdutos, nomeProduto) != 1) {
                        listaProdutos.remove(BinarySearch.binarySearch(listaProdutos, nomeProduto));
                    } else {
                        System.out.println("Produto não encontrado !!!");
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Digite o nome do produto que voce deseja atualizar: ");
                    nomeProduto = scan.next();
                    index = BinarySearch.binarySearch(listaProdutos, nomeProduto);
                    if (index != -1) {
                        System.out.println("##########");
    
                        System.out.println("Nome do Produto: ");
                        listaProdutos.get(index).setNome(scan.next());
    
                        System.out.println("Descrição do Produto: ");
                        listaProdutos.get(index).setDescricao(scan.next());
    
                        System.out.println("Preço do Produto: ");
                        listaProdutos.get(index).setPreco(scan.nextFloat());
    
                        System.out.println("Quantidade do produto: ");
                        listaProdutos.get(index).setQuantidade(scan.nextInt());
    
                        System.out.println("##########");
                    } else {
                        System.out.println("Produto não encontrado !!!");
                    }
                    
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Buscar por nome: ");
                    nomeProduto = scan.next();
                    index = BinarySearch.binarySearch(listaProdutos, nomeProduto);

                        if (index != 1){
                            System.out.println("##########");

                            System.out.println("Nome do Produto: " + listaProdutos.get(index).getNome());

                            System.out.println("Descrição do Produto: " + listaProdutos.get(index).getDescricao());

                            System.out.println("Preço do Produto: " + listaProdutos.get(index).getPreco());

                            System.out.println("Quantidade do produto: " + listaProdutos.get(index).getQuantidade());

                            System.out.println("##########");
                        }
                    
                    break;

                case 5:
                    System.out.println("");
                    System.out.println("Escolha como deseja visualizar");
                    System.out.println("1 - Preço");
                    System.out.println("2 - Ordem Alfabética");
                    switch (scan.nextInt()) {
                        case 1:
                            HeapSort.sort(listaProdutos);
                            System.out.println("Escolha a ordem: ");
                            System.out.println("1 - Crescente");
                            System.out.println("2 - Decrescente");
                            switch (scan.nextInt()) {
                                case 1:
                                    System.out.println("Produtos: ");
                                    for (int i = 0; i < listaProdutos.size(); i++) {
                                        System.out.println("| Nome:" + listaProdutos.get(i).getNome() + "| Preço: " + listaProdutos.get(i).getPreco() + "| Quantidade: " + listaProdutos.get(i).getQuantidade() + "|");
                                        System.out.println("Descrição: " + listaProdutos.get(i).getDescricao());
                                        System.out.println("");
                                    }
                                    break;

                                case 2:
                                    for (int i = listaProdutos.size()-1; i >= 0; i--) {
                                        System.out.println("| Nome:" + listaProdutos.get(i).getNome() + "| Preço: " + listaProdutos.get(i).getPreco() + "| Quantidade: " + listaProdutos.get(i).getQuantidade() + "|");
                                        System.out.println("Descrição: " + listaProdutos.get(i).getDescricao());
                                        System.out.println("");
                                    }
                                    break;
                            
                            
                                default:
                                    break;
                            }
                            break;

                        case 2:
                            HeapSortAlfabetico.heapSort(listaProdutos);
                            System.out.println("Escolha a ordem: ");
                            System.out.println("1 - Crescente");
                            System.out.println("2 - Decrescente");
                            switch (scan.nextInt()) {
                                case 1:
                                    System.out.println("Produtos: ");
                                    for (int i = 0; i < listaProdutos.size(); i++) {
                                        System.out.println("| Nome:" + listaProdutos.get(i).getNome() + "| Preço: " + listaProdutos.get(i).getPreco() + "| Quantidade: " + listaProdutos.get(i).getQuantidade() + "|");
                                        System.out.println("| Descrição: " + listaProdutos.get(i).getDescricao());
                                        System.out.println("");
                                    }
                                    break;

                                case 2:
                                    for (int i = listaProdutos.size()-1; i >= 0; i--) {
                                        System.out.println("| Nome:" + listaProdutos.get(i).getNome() + "| Preço: " + listaProdutos.get(i).getPreco() + "| Quantidade: " + listaProdutos.get(i).getQuantidade() + "|");
                                        System.out.println("Descrição: " + listaProdutos.get(i).getDescricao());
                                        System.out.println("");
                                    }
                                    break;
                            
                                default:
                                    break;
                            }
                            break;
                    
                        default:
                            break;
                    }
                    break;
            
                default:
                    System.out.println("Coloque uma opção válida!!");
                    break;
            }
        }
    }

}
