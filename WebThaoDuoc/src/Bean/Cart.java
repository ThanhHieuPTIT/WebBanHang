package Bean;

import java.util.ArrayList;
import java.util.List;

import Entity.SanPham;

public class Cart{
	private List<CartItem> items;
	private float tongTien;
	
	public Cart() {
		items = new ArrayList<CartItem>();
		tongTien = 0;
	}
	
	//lay mat hang trong gio
	public CartItem getItem(SanPham sp) {
		for(CartItem item: items) {
			if(item.getSanPham().getMaSP() == sp.getMaSP()) {
				return item;
			}
		}
		return null;
	}
	
	//lay gio hang
	public List<CartItem> getItems(){
		return items;
	}
	
	//lay so luong mat hang
	public int getItemCount() {
		return items.size();
	}
	
	//them mot mat hang
	public void addItem(CartItem item) {
		addItem(item.getSanPham(),item.getSoLuongMua());
	}
	
	//them mat hang voi so luong cho truoc 
	public void addItem(SanPham sp,int soLuong) {
		CartItem item = getItem(sp);
		if(item != null) {
			item.setSoLuongMua(item.getSoLuongMua()+soLuong);
		} else {
			item = new CartItem(sp);
			item.setSoLuongMua(soLuong);
			items.add(item);
		}
		
	}
	
	// update mat hang
	public void updateItem(SanPham sp,int soLuong) {
		CartItem item = getItem(sp);
		if(item!=null) {
			item.setSoLuongMua(soLuong);
		}
	}
	
	// xoa mat hang
	public void deleteItem(SanPham sp) {
		CartItem item = getItem(sp);
		if(item!=null) {
			items.remove(item);
		}
	}
	
	// xoa toan bo gio hang
	public void clear() {
		items.clear();
		tongTien = 0;
	}
	
	// kiem tra gio hang co trong hay khong
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	//tinh tong tien 
	public float getTongTien(){
		tongTien = 0;
		for(CartItem item: items) {
			tongTien += item.getTongGia();
		}
		return tongTien;
	}
}
	
