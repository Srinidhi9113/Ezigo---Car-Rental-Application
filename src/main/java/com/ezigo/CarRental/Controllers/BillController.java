package com.ezigo.CarRental.Controllers;

import com.ezigo.CarRental.Dto.BillDto;
import com.ezigo.CarRental.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
public class BillController {
    private final BillService billService;

    @Autowired
    public BillController(BillService billService){
        this.billService = billService;
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertBillToDB(@RequestBody BillDto billDto){
        if(billService.insertToDB(billDto)) return new ResponseEntity<>("Bill inserted ",HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }


}
