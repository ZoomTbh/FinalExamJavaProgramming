/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Company;

/**
 *
 * @author royon
 */
public interface CompanyService extends Remote{
    Company RegisterCompany (Company compObj) throws RemoteException;
    Company UpdateCompany (Company compObj) throws RemoteException;
    Company DeleteCompany (Company compObj) throws RemoteException;
    Company SearchCompany (Company compObj) throws RemoteException;
    List <Company> allCompanies () throws RemoteException;
}
