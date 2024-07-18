/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rinbo
 */
public class Model {
    private int maKH;
    private String hoTen;
    private String email;
    private String ghiChu;

    public Model() {
    }
    

    public Model(int maKH, String hoTen, String email, String ghiChu) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.email = email;
        this.ghiChu = ghiChu;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public Object[] toDaTaRow(){
    return new Object[] { this.maKH, this.hoTen, this.email, this.ghiChu};
}
    
}
