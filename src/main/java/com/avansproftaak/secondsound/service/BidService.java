package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.BidDto;
import com.avansproftaak.secondsound.dto.newBidDto;
import com.avansproftaak.secondsound.model.Bid;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import com.avansproftaak.secondsound.repository.BidRepository;
import com.avansproftaak.secondsound.util.BidComparator;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BidService {

    private final BidRepository bidRepository;
    private final UserService userService;
    private final AdvertisementRepository advertisementRepository;

    public List<BidDto> getBids(Long id) {

        var advertisement = advertisementRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement not found"));

        var bids = bidRepository.findAllByAdvertisement(advertisement);
        var bidDtoList = new ArrayList<BidDto>();

        for (Bid bid: bids) {
            var newBidDto = new BidDto(bid.getId(), bid.getAmount(), bid.getCreatedAt(), userService.getSellerOrBidder(bid.getBidder().getId()));
            bidDtoList.add(newBidDto);
        }

        bidDtoList.sort(new BidComparator());
        return bidDtoList;
    }

    public void postBid(newBidDto newBidDto) {

        var bidString = newBidDto.getAmount().replaceAll(",",".");
        var amount = BigDecimalParser.parse(bidString);
        var advertisement = advertisementRepository.findById(newBidDto.getAdvertisementId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Advertisement not found"));;
        var bidder = userService.getAuthenticatedUser();

        var bid = new Bid(amount, advertisement, bidder);
        bidRepository.save(bid);
    }

    public void deleteBid(Long id) {
        bidRepository.deleteById(id);
    }
}
