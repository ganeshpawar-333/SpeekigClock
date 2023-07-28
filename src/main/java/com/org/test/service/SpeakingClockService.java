package com.org.test.service;

import org.springframework.stereotype.Service;

@Service
public interface SpeakingClockService {

    public String getCurrentTimeInWords(String time);


}
