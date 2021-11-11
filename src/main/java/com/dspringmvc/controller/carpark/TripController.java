package com.dspringmvc.controller.carpark;

import com.dspringmvc.dto.TripDTO;
import com.dspringmvc.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TripController {

    @Autowired
    private ITripService iTripService;

    @RequestMapping(value = "/car-park/trip/list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        TripDTO model = new TripDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView modelAndView = new ModelAndView("carpark/trips_manager/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(iTripService.findAll(pageable));
        model.setTotalItem(iTripService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    @RequestMapping(value = "/car-park/trip/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "tripId", required = false) Long tripId, HttpServletRequest request ) {
        ModelAndView modelAndView = new ModelAndView("carpark/trips_manager/edit");
        TripDTO model = new TripDTO();
        if (tripId != null) {
            model = iTripService.findOne(tripId);
        }
        modelAndView.addObject("model", model);
        return modelAndView;
    }


}
