/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades.session;

import com.tienda.entidades.Estadocivil;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dennis
 */
@Stateless
public class EstadocivilFacade extends AbstractFacade<Estadocivil> implements EstadocivilFacadeLocal {

    @PersistenceContext(unitName = "TIENDAPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadocivilFacade() {
        super(Estadocivil.class);
    }
    
}
