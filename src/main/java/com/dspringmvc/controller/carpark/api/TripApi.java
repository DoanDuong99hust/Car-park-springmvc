package com.dspringmvc.controller.carpark.api;

import com.dspringmvc.dto.TripDTO;
import com.dspringmvc.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripApi {
    @Autowired
    private ITripService iTripService;

    @PostMapping("/api/car-park/trip")
    public TripDTO create(@RequestBody TripDTO tripDTO) {
        return iTripService.save(tripDTO);
    }

    @PutMapping("/api/car-park/trip")
    public TripDTO update(@RequestBody TripDTO tripDTO) {
        return iTripService.save(tripDTO);
    }

    @DeleteMapping("/api/car-park/trip")
    public void delete(@RequestBody long[] ids) {
        iTripService.delete(ids);
    }
}
