import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="arquivosinvertidos")
@XmlAccessorType (XmlAccessType.FIELD)
public class ArquivosInvertidos {

	@XmlElement(name="arquivoinvertido")
	List<ArquivoInvertido> arquivoInvertido = new ArrayList<ArquivoInvertido>();

	public List<ArquivoInvertido> getArquivoInvertido() {
		return arquivoInvertido;
	}

	public void setArquivoInvertido(List<ArquivoInvertido> arquivoInvertido) {
		this.arquivoInvertido = arquivoInvertido;
	}
}
