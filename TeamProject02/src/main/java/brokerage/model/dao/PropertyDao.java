package brokerage.model.dao;

import java.sql.*;
import java.util.*;

import brokerage.model.dto.PropertyDto;

public class PropertyDao extends Dao {
    
    public static PropertyDao instance = new PropertyDao();
    
    public PropertyDao() {
        super();
    }
    
    public static PropertyDao getInstance() {
        return instance;
    }
    
    // 지역별 매물 검색
    public List<PropertyDto> searchByLocation(String location, int maxPrice) {
        List<PropertyDto> properties = new ArrayList<>();
        String sql = "SELECT p.*, ph.phname FROM property p " +
                    "LEFT JOIN photo ph ON p.pno = ph.pno " +
                    "WHERE p.paddress LIKE ? AND p.mprice <= ? AND p.psell = 0 " +
                    "ORDER BY p.pdate DESC";
                    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + location + "%");
            pstmt.setInt(2, maxPrice);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PropertyDto property = new PropertyDto();
                property.setPno(rs.getInt("pno"));
                property.setPcategory(rs.getInt("pcategory"));
                property.setPaddress(rs.getString("paddress"));
                property.setParea(rs.getDouble("parea"));
                property.setMprice(rs.getInt("mprice"));
               
                property.setPadd(rs.getString("padd"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    // 가격대별 매물 검색
    public List<PropertyDto> searchByPrice(int minPrice, int maxPrice) {
        List<PropertyDto> properties = new ArrayList<>();
        String sql = "SELECT p.*, ph.phname FROM property p " +
                    "LEFT JOIN photo ph ON p.pno = ph.pno " +
                    "WHERE p.mprice BETWEEN ? AND ? AND p.psell = 0 " +
                    "ORDER BY p.mprice ASC";
                    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, minPrice);
            pstmt.setInt(2, maxPrice);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PropertyDto property = new PropertyDto();
                property.setPno(rs.getInt("pno"));
                property.setPcategory(rs.getInt("pcategory"));
                property.setPaddress(rs.getString("paddress"));
                property.setParea(rs.getDouble("parea"));
                property.setMprice(rs.getInt("mprice"));
                
                property.setPadd(rs.getString("padd"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    // 추천 매물 검색 (면적과 가격 기준)
    public List<PropertyDto> getRecommendations(double targetArea, int maxPrice) {
        List<PropertyDto> properties = new ArrayList<>();
        String sql = "SELECT p.*, ph.phname FROM property p " +
                    "LEFT JOIN photo ph ON p.pno = ph.pno " +
                    "WHERE ABS(p.parea - ?) <= 10 AND p.mprice <= ? AND p.psell = 0 " +
                    "ORDER BY ABS(p.parea - ?) LIMIT 5";
                    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, targetArea);
            pstmt.setInt(2, maxPrice);
            pstmt.setDouble(3, targetArea);
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PropertyDto property = new PropertyDto();
                property.setPno(rs.getInt("pno"));
                property.setPcategory(rs.getInt("pcategory"));
                property.setPaddress(rs.getString("paddress"));
                property.setParea(rs.getDouble("parea"));
                property.setMprice(rs.getInt("mprice"));
                
                property.setPadd(rs.getString("padd"));
                property.setPstorey(rs.getInt("pstorey"));
                property.setPyear(rs.getString("pyear"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    // 신규 등록 매물 검색
    public List<PropertyDto> getNewProperties() {
        List<PropertyDto> properties = new ArrayList<>();
        String sql = "SELECT p.*, ph.phname FROM property p " +
                    "LEFT JOIN photo ph ON p.pno = ph.pno " +
                    "WHERE p.psell = 0 " +
                    "ORDER BY p.pdate DESC LIMIT 5";
                    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                PropertyDto property = new PropertyDto();
                property.setPno(rs.getInt("pno"));
                property.setPcategory(rs.getInt("pcategory"));
                property.setPaddress(rs.getString("paddress"));
                property.setParea(rs.getDouble("parea"));
                property.setMprice(rs.getInt("mprice"));
              
                property.setPadd(rs.getString("padd"));
                properties.add(property);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return properties;
    }
}