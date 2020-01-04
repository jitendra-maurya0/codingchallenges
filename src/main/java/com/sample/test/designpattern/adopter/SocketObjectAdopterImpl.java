package com.sample.test.designpattern.adopter;

public class SocketObjectAdopterImpl implements SocketAdopter {

    private Socket socket = new Socket();
    @Override
    public Volt get120Volts() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volts() {
        Volt v = socket.getVolt();
        return convert(v,10);
    }

    @Override
    public Volt get3Volts() {
        Volt v = socket.getVolt();
        return convert(v,40);
    }

    @Override
    public Volt get1Volts() {
        return null;
    }

    private Volt convert(Volt v,int i){
       return new Volt(v.getVolts()/i);
    }
}
