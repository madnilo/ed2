import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Leitura {
	public static String separador="_________________________________________________________________________";
	
	
	
	public void busca() throws JAXBException{
		File file = new File("C:\\xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pedidos lista = (Pedidos) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println("Insira o bairro que deseja buscar:");
		Scanner scanner = new Scanner(System.in);
		String bairroBuscado = scanner.nextLine();
		scanner.close();
		System.out.println("Num\t\t"+"Nome\t\t\t"+ "Bairro\t\t\t"+"Telefone\t\t\t"+"Data\t\t"+"Status");
		System.out.println(separador);
		
		for(Pedido pedido : lista.pedidos){
			if(pedido.getBairro().matches(bairroBuscado))	System.out.println(pedido.getNumeroPedido() +"\t\t"+ pedido.getNomeCliente() +"\t\t"
					+ pedido.getBairro()+ "\t\t\t"+pedido.getTelefone() +"\t\t"+pedido.getDataPedido()+"\t\t"
					+pedido.getStatusPedido());
		}
	}
	
	
	public Pedidos consultaTotal() throws JAXBException {
		File file = new File("C:\\xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		Pedidos lista = (Pedidos) jaxbUnmarshaller.unmarshal(file);
		
		System.out.println("Num\t\t"+"Nome\t\t\t"+ "Bairro\t\t\t"+"Telefone\t\t\t"+"Data\t\t"+"Status");
		System.out.println(separador);
		for(Pedido pedido : lista.pedidos){
			System.out.println(pedido.getNumeroPedido() +"\t\t"+ pedido.getNomeCliente() +"\t\t"
		+ pedido.getBairro()+ "\t\t\t"+pedido.getTelefone() +"\t\t"+pedido.getDataPedido()+"\t\t"
		+pedido.getStatusPedido());
		}
		return lista;
	}

}