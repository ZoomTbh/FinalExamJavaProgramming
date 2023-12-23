/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.implementation;

import DAO.CompanyDao;
import Service.CompanyService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Company;

/**
 *
 * @author royon
 */
public class CompanyServiceImplementation extends UnicastRemoteObject implements CompanyService{
    
     public CompanyServiceImplementation() throws RemoteException{
        
    }
    CompanyDao dao = new CompanyDao();
    @Override
    public Company RegisterCompany(Company compObj) throws RemoteException {
        return dao.RegisterCompany(compObj);
    }

    @Override
    public Company UpdateCompany(Company compObj) throws RemoteException {
        return dao.UpdateCompany(compObj);
    }

    @Override
    public Company DeleteCompany(Company compObj) throws RemoteException {
        return dao.DeleteCompany(compObj);
    }

    @Override
    public Company SearchCompany(Company compObj) throws RemoteException {
        return dao.SearchCompany(compObj);
    }

    @Override
    public List<Company> allCompanies() throws RemoteException {
        return dao.allCompanies();
    }
    
}
