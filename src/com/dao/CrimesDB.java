package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CrimesDB {
	// 데이타베이스 연결 관련 상수 선언
    private static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project?characterEncoding=euckr";
    private static final String USER="root";
    private static final String PASSWD="1234";
 
    // 데이타베이스 연결 관련 변수 선언
    private Connection conn = null;
    private Statement stmt = null;
    
    // JDBC 드라이버를 로드하는 생성자
    public CrimesDB(){
        
        // JDBC  드라이버 로드
        try{
            Class.forName(JDBC_DRIVER); 
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // 데이타베이스 연결 메소드 
    public void connect(){
        try{
            // 데이타베이스에 연결, Connection 객체 저장
            conn = DriverManager.getConnection(JDBC_URL, USER, PASSWD);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // 데이타베이스 연결 해제 메소드 (각각 try ~ catch문 작성 권장)
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
    
    // 게시판의 모든 레코드를 반환하는 메소드
    public ArrayList<Crimes> getCrimeList(){    
    
        connect();
        
        // 질의 결과를 저장할 ArrayList 를 선언
        // ArrayList 내부에 Crimes 정보를 저장한 StudentEntity 가 저장됨 (collection)
        ArrayList<Crimes> list = new ArrayList<>();   
        
        String sql = "select * from crimes";
        
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            // ResultSet 의 결과에서 모든 행을 각각의 StudentEntity객체에 저장
            while(rs.next()){

                // 한 행의 학생 정보를 저장할 빈즈 객체 생성
                Crimes crime = new Crimes();
                
                // 한 행의 학생 정보를 자바빈즈 객체에 저장
                crime.setYear(rs.getInt("year"));
                crime.setRegion(rs.getString("region"));
                crime.setMurder(rs.getInt("murder"));
                crime.setSex_violence(rs.getInt("sex_violence"));
                crime.setAssault(rs.getInt("assault"));
                crime.setIntrud(rs.getInt("intrud"));
                
                // ArrayList 에 crime 정보 Crimes 객체를 추가
                list.add(crime);
            }
            rs.close();
    
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            disConnect();
        }
        
        // 완성된 ArrayList 객체를 반환
        return list;
    }
    
    //특정 년도, 특정 구역의 crime 갖고오기
    public int getSelectedCrime(int year, String gu, String crimeType) {
    	
    	connect();
    	
    	int result=-1;
	        
	        String sql = "select "+crimeType+" from crimes where year = "+year+"region = "+gu;
	        
	        try{
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            // ResultSet 의 결과에서 모든 행을 각각의 StudentEntity객체에 저장
	            while(rs.next()){
	            	result=rs.getInt(crimeType);
	            }
	            rs.close();
	    
	        }catch(Exception e){
	            e.printStackTrace();
	        }finally{
	            disConnect();
	        }
	        
	        // 완성된 ArrayList 객체를 반환
	        return result;
	    }
}