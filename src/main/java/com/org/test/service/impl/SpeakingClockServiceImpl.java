package com.org.test.service.impl;

import com.org.test.service.SpeakingClockService;
import org.springframework.stereotype.Service;
import pl.allegro.finance.tradukisto.ValueConverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class SpeakingClockServiceImpl implements SpeakingClockService {

    public String getCurrentTimeInWords(String time) {

        StringBuilder sb = new StringBuilder();

        ValueConverters valueConverters = ValueConverters.ENGLISH_INTEGER;
        int hour = 0;
        int min = 0;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime localTime = LocalTime.from(formatter.parse(time));
            hour = localTime.getHour();
            min = localTime.getMinute();
        sb = sb.append("It's ");
        if (hour == 12 && min == 0) {
            sb = sb.append("Midday");
        } else if (hour == 0 && min == 0) {
            sb = sb.append("Midnight");
        } else {
            sb = sb.append(valueConverters.asWords(hour))
                    .append(" ").append(valueConverters.asWords(min));
        }

        return sb.toString();
    }


}
