import java.util.Scanner;

import javax.xml.bind.JAXBException;

public class Main {

	public static Pedidos limpar() {
		Pedidos lista = new Pedidos();
		for (int i = 1; i < 10; i++) {
			Pedido p = new Pedido();
			if (i % 2 == 0)
				p.setBairro("Luzia");
			if (i % 2 == 1)
				p.setBairro("Grageru");
			p.setDataPedido("19/05");
			p.setNomeCliente("Cliente0" + i);
			p.setNumeroPedido(i);
			if(i%3!=0)	p.setStatusPedido("Em rua");
			if(i%3==0) p.setStatusPedido("Preparando");
			p.setTelefone("3214710" + i);
			lista = lista.addPedido(p);
		}
		return lista;
	}

	public static void main(String[] args) throws JAXBException {
		Escrita escreva = new Escrita();
		Leitura leia = new Leitura();
		//escreva.escreverPedidosEmArquivo(limpar());

		Scanner scanner = new Scanner(System.in);

		System.out.println("Inserir pedido '1', excluir pedido '2', buscar por bairro '3', consulta total '4', limpar arquivo '5'.");
		int opcao = scanner.nextInt();
		if (opcao == 1)
			escreva.inserirPedido();
		 if(opcao==2)escreva.excluirPedido();
		if (opcao == 3)
			leia.busca();
		if (opcao == 4)
			leia.consultaTotal();
		if (opcao == 5)
			escreva.escreverPedidosEmArquivo(limpar());

		scanner.close();
	}
}
