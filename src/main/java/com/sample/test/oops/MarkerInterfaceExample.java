package com.sample.test.oops;

public class MarkerInterfaceExample implements IMarker {

    void  test(){
        System.out.println("tested");
    }

    public static void main(String[] args) {
        MarkerInterfaceExample markerInterfaceExample = new MarkerInterfaceExample();
        if(markerInterfaceExample instanceof IMarker){
            System.out.println("valid");
            markerInterfaceExample.test();
        }
    }

}
