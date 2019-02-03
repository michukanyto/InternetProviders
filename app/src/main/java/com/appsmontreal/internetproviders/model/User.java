package com.appsmontreal.internetproviders.model;

import java.io.Serializable;

public class User implements Serializable {
    private int clientNumber;
    private int providerNumber;



    public void setClientNumber(int clientNumber) {

        this.clientNumber = clientNumber;
    }

    public void setProviderNumber(int providerNumber) {

        this.providerNumber = providerNumber;
    }


    public int getClientNumber() {

        return clientNumber;
    }

    public int getProviderNumber() {

        return providerNumber;
    }

    public User(int clientNumber, int providerNumber) {
        this.clientNumber = clientNumber;
        this.providerNumber = providerNumber;
    }

    @Override
    public String toString() {
        String provider = null;

        switch(providerNumber){
            case 1 : provider = "Bell";break;
            case 2 : provider = "Fido";break;
            case 3 : provider = "Bravo";break;
            case 4 : provider = "VideoTron";break;
        }
        return clientNumber + " .................... " + provider + "\n\n";
    }
}
