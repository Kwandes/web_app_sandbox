package dev.hoteals.web_app_sandbox.Service;

import dev.hoteals.web_app_sandbox.Model.Car;
import dev.hoteals.web_app_sandbox.Repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public List<Car> fetchAll () {
        return carRepo.fetchAll();
    }

    public Car findCarByID ( int carID ) {
        return carRepo.findCarByID( carID );
    }

    public Car addCar ( Car car ) {
        return carRepo.addCar( car );
    }

    public Boolean deleteCar ( int carID ) {
        return carRepo.deleteCar( carID );
    }

    public Boolean updateCar ( Car car ) {
        return carRepo.updateCar( car );
    }
}
