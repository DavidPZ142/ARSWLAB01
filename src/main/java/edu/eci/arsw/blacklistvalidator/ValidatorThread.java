package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;


public class ValidatorThread extends Thread {

    private int inicio;
    private int fin;

    public ValidatorThread (int start, int end){
        this.inicio = start;
        this.fin = end;
    }

    public void run(){
        HostBlacklistsDataSourceFacade skds=HostBlacklistsDataSourceFacade.getInstance();
        /*if (skds.isInBlackListServer(Contador i, parametro ipaddress)){

        }

    }
}
