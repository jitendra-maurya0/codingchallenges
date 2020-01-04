package com.sample.test.designpattern.adopter;

public class SocketAdopterImpl extends Socket implements SocketAdopter {

    @Override
    public Volt get120Volts() {
        return get120Volts();
    }

    @Override
    public Volt get12Volts() {
        Volt v = getVolt();
        return convertVolt(v,10);

    }

    @Override
    public Volt get3Volts() {
        Volt v = getVolt();
        return convertVolt(v,10);
    }

    @Override
    public Volt get1Volts() {
        return get1Volts();
    }

    private Volt convertVolt(Volt v,int i){
       return new Volt(v.getVolts()/i);
    }
}
