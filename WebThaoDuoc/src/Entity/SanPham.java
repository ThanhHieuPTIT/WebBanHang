package Entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="SanPham")
public class SanPham {
	@Id
	@GeneratedValue
	@Column(name="MaSP")
	private int maSP;
	
	@Column(name="TenSP")
	private String tenSP;
	
	@Column(name="AnhSP")
	private String anhSP;
	
	@Column(name="SoLuong")
	private int soLuong;
	
	@Column(name="DonGia")
	private float donGia;
	
	@Column(name="MoTa")
	private String moTa;

	
	public SanPham() {
		super();
	}
	
	public SanPham(String tenSP, int soLuong, float donGia, String moTa) {
		super();
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.moTa = moTa;
	}

	public SanPham(String tenSP, String anhSP, int soLuong, float donGia, String moTa) {
		super();
		this.tenSP = tenSP;
		this.anhSP = anhSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.moTa = moTa;
	}

	public SanPham(int maSP, String tenSP, String anhSP, int soLuong, float donGia, String moTa) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.anhSP = anhSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.moTa = moTa;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public int getMaSP() {
		return maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getAnhSP() {
		return anhSP;
	}

	public void setAnhSP(String anhSP) {
		this.anhSP = anhSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public float getDonGia() {
		return donGia;
	}

	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	
//	@OneToMany(mappedBy = "maSP",fetch=FetchType.EAGER)
//	private Collection<KeyCTDonHang> keyMaSP;
	
	
}
