package com.epam.esm.test.model.service;

import com.epam.esm.model.dao.impl.GiftCertificateDAOImpl;
import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.service.impl.GiftCertificateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GiftCertificateServiceTest {

    private static GiftCertificateServiceImpl giftCertificateService;
    private static GiftCertificate giftCertificate = new GiftCertificate(1,"newTag",200,1,
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            "newGift");
    private static GiftCertificate giftCertificateUpdated = new GiftCertificate(1,"newTagUpdate",200,1,
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            LocalDateTime.of(2017, Month.NOVEMBER, 30, 0,0),
            "newGift");


    @BeforeAll
    public static void setup(){
        GiftCertificateDAOImpl giftCertDAO = mock(GiftCertificateDAOImpl.class);
        when(giftCertDAO.addCertificate(giftCertificate)).thenReturn(1);
        when(giftCertDAO.updateCertificate(giftCertificateUpdated)).thenReturn(1);
        when(giftCertDAO.allCertificate("")).thenReturn(new ArrayList<GiftCertificate>(Arrays.asList(giftCertificateUpdated)));
        when(giftCertDAO.deleteCertificate(1)).thenReturn(1);
        when(giftCertDAO.readOneGiftById(1)).thenReturn(giftCertificate);
        giftCertificateService = new GiftCertificateServiceImpl(giftCertDAO);
    }

    @Test
    public void addGiftCertTestTrue(){
        assertEquals(1, giftCertificateService.addGiftCertificate(giftCertificate));
    }

    @Test
    public void addGiftCertTestFalse(){
        Assertions.assertNotEquals(0, giftCertificateService.addGiftCertificate(giftCertificate));
    }

    @Test
    public void updateGiftCertTestTrue(){
        assertEquals(giftCertificateService.updateGiftCertificate(giftCertificateUpdated),1);
    }

    @Test
    public void updateGiftCertTestFalse(){
        Assertions.assertNotEquals(giftCertificateService.updateGiftCertificate(giftCertificateUpdated),0);
    }

    @Test
    public void getAllGiftCertTestTrue(){
        int listSize = giftCertificateService.allGiftCertificate("").size();
        assertEquals(listSize,1);
    }

    @Test
    public void getAllGiftCertTestFalse(){
        int listSize = giftCertificateService.allGiftCertificate("").size();
        Assertions.assertNotEquals(listSize,5);
    }

    @Test
    public void getOneGiftCertTestTrue(){
        assertEquals(giftCertificate, giftCertificateService.findGiftById(1));
    }

    @Test
    public void getOneGiftCertTestFalse(){
        Assertions.assertNotEquals(giftCertificateUpdated, giftCertificateService.findGiftById(1));
    }

    @Test
    public void deleteGiftCertTestTrue(){
        assertEquals(giftCertificateService.deleteGiftCertificate(1),1);
    }

    @Test
    public void deleteGiftCertTestFalse(){
        assertNotEquals(giftCertificateService.deleteGiftCertificate(1),0);
    }
}
