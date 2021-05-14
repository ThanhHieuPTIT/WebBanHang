package Entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="DonHang")
public class DonHang {
	@Id
	@GeneratedValue
	@Column(name = "MaDH")
	private int maDH;
	
	@Column(name = "TenKH")
	private String tenKH;
	
	@Column(name = "DiaChi")
	private String diaChi;
	
	@Column(name = "SDT")
	private String sDT;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "NgayDatHang")
	private String ngayDatHang;
	
	@Column(name = "TongTien")
	private float tongTien;

	@Column(name = "TrangThai")
	private String trangThai;
	
	public DonHang() {
		super();
	}


	public DonHang(String tenKH, String diaChi, String sDT, String email, String ngayDatHang, float tongTien,String trangThai) {
		super();
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
		this.ngayDatHang = ngayDatHang;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}

	public DonHang(int maDH, String tenKH, String diaChi, String sDT, String email, String ngayDatHang, float tongTien) {
		super();
		this.maDH = maDH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sDT = sDT;
		this.email = email;
		this.ngayDatHang = ngayDatHang;
		this.tongTien = tongTien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMaDH(int maDH) {
		this.maDH = maDH;
	}

	public int getMaDH() {
		return maDH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(String ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}


	@Override
	public String toString() {
		return "DonHang [maDH=" + maDH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sDT=" + sDT + ", email=" + email
				+ ", ngayDatHang=" + ngayDatHang + ", tongTien=" + tongTien + ", trangThai=" + trangThai + "]";
	}

//	@OneToMany(mappedBy = "maDH",fetch=FetchType.EAGER)
//	private Collection<KeyCTDonHang> keyMaDH;
	
	
}
