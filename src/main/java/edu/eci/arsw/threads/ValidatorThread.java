package edu.eci.arsw.threads;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

import java.util.LinkedList;


public class ValidatorThread extends Thread {

    private int inicio;
    private int fin;
    private HostBlacklistsDataSourceFacade skds;
    private int servidoresDisponibles = 0;
    private int ocurrencias = 0;
    private String ipaddres;
    private LinkedList<Integer> blackListOcurrences=new LinkedList<>();


    public ValidatorThread (int start, int end, HostBlacklistsDataSourceFacade skdss, String ipaddress){
        this.ipaddres = ipaddress;
        this.inicio = start;
        this.fin = end;
        this.skds = skdss;
    }

    public void run(){

        for(int i = inicio ; i<= fin ; i++ ){
            servidoresDisponibles++;
            if (skds.isInBlackListServer(i,ipaddres)){
                ocurrencias++;
                blackListOcurrences.add(i);
            }
        }
    }

    public int getOcurrencias(){
        return ocurrencias;
    }
}
