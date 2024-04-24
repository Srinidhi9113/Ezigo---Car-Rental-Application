package com.ezigo.CarRental.Service;

import com.ezigo.CarRental.Dto.BillDto;
import com.ezigo.CarRental.Models.Bill;
import com.ezigo.CarRental.Models.VehicleReservation;
import com.ezigo.CarRental.Repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    public Bill calculateBill(VehicleReservation reservation){
        try {
            long diffInMillies = Math.abs(reservation.getCreationDate().getTime() - reservation.getReturnDate().getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            float amount = diff * reservation.getVehicle().getPrice();
            Bill newBill = new Bill();
            newBill.setAmount(amount);
            newBill.setCreatedDate(new Date());
            newBill.setVehicleReservation(reservation);
            billRepo.save(newBill);
            return newBill;
        }
        catch (Exception e){
            return null;
        }
    }

}
