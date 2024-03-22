package com.ssafy.ws.step1.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.ws.step1.dto.Car;

// 추상화에 의존하기 위함
// 구체적인 구현에 의존하기 보다는
// - MySQL Driver에 의존하는 것을 피하기 위함.
public interface CarDao {
	
	List<Car> selectAllCars() throws SQLException; // SELECT * FROM car
	
	boolean insertCar(Car car) throws SQLException; // INSERT INTO car VALUE(..)
	
	int carCount() throws SQLException; // SELECT COUNT(*) FROM car
}
