package com.dspringmvc.controller.carpark;

import com.dspringmvc.dto.BookingOfficeDTO;
import com.dspringmvc.dto.EmployeeDTO;
import com.dspringmvc.service.IBookingOfficeService;
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
import java.util.HashMap;
import java.util.Map;

@Controller(value = "bookingOfficeController")
public class BookingOfficeController {

    @Autowired
    private IBookingOfficeService iBookingOfficeService;

    @Autowired
    private ITripService iTripService;

    @RequestMapping(value = "/car-park/booking-office/list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        BookingOfficeDTO model = new BookingOfficeDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView modelAndView = new ModelAndView("carpark/booking_office/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(iBookingOfficeService.findAll(pageable));
        model.setTotalItem(iBookingOfficeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    @RequestMapping(value = "/car-park/booking-office/edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "officeId", required = false) Long officeId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("carpark/booking_office/edit");
        BookingOfficeDTO model = new BookingOfficeDTO();
        if (officeId != null) {
            model = iBookingOfficeService.findOne(officeId);
        }

//        Map<String, Object> modelMap = new HashMap<>();
//        modelMap.put("trips", iTripService.findAll());
//        modelMap.put("model", model);

//        modelAndView.addAllObjects(modelMap);
        modelAndView.addObject("trips", iTripService.findAll());
        modelAndView.addObject("model", model);
        return modelAndView;
    }
}
