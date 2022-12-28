package com.avansproftaak.secondsound.controller;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.BidDto;
import com.avansproftaak.secondsound.dto.newBidDto;
import com.avansproftaak.secondsound.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1.0/")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping(path="public/bids/{id}")
    public List<BidDto> getBids(@PathVariable Long id) {
        return bidService.getBids(id);
    }

    @PostMapping(path="bids")
    public void postBid(@RequestBody newBidDto newBidDto) {
        bidService.postBid(newBidDto);
    }

    @DeleteMapping(path = "bids/{id}")
    public void deleteBid(@PathVariable Long id) {
        bidService.deleteBid(id);
    }
}
