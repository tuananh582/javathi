package model;

public class SanPham {
    private int ma;  // Mã sản phẩm (id)
    private String tensp;  // Tên sản phẩm
    private int gia;  // Giá sản phẩm

    // Constructor đầy đủ
    public SanPham(int ma, String tensp, int gia) {
        this.ma = ma;
        this.tensp = tensp;
        this.gia = gia;
    }

    // Getter và Setter cho ma (id)
    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    // Getter và Setter cho tensp
    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    // Getter và Setter cho gia
    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
}
