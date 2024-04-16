package com.ezigo.CarRental.services;

import com.ezigo.CarRental.dto.BillDto;
import com.ezigo.CarRental.models.Bill;
import com.ezigo.CarRental.repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private final BillRepo billRepo;

    @Autowired
    public BillService(BillRepo billRepo){
        this.billRepo = billRepo;
    }

    public boolean insertToDB(BillDto billDto){
        Bill newBill = new Bill();
        newBill.setAmount(billDto.getAmount());
        newBill.setCreatedDate(billDto.getCreatedDate());
        newBill.setVehicleReservation(billDto.getVehicleReservation());

        try{
            Bill bill = billRepo.save(newBill);
            return true;
        }catch(Exception e){
            System.out.println(e);

        }
        return false;
    }

}
