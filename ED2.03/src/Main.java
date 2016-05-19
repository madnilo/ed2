import javax.xml.bind.JAXBException;

public class Main {
	
	public static void main(String[] args) throws JAXBException{
		Escrita escreva = new Escrita();
		Leitura leia = new Leitura();
		
		
		
		//escreva.escreverPedidosEmArquivo();
		leia.consultaTotal();
		//leia.busca();
	}
}
