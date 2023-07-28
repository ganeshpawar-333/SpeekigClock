package com.org.test.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.allegro.finance.tradukisto.ValueConverters;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public interface SpeakingClockService {

    public String getCurrentTimeInWords(String time);


}
