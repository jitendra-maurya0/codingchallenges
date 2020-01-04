package com.sample.question.designpattern.adopter;

public interface SocketAdopter {
     Volt get120Volts();
     Volt get12Volts();
     Volt get3Volts();
     Volt get1Volts();
}
