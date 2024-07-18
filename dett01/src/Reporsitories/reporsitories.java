/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reporsitories;

import Model.Model;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author rinbo
 */
public class reporsitories {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Model> getAll() {
        ArrayList<Model> list_nguoiHoc = new ArrayList<>();
        sql = "select MaNH, HoTen, Email, GhiChu from NguoiHoc";

        try {
            con = DBconnnect.DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String hoTen = rs.getString(2);
                String email = rs.getString(3);
                String ghiChu = rs.getString(4);

                Model m = new Model(maKH, hoTen, email, ghiChu);
                list_nguoiHoc.add(m);

            }
            return list_nguoiHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int them(Model m) {
        sql = "insert into NguoiHoc(MaNH, HoTen, Email, GhiChu)\n"
                + "values(?,?,?,?)";
        try {
            con = DBconnnect.DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getMaKH());
            ps.setObject(2, m.getHoTen());
            ps.setObject(3, m.getEmail());
            ps.setObject(4, m.getGhiChu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int sua(int maKH, Model m) {
        sql = "UPDATE NguoiHoc \n"
                + "SET HoTen = ?, Email = ?, GhiChu = ?\n"
                + "WHERE MaNH = ?";
        try {
            con = DBconnnect.DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getHoTen());
            ps.setObject(2, m.getEmail());
            ps.setObject(3, m.getGhiChu());
            ps.setObject(4, maKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int xoa(int maKH) {
        sql = "delete from NguoiHoc where MaNH = ?";
        try {
            con = DBconnnect.DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maKH);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ArrayList<Model> sapXep(){
         ArrayList<Model> list_nguoiHoc = new ArrayList<>();
        sql = "select MaNH, HoTen, Email, GhiChu from NguoiHoc\n" +
"ORDER BY MaNH DESC";

        try {
            con = DBconnnect.DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int maKH = rs.getInt(1);
                String hoTen = rs.getString(2);
                String email = rs.getString(3);
                String ghiChu = rs.getString(4);

                Model m = new Model(maKH, hoTen, email, ghiChu);
                list_nguoiHoc.add(m);

            }
            return list_nguoiHoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
