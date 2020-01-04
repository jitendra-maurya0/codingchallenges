package com.sample.test.designpattern.adopter;

public class Main {

    public static void main(String[] args) {
        TestingObjectAdopter();
        testingClassAdopter();
    }

    private static void testingClassAdopter(){
        SocketAdopter socketAdopter = new SocketObjectAdopterImpl();
        Volt v3 = getVolt(socketAdopter,3);
        Volt v12 = getVolt(socketAdopter,12);
        Volt v120 = getVolt(socketAdopter,120);
        System.out.println("V3 volt is using class adopter + "+v3.getVolts());
        System.out.println("V12 volt is using class adopter + "+v12.getVolts());
        System.out.println("V120 volt is using class adopter + "+v120.getVolts());
    }
    private static void TestingObjectAdopter(){
        SocketAdopter socketAdopter = new SocketObjectAdopterImpl();
        Volt v3 = getVolt(socketAdopter,3);
        Volt v12 = getVolt(socketAdopter,12);
        Volt v120 = getVolt(socketAdopter,120);
        System.out.println("V3 volt is using object adopter + "+v3.getVolts());
        System.out.println("V12 volt is using object adopter + "+v12.getVolts());
        System.out.println("V120 volt is using object adopter + "+v120.getVolts());
    }

    private static Volt getVolt(SocketAdopter socketAdopter,int i){
        switch (i){
            case 3: return socketAdopter.get3Volts();
            case 12: return socketAdopter.get12Volts();
            case 120: return socketAdopter.get120Volts();

            default: return socketAdopter.get1Volts();
        }
    }
}
