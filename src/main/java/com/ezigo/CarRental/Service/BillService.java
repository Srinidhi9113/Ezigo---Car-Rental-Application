package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.BillDto;
import com.ezigo.CarRental.Models.Bill;
import com.ezigo.CarRental.Repository.BillRepo;
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
