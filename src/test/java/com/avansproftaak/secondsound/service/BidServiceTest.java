package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.newBidDto;
import com.avansproftaak.secondsound.model.Bid;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.BidRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BidServiceTest {

    @Autowired
    BidRepository bidRepository;

    @Autowired
    AdvertisementRepository advertisementRepository;

    @Autowired
    BidService sut;

    private newBidDto bid;

    @BeforeEach
    void setUp() {
        bid = new newBidDto(1L, "99999999.00", 1L);

        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("john.doe@gmail.com");
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @AfterEach
    void tearDown() {
        bidRepository.delete(bidRepository.getReferenceById(22L));
    }

    @Test
    void post_bid_adds_bid_to_advertisement() {
        sut.postBid(bid);

        List<Bid> bids = bidRepository.findAllByAdvertisement(advertisementRepository.getReferenceById(1L));
        assertTrue(bids.stream().anyMatch(o -> bid.getAmount().equals(o.getAmount().toString())));
    }
}
