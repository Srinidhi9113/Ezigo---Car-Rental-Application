package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.VehicleReservationDto;
import com.ezigo.CarRental.Models.VehicleReservation;
import com.ezigo.CarRental.Service.VehicleReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/api/reservation")
public class VehicleReservationController {
    private final VehicleReservationService vehicleReservationService;

    @Autowired
    public VehicleReservationController(VehicleReservationService vehicleReservationService){
        this.vehicleReservationService = vehicleReservationService;
    }

    @GetMapping("/get/{userId}")
    public ResponseEntity<?> getReservation(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(vehicleReservationService.getReservation(userId), HttpStatus.FOUND);
    }
    @PostMapping("/insert")
    public String insertReservation(VehicleReservationDto vehicleReservationDto, RedirectAttributes redirectAttributes) {
        VehicleReservation reservation = vehicleReservationService.insertReservation(vehicleReservationDto);
        if (reservation != null) {
            redirectAttributes.addFlashAttribute("reservationId", reservation.getId());
            return "redirect:/user/bill";
        }
        return "redirect:/error";
    }
}
