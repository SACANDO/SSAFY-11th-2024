package com.ssafy.ws.step1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.ws.step1.dto.Car;
import com.ssafy.ws.step1.util.DBUtil;

public class CarDaoImpl implements CarDao{

	/**
  * DB 사용을 위해 DBUtil 객체를 가져온다.
  */
	private final DBUtil util = DBUtil.getInstance();
	
	// DAO: Database Access Object
	// - 데이터베이스에 접근해서 조회(쿼리), 업데이트(수정, 삭제)를 수행하는 로직을 가지고 있는 객체.
	
	// 1. 지금 실습
	// MainServlet(요청, 응답 처리-컨트롤러) --> DAO를 호출해서 데이터를 얻어옴.
	
	// 2. Spring MVC 패턴
	// Controller   ,  Model(Service,  DAO) 세 가지로 분리해서 MVC 패턴 구현
	// Controller(요청, 응답 처리)
	//    - 데이터 & 로직 수행이 필요한 상황 - DB가 필요하지 않은 경우 -> Service 객체가 처리
	//                               - DB가 필요한 경우 -> DAO 객체를 통해서 데이터베이스 조회, 수정
	

	private static CarDao instance = new CarDaoImpl(); 

	private CarDaoImpl() {}

	public static CarDao getInstance() {
		return instance;
	}
	// DB에 저장된 모든 자동차 목록 조회
	public List<Car> selectAllCars() {
		// 사용할 sql문
		String sql = "SELECT * FROM car";
		// 모든 Car 정보를 저장할 list
		ArrayList<Car> result = new ArrayList<Car>();
		// DB 연결 객체
		Connection conn = null;
		// sql문 실행 객체
		Statement stmt = null;
		PreparedStatement pstmt = null;
		// sql문 실행 결과 집합
		ResultSet rs = null;

		try {
			// 연결 객체 얻기 - DBUtil에서 얻어온다.
			conn = util.getConnection();
			// 위에서 사용할 sql문을 통해 pstmt 구문 객체 생성
//			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);
			// sql 실행(처리할 결과가 있는 경우)
			rs = pstmt.executeQuery(); // 조회: executeQuery, 수정,삭제: executeUpdate

			// sql 실행 결과 처리
			while (rs.next()) {
				Car car = new Car();
				car.setVin(rs.getString("vin"));
				car.setModelName(rs.getString("modelName"));
				car.setColor(rs.getString("color"));
				car.setMileage(rs.getInt("mileage"));
				result.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 자원 해제
			
			util.close(rs, pstmt, conn);
		}

		// list 반환
		return result;
	}

	// DB에 Car 정보 삽입
	public boolean insertCar(Car car) {
		String sql = "INSERT INTO car VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getVin());
			pstmt.setString(2, car.getModelName());
			pstmt.setString(3, car.getColor());
			pstmt.setInt(4, car.getMileage());
			// executeUpdate가 정상 수행되면 행의 개수가 1이상이 반환
			// executeUpdate가 정상 수행된 것이 아니면 에러가 나거나 행의 개수가 0
			result = pstmt.executeUpdate() > 0 ? true : false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		return result;
	}

	// DB에 등록된 Car 정보 갯수
	public int carCount() {
		String sql = "SELECT COUNT(*) AS cnt FROM car";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result = 0;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next())
				result = rs.getInt("cnt");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}

		return result;

	}

}