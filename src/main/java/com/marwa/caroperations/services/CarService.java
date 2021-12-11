package com.marwa.caroperations.services;

import com.marwa.caroperations.dto.request.RequestFilter;
import com.marwa.caroperations.dto.response.BaseResponse;
import com.marwa.caroperations.entities.Car;
import com.marwa.caroperations.entities.Owner;
import com.marwa.caroperations.repositories.CarRepository;
import com.marwa.caroperations.dto.request.CarRequest;
import com.marwa.caroperations.dto.response.CarResponse;
import com.marwa.caroperations.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import com.marwa.caroperations.helpers.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public List<CarResponse> getCars(RequestFilter filter, HttpServletResponse myResponse) {
        List<CarResponse> cars = new ArrayList<>();
        try{
            List<Car> carsDbList = carRepository.findAll();

            if(filter.getSearch() != null){
                carsDbList = carsDbList.stream()
                        .filter(c ->
                                c.getCarName().equals(filter.getSearch()) || c.getOwner().getOwnerName().equals(filter.getSearch()))
                        .toList();
            }

            if(filter.getOrderByName() != null){
                carsDbList = carsDbList.stream().sorted(Comparator.comparing(Car::getCarName)).toList();
            }else if(filter.getOrderByModel() != null){
                carsDbList = carsDbList.stream().sorted(Comparator.comparing(Car::getModel)).toList();
            }

            cars = carsDbList.stream().map(c -> CarResponseFromCar(c)).toList();

        }catch (Exception e){
            myResponse.setStatus(Constants.SERVER_ERROR);
        }
        return cars;
    }

    public BaseResponse AddCar(CarRequest request) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Owner> owner = ownerRepository.findById(request.getOwnerId());

        if(owner.isEmpty()){
            baseResponse.setBaseResponse(Constants.SERVER_ERROR, "The car owner was not found", Constants.SERVER_ERROR_STR);
        } else {
            try {
                createNewCar(request, owner.get());
                baseResponse.setBaseResponse(Constants.OK, "Car added successfully!", Constants.OK_STR);

            }catch (DataAccessException e){
                baseResponse.setBaseResponse(Constants.SERVER_ERROR, "Could not add the car", Constants.SERVER_ERROR_STR);
            }
        }

        return baseResponse;
    }

    public CarResponse CarResponseFromCar(Car car){
        CarResponse response = new CarResponse();
        response.setCarName(car.getCarName());
        response.setOwnerName(car.getOwner().getOwnerName());
        response.setColor(car.getColor());
        response.setModel(car.getModel());
        return response;
    }

    @Transactional(rollbackFor = Exception.class)
    public Car createNewCar(CarRequest request, Owner owner) throws DataAccessException {
        Car car = new Car();
        car.setCarName(request.getCarName());
        car.setColor(request.getColor());
        car.setModel(request.getModel());
        car.setOwner(owner);
        return carRepository.save(car);
    }
}
