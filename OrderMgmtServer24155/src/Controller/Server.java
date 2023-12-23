/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Service.StudiosService;
import Service.implementation.BusinessUnitsServiceImplementation;
import Service.implementation.CompanyServiceImplementation;
import Service.implementation.DirectorServiceImplementation;
import Service.implementation.GamesServiceImplementation;
import Service.implementation.LicenceServiceImplementation;
import Service.implementation.StudiosServiceImplementation;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author royon
 */
public class Server {
    public static void main(String[] args){
        try{
        //set Properties of RMI
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        //create Registry
        Registry theRegistry = LocateRegistry.createRegistry(5000);
        theRegistry.rebind("comp", new CompanyServiceImplementation());
        theRegistry.rebind("busi", new BusinessUnitsServiceImplementation());
        theRegistry.rebind("stu", new StudiosServiceImplementation());
        theRegistry.rebind("game", new GamesServiceImplementation());
        theRegistry.rebind("dir", new DirectorServiceImplementation());
        theRegistry.rebind("lice", new LicenceServiceImplementation());
        System.out.println("Server is running on port 5000");
    }catch(Exception ex){
        ex.printStackTrace();
    }
        
    } 
}
