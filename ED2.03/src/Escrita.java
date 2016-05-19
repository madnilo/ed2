import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Escrita {
	
	public void escreverArquivoInvertido(){
		//TODO
	}
	
	public void escreverPedidosEmArquivo() {
		Pedidos lista = new Pedidos();
		
		for(int i=1; i<10; i++){
			Pedido p = new Pedido();
			if(i%2==0)	p.setBairro("Luzia");
			if(i%2==1) p.setBairro("Grageru");
			p.setDataPedido("19/05");
			p.setNomeCliente("Cliente0"+i);
			p.setNumeroPedido(i);
			if(i%3!=0)	p.setStatusPedido("Em rua");
			if(i%3==0) p.setStatusPedido("Preparando");
			p.setTelefone("3214710"+i);
			
			lista = lista.addPedido(p);
		}
		
	  try {
		File file = new File("C:\\xml\\file.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Pedidos.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(lista, file);
		jaxbMarshaller.marshal(lista, System.out);
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }

	}
}