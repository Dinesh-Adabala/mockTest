package com.neoteric.mockitoTest;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;

import com.neoteric.mockitoTest.model.BankPassBook;
import com.neoteric.mockitoTest.model.BankRegistrationForm;
import com.neoteric.mockitoTest.model.DepositeForm;
import com.neoteric.mockitoTest.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class BankMockTest {
    @Mock
    private DepositeForm depositeForm;

    @Mock
    private BankRegistrationForm registrationForm;

    @InjectMocks
    private BankService bankService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void depositeGreaterThen5000() {
        // It tells Mockito that when
        when(depositeForm.getDepositeAmount()).thenReturn(6000.0);

        BankPassBook passBook = bankService.processDeposite(depositeForm, registrationForm);

        assertNotNull(passBook);
        assertEquals("ACC123", passBook.accNo);
        assertEquals(6000.0, passBook.bankBalance);
        assertEquals("12/31/2025", passBook.expireDate);
    }

    @Test
    public void depositeLessThen5000() {
        when(depositeForm.getDepositeAmount()).thenReturn(4000.0);

        BankPassBook passBook = bankService.processDeposite(depositeForm, registrationForm);

        assertNull(passBook);
    }
}
