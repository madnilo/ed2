import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Escrita {
	
	public void escreverArquivoInvertido() throws JAXBException{
		ArquivosInvertidos arquivosInvertidos = new ArquivosInvertidos();
		Leitura leia = new Leitura();
		Pedidos lista = leia.consultaTotal();
		int i = 0;
		for (Pedido pedido : lista.pedidos){
			i++;
			if(pedido.getBairro().equals("Luzia")){
				ArquivoInvertido arquivo = new ArquivoInvertido();
				arquivo.setGrageru(0);
				arquivo.setLuzia(i);
				arquivosInvertidos.arquivoInvertido.add(arquivo);
			}
		}
		
		File file = new File("C:\\xml\\arquivoinvertido.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(arquivosInvertidos, file);
		//jaxbMarshaller.marshal(lista, System.out);
	}
	
	public void excluirPedido() throws JAXBException{
		File file = new File("C:\\xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pedidos lista = (Pedidos) jaxbUnmarshaller.unmarshal(file);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira nome do cliente que deseja excluir");
		String cliente = scanner.nextLine();
		scanner.close();
		Pedidos aux = new Pedidos();
		for(Pedido pedido : lista.pedidos){
			if(!pedido.getNomeCliente().matches(cliente)){
				aux.pedidos.add(pedido);
			}
		}
		escreverPedidosEmArquivo(aux);
		
	}
	
	public void inserirPedido() throws JAXBException{
		Pedido pedido = new Pedido();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o numero do pedido");
		int i = scanner.nextInt();
		pedido.setNumeroPedido(i);
		if(i%2==0)	pedido.setBairro("Luzia");
		if(i%2!=0) pedido.setBairro("Grageru");
		pedido.setNomeCliente("Cliente"+i);
		pedido.setDataPedido("19/05");
		pedido.setTelefone("356980"+i);
		if(i%3!=0)	pedido.setStatusPedido("Em rua");
		if(i%3==0) pedido.setStatusPedido("Preparando");
				
		Leitura leia = new Leitura();
		Pedidos lista = leia.consultaTotal();
		lista.addPedido(pedido);
		escreverPedidosEmArquivo(lista);
		scanner.close();
	}
	
	public void escreverPedidosEmArquivo(Pedidos lista) throws JAXBException {

		File file = new File("C:\\xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(lista, file);
		//jaxbMarshaller.marshal(lista, System.out);
		Leitura leia = new Leitura();
		leia.consultaTotal();
		
		//escreverArquivoInvertido();

	}
}