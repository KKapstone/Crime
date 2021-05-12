package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CrimesDB {
	// ����Ÿ���̽� ���� ���� ��� ����
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project?characterEncoding=euckr";
    private static final String USER="root";
    private static final String PASSWD="1234";
 
    // ����Ÿ���̽� ���� ���� ���� ����
    private Connection conn = null;
    private Statement stmt = null;
    
    // JDBC ����̹��� �ε��ϴ� ������
    public CrimesDB(){
        
        // JDBC  ����̹� �ε�
        try{
            Class.forName(JDBC_DRIVER); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // ����Ÿ���̽� ���� �޼ҵ� 
    public void connect(){
        try{
            // ����Ÿ���̽��� ����, Connection ��ü ����
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // ����Ÿ���̽� ���� ���� �޼ҵ� (���� try ~ catch�� �ۼ� ����)
    public void disConnect(){
        
        if(stmt != null){
            try{
                stmt.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
                
            }
        }
    }
    
    // �Խ����� ��� ���ڵ带 ��ȯ�ϴ� �޼ҵ�
    public ArrayList<Crimes> getCrimeList(){    
    
        connect();
        
        // ���� ����� ������ ArrayList �� ����
        // ArrayList ���ο� Crimes ������ ������ StudentEntity �� ����� (collection)
        ArrayList<Crimes> list = new ArrayList<>();   
        
        String sql = "select * from crimes";
        
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // ResultSet �� ������� ��� ���� ������ StudentEntity��ü�� ����
            while(rs.next()){

                // �� ���� �л� ������ ������ ���� ��ü ����
                Crimes crime = new Crimes();
                
                // �� ���� �л� ������ �ڹٺ��� ��ü�� ����
                crime.setYear(rs.getInt("year"));
                crime.setRegion(rs.getString("region"));
                crime.setMurder(rs.getInt("murder"));
                crime.setSex_violence(rs.getInt("sex_violence"));
                crime.setAssault(rs.getInt("assault"));
                crime.setIntrud(rs.getInt("intrud"));
                
                // ArrayList �� crime ���� Crimes ��ü�� �߰�
                list.add(crime);
            }
            rs.close();
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            disConnect();
        }
        
        // �ϼ��� ArrayList ��ü�� ��ȯ
        return list;
    }
    
    //Ư�� �⵵, Ư�� ������ crime �������
    public int getSelectedCrime(int year, String gu, String crimeType) {
    	
    	connect();
    	
    	int result=-1;
	        
	        String sql = "select "+crimeType+" from crimes where year = "+year+"region = "+gu;
	        
	        try{
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            // ResultSet �� ������� ��� ���� ������ StudentEntity��ü�� ����
	            while(rs.next()){
	            	result=rs.getInt(crimeType);
	            }
	            rs.close();
	    
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            disConnect();
	        }
	        
	        // �ϼ��� ArrayList ��ü�� ��ȯ
	        return result;
	    }
}