/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.nouvelle.ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author NVLCLT13
 */
@Remote
public interface JPASession01Remote {
    public List getMeisai();
}
