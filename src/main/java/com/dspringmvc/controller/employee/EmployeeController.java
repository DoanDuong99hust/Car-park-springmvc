package com.dspringmvc.controller.employee;

import com.dspringmvc.dto.EmployeeDTO;
import com.dspringmvc.service.IEmployeeService;
import com.dspringmvc.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller(value = "employeeController")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "/employee/employee-list", method = RequestMethod.GET)
    public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpServletRequest request) {
        EmployeeDTO model = new EmployeeDTO();
        model.setPage(page);
        model.setLimit(limit);
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setListResult(iEmployeeService.findAll(pageable));
        model.setTotalItem(iEmployeeService.getTotalItem());
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            modelAndView.addObject("message", message.get("message"));
            modelAndView.addObject("alert", message.get("alert"));
        }
        modelAndView.addObject("model", model);
        return modelAndView;
    }

    @RequestMapping(value = "/employee/employee-edit", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam(value = "employeeId", required = false) Long employeeId, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        EmployeeDTO model = new EmployeeDTO();
        if (employeeId != null) {
            model = iEmployeeService.findOne(employeeId);
        }
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            modelAndView.addObject("message", message.get("message"));
            modelAndView.addObject("alert", message.get("alert"));
        }
        modelAndView.addObject("model", model);
        return modelAndView;
    }

}
