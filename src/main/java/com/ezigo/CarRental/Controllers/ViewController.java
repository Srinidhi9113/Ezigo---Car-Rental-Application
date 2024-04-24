package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Enums.CarType;
import com.ezigo.CarRental.Models.Bill;
import com.ezigo.CarRental.Models.MyUser;
import com.ezigo.CarRental.Models.Vehicle;
import com.ezigo.CarRental.Models.VehicleReservation;
import com.ezigo.CarRental.Repository.UserRepo;
import com.ezigo.CarRental.Repository.VehicleReservationRepo;
import com.ezigo.CarRental.Service.BillService;
import com.ezigo.CarRental.Service.MyUserDetailsService;
import com.ezigo.CarRental.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/")
public class ViewController {

    private final VehicleService vehicleService;

    @Autowired
    MyUserDetailsService userDetailsService;

    @Autowired
    VehicleReservationRepo reservationRepo;

    @Autowired
    BillService billService;

    @Autowired
    ViewController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "loginpage";
    }

    @GetMapping("/signup")
    public String signupPage(){
        return "signuppage";
    }


    @GetMapping("/user/{cartype}")
    public String index(@PathVariable String cartype, Model model) throws UnsupportedEncodingException {
        List<Vehicle> carsList;
        List<String> carImages = new ArrayList<>();
        java.util.Optional<List<Vehicle>> cars;
        if(cartype.equals("all")){
            cars = vehicleService.getAvailableVehicle();
        }
        else{
            CarType carType = CarType.valueOf(cartype.toUpperCase());
            cars = vehicleService.getAvailableVehiclebyType(carType);
        }
        if(cars.isPresent()){
            carsList = cars.get();
            for(int i=0;i<carsList.size();i++){
                String base64Encoded = Base64.getEncoder().encodeToString(carsList.get(i).getImage());
                carImages.add(base64Encoded);
            }
            model.addAttribute("cars",carsList);
            model.addAttribute("carImages",carImages);
        }
        return "index";
    }

    @GetMapping("/user/bookcar/{carid}")
    public String bookCar(@PathVariable long carid, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<MyUser> user = userDetailsService.getUser(auth.getName());
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(carid);
        if(user.isPresent() && vehicle.isPresent()){
            MyUser userDetails = user.get();
            Vehicle vehicleDetails = vehicle.get();
            model.addAttribute("user",userDetails);
            model.addAttribute("car",vehicleDetails);
        }
        return "bookcarpage";
    }

    @GetMapping("/user/bill")
    public String billPage(@ModelAttribute("reservationId") Long reservationId, Model model) {
        if (reservationId != null) {
            // Fetch the reservation object using the reservationId
            Optional<VehicleReservation> reservation = reservationRepo.findById(reservationId);
            if (reservation.isPresent()) {
                Bill bill = billService.calculateBill(reservation.get());
                if(bill==null) return "redirect:/error";
                model.addAttribute("bill", bill);
                return "billpage";
            }
        }
        return "redirect:/error";
    }
}
