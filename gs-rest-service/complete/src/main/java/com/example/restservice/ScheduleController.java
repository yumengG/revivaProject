package com.example.restservice;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import Services.ScheduleService;
import Services.ScheduleServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    ScheduleService scheduleService;


    @GetMapping("/getAvailableTimeByRoom/{roomId}")
    public List<Date> getAvailableTimeByRoom(@RequestParam(value = "roomId") int roomId,
                                             @RequestParam(value = "serviceId") int serviceId) {
        scheduleService.demo();
        System.out.println("complete demo");

        return scheduleService.getAllBookingsForRoom(roomId,serviceId);
    }
    @GetMapping("/getAvailableTimeByProvider/{providerId}")
    public List<Date> getAvailableTimeByRoom(@RequestParam(value = "providerId") int providerId) {
        return scheduleService.getAllBookingsForProvider(providerId);
    }
}
