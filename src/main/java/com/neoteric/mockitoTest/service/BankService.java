package com.neoteric.mockitoTest.service;

import com.neoteric.mockitoTest.model.BankPassBook;
import com.neoteric.mockitoTest.model.BankRegistrationForm;
import com.neoteric.mockitoTest.model.DepositeForm;

public class BankService {
    public BankPassBook processDeposite(DepositeForm depositeForm, BankRegistrationForm registrationForm) {
        if (depositeForm.getDepositeAmount() > 5000) {
            BankPassBook passBook = new BankPassBook();
            passBook.accNo = "ACC123";
            passBook.bankBalance = depositeForm.getDepositeAmount();
            passBook.expireDate = "12/31/2025";
            System.out.println("BankPassBook is Printed");
            System.out.println("ACCOUNT Number : "+passBook.accNo);
            return passBook;
        } else {
            System.out.println("BankPassBook is null");
            return null;
        }
    }
    }



