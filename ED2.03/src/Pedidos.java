import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pedidos")
@XmlAccessorType (XmlAccessType.FIELD)
public class Pedidos {

	@XmlElement(name="pedido")
	List<Pedido> pedidos = new ArrayList<Pedido>();
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos2) {
		this.pedidos = pedidos2;
	}

	public Pedidos addPedido(Pedido pedido){
		this.pedidos.add(pedido);
		return this;
	}
}
