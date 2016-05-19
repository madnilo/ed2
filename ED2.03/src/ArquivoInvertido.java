import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="arquivoinvertido")
@XmlAccessorType (XmlAccessType.FIELD)
public class ArquivoInvertido {
	int Grageru;
	int Luzia;
	
	public int getGrageru() {
		return Grageru;
	}
	public void setGrageru(int grageru) {
		Grageru = grageru;
	}
	public int getLuzia() {
		return Luzia;
	}
	public void setLuzia(int luzia) {
		Luzia = luzia;
	}
}
