package com.example.mobile.rest;

import com.example.mobile.service.NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/number")
public class NumberController {
    @Autowired
    private NumberServiceImpl numberService;

    @GetMapping(path = "/probability", produces = "application/json")
    public List<String> getAllProbabilityNumbers(@QueryParam("number") String number){
        List<String> numbers = numberService.getAllProbableNumber(number);
        return numbers;
    }

}
