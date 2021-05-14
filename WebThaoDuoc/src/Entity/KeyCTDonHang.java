package Entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class KeyCTDonHang implements Serializable {
	@ManyToOne
	@JoinColumn(name="MaDH")
	private DonHang maDH;
	
	@ManyToOne
	@JoinColumn(name="MaSP")
	private SanPham maSP;
}