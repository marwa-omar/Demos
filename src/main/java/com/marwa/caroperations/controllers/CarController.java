package com.marwa.caroperations.controllers;

import com.marwa.caroperations.dto.request.CarRequest;
import com.marwa.caroperations.dto.request.RequestFilter;
import com.marwa.caroperations.dto.response.BaseResponse;
import com.marwa.caroperations.dto.response.CarResponse;
import com.marwa.caroperations.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json", value = "/cars")
    public @ResponseBody
    List<CarResponse> getCars(@RequestBody RequestFilter filter, HttpServletResponse myResponse){
        return carService.getCars(filter, myResponse);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", value = "/addCar", produces = "application/json")
    public @ResponseBody
    BaseResponse AddCar(@RequestBody(required = true) CarRequest request) {
        return carService.AddCar(request);
    }

}
