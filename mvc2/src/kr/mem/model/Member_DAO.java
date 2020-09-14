package kr.mem.model;

import java.sql.*;

//JDBC -> myBatis(SQL Mapping Framework)


import java.util.ArrayList;
public class Member_DAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	//초기화 블럭
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
		
	}
	

	public void close() {
		
		try {
			if (rs != null) {
				rs.close();}
			
			if (psmt != null) {
				psmt.close();}
			
			if (conn != null) {
				conn.close();}
		
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	//interface 구현을 하고, 지정한 뒤에 만들기. 그래야 지정된 메소드 이름을 사용가능
	public int MemInsert(Member_VO vo) {
		conn = getConnect();
		String sql = "insert into tblMem values(seq_num.nextval,?,?,?,?,?)";
		int cnt = -1; //-1은 실패,,,,,,,,,,,,
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getPhone());
			psmt.setString(3, vo.getAddr());
			psmt.setDouble(4, vo.getLat());
			psmt.setDouble(5, vo.getLng());
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
	}
	
	public ArrayList<Member_VO> memberAllList() {
		ArrayList<Member_VO> list= new ArrayList<Member_VO>();
		conn = getConnect();
		String sql = "select * from tblMem order by num desc";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");				
				String addr = rs.getString("addr");
				double lat = rs.getDouble("lat");
				double lng = rs.getDouble("lng");
				
				//묶기
				Member_VO vo = new Member_VO(num, name, phone, addr, lat, lng);
			
				//담기
				list.add(vo);
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return list;
		
	}
	
	public int memberDelete(int num) {
		conn = getConnect();
		int cnt = -1;
		String sql = "delete from tblMem where num = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		return cnt;
		
		
	}
	
	
	
	public Member_VO memberContent(int num) {

		Member_VO vo = null;
		
		conn = getConnect();
		
		String sql = "select * from tblMem where num=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			
			if (rs.next()) {//true
				num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");				
				String addr = rs.getString("addr");
				double lat = rs.getDouble("lat");
				double lng = rs.getDouble("lng");
				
				//묶기
				vo = new Member_VO(num, name, phone, addr, lat, lng);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			close();
		}
		return vo;
	}
	
	public int MemberUpdate(Member_VO vo) {
		conn =getConnect();
		int cnt = 0;
		String sql = "update tblMem set phone=?, addr=? where num=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getPhone());
			psmt.setString(2, vo.getAddr());
			psmt.setInt(3, vo.getNum());
			
			cnt = psmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		
		return cnt;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
