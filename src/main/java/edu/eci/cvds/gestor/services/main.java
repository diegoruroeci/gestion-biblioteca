package edu.eci.cvds.gestor.services;

public class main {

    public static void main(String[] args){
        GestorServices instance = ResourceFactory.getInstance().getGestorServices();
        System.out.println(instance.consultReservations());

    }

}
