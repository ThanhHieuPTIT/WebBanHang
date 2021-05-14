package Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@IdClass(KeyCTDonHang.class)
@Table(name="CTDonHang")
public class CTDonHang {
	@Id
	@EmbeddedId
	private KeyCTDonHang idCTDH;
	private int SoSP;
	
	public int getSoSP() {
		return SoSP;
	}
	public void setSoSP(int soSP) {
		SoSP = soSP;
	}
}
