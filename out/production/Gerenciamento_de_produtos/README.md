# Banco_de_dados_por_ordenacao

Este programa é um sistema de gerenciamento de produtos.
Ele permite adicionar, remover, atualizar e buscar produtos em uma lista.
A lista de produtos é ordenada alfabeticamente pelo nome dos produtos.
É possível visualizar a lista de produtos em ordem crescente ou decrescente de acordo com o nome ou preço.
O programa utiliza as seguintes classes:
Produto: representa um produto com nome, descrição, preço e quantidade.

Para a logica de ordeanção e busca pode-se ver os algoritmos utilizados a seguir:

Heap sort (Ordenação) - Baseado na arvore binaria, geralmente mais utilizado quando se esta trabalhando com dados simples. Sua vantagem e sua simplicidade e a não necessidade de utlização de memoria extra para organizar o array

Binary search (Busca) - Só pode ser utilizada quando uma lista ja está ordenada (Por isso se usa o algoritmo Heap Sort), ela e mais utilizada quando temos um array ou matriz muito grande para ser percorrido linearmente. Sua vantegem também é sua simplicidade, so que sua desvantagem é o foto de que os dados devem estar num local de memoria contíguos, o que pode pode ser um problema quando temos um grande conjunto de dados

