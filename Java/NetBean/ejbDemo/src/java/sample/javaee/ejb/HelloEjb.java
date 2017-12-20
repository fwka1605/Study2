/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.javaee.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author NVLCLT13
 */
@Stateless
public class HelloEjb {
    public void hello() {
        System.out.println("Hello EJB!!");
    }    
}
