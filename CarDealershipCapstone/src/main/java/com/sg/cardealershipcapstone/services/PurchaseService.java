/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.cardealershipcapstone.services;

import com.sg.cardealershipcapstone.data.PurchaseRepository;
import com.sg.cardealershipcapstone.models.Purchase;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emmastout
 */
@Service
public class PurchaseService {
    
    @Autowired
    PurchaseRepository repo;

    public Result<Purchase> savePurchase(Purchase p) {
       
       Result<Purchase> result = validate(p);
        if (result.isSuccess()) {
            p = repo.save(p);
            result.setPayload(p);
        }
        return result; 
    }

    private Result<Purchase> validate(Purchase p) {
          Result<Purchase> result = new Result<>();
          BigDecimal NinetyFivePercent = new BigDecimal(.95);
          BigDecimal NinetyFivePercentOfSalePrice = p.getVehicle().getSalePrice()
                  .divide(NinetyFivePercent, 2, RoundingMode.CEILING);
          
          //Add other validation logic here
        if (p.getEmail().length() ==0 && p.getPhone().length() == 0) {
            result.addMessage("Either a phone number or email address is required.");
        }
        
        if (p.getPurchasePrice().compareTo(p.getVehicle().getMsrp()) == 1) {
            result.addMessage("Purchase price cannot be larger than MSRP.");
        }
        
        if (p.getPurchasePrice().compareTo(NinetyFivePercentOfSalePrice) == -1) {
            result.addMessage("Purchase price cannot be less than "
                    + "95% of sales price");
        }

        //Get all validation errors from model annotations
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Purchase>> errs = validator.validate(p);
        for (ConstraintViolation<Purchase> err : errs) {
            result.addMessage(err.getMessage());
        }

        return result;
    }
}
