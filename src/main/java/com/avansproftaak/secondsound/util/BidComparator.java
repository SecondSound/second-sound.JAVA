package com.avansproftaak.secondsound.util;

import com.avansproftaak.secondsound.dto.BidDto;
import com.avansproftaak.secondsound.model.SubCategory;

import java.util.Comparator;

public class BidComparator implements Comparator<BidDto> {

    public int compare(BidDto bid1, BidDto bid2) {
        return bid2.getAmount().compareTo(bid1.getAmount());
    }

}
