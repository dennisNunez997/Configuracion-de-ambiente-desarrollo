/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managedbean;

import com.entidades.session.CargoFacadeLocal;
import com.tienda.entidades.Cargo;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;


/**
 *
 * @author dennis
 */
@Named(value = "cargoManagedBean")
@ViewScoped
public class CargoManagedBean implements Serializable, ManagedBeanInterface<Cargo>{

    /**
     * Creates a new instance of CargoManagedBean
     */
    
    @EJB
    private CargoFacadeLocal cargoFacadeLocal;
    
           
    public CargoManagedBean() {
        
       
    }
    
    private List<Cargo> listaCargos;
    
    private Cargo cargo;
    
    @PostConstruct
    public void init(){
        listaCargos = cargoFacadeLocal.findAll();
    }

    @Override
    public void nuevo() {
        cargo = new Cargo();
    }

    @Override
    public void grabar() {
        try{
            if(cargo.getCodigoC() == null){
                cargoFacadeLocal.create(cargo);
            }else{
                cargoFacadeLocal.edit(cargo);
            }
            cargo=null;
            listaCargos = cargoFacadeLocal.findAll();
            mostrarMensajeTry("INFORMACION EXITOSA", FacesMessage.SEVERITY_ERROR);
        }catch (Exception e){
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void seleccionar(Cargo c) {
        cargo = c;
    }

    @Override
    public void eliminar(Cargo c) {
        try{
            cargoFacadeLocal.remove(c);
            listaCargos = cargoFacadeLocal.findAll();
            mostrarMensajeTry("ELIMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        }catch(Exception e){
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);            
        }
    }

    @Override
    public void cancelar() {
        cargo = null;
    }

    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    
}
