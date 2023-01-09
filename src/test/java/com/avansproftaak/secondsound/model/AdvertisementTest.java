package com.avansproftaak.secondsound.model;

import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdvertisementTest {

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Test
    public void is_advertisement_test_data_generated() {
        System.out.println("Generating test advertisements...");
        long count = advertisementRepository.count();
        System.out.println("Elements: " + count);
        advertisementRepository.findAll().forEach(System.out::println);
        System.out.println("Test advertisements successfully generated.");

        assertEquals(count, 11);
    }
}
