package Bean;

import Entity.SanPham;

public class CartItem {
	private SanPham sanPham;
	private int soLuongMua;
	private float tongGia;
	
	
	public CartItem() {
	}
	public CartItem(SanPham sanPham) {
		this.sanPham = sanPham;
		this.soLuongMua = 1;
		this.tongGia = sanPham.getDonGia();
	}
	
	public SanPham getSanPham() {
		return sanPham;
	}
	
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	public int getSoLuongMua() {
		return soLuongMua;
	}
	
	public void setSoLuongMua(int soLuongMua) {
		this.soLuongMua = soLuongMua;
	}
	
	public float getTongGia() {
		tongGia = sanPham.getDonGia() * soLuongMua;
		return tongGia;
	}
	
	public void setTongGia(float tongGia) {
		this.tongGia = tongGia;
	}
	
	
}
