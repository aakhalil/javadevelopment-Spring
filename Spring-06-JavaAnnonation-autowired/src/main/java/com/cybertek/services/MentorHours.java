package com.cybertek.services;

import com.cybertek.interfaces.ExtraSessions;

public class MentorHours implements ExtraSessions {
    @Override
    public int getHours() {
        return 20;
    }
}
