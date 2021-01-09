package dev.hoteals.web_app_sandbox.Repository;

import dev.hoteals.web_app_sandbox.Model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    @Autowired
    JdbcTemplate template;

    public List<Car> fetchAll() {
        String query = "SELECT * FROM car";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        return template.query(query, rowMapper); // Why not query for list ?
    }

    public Car findCarByID ( int carID ) {
        String query = "SELECT * FROM car WHERE car_id = ?";
        RowMapper<Car> rowMapper = new BeanPropertyRowMapper<>(Car.class);
        Car car = template.queryForObject(query, rowMapper, carID);
        return car;
    }

    public Car addCar ( Car car ){
        String query = "INSERT INTO car(brand, model, color) VALUES ( ?, ?, ? )";
        template.update(query, car.getBrand(), car.getModel(), car.getColor());
        return null; // Why return null ???
    }

    public Boolean deleteCar ( int carID ) {
        String query = "DELETE FROM car WHERE car_id = ?";
        return template.update(query, carID) < 0; // Why < 0 ? -1 => true
    }

    public Boolean updateCar ( Car car ) {
        String query = "UPDATE car SET brand = ?, model = ?, color = ? WHERE car_id = ?";
        return template.update(query, car.getBrand(), car.getModel(), car.getColor(), car.getCar_id()) < 0;
    }
}
