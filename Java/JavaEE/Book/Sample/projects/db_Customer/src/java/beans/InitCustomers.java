/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import db.CustomerDb;
import javax.ejb.*;
import entity.*;
import javax.ejb.Stateless;
import util.SHA256Encoder;

/**
 *
 * @author 川場隆
 */
@Stateless
public class InitCustomers {

    @EJB
    CustomerDb db;

    String[] id = {"admin", "tanaka", "suzuki", "guest"};
    String[] passwd = {"adminP", "tanakaP", "suzukiP", "guestP"};
    String[] name = {"管理者", "田中宏", "鈴木一郎", ""};
    String[] mail = {"admin@jp", "tanaka@jp", "suzkuki@jp", ""};
    String[] group = {"admin", "user", "user", ""};

    public void init() {
        for (int i = 0; i < id.length; i++) {
            GroupKey key = new GroupKey(group[i], id[i]);
            AppGroup group = new AppGroup(key, null);
            // パスワードは暗号化してからセットする
            Customer customer = new Customer(id[i], getEncodedPw(passwd[i]), name[i], mail[i], group);
            group.setCustomer(customer);
            db.add(customer);
        }
    }

    // パスワードの暗号化

    private String getEncodedPw(String pw) {
        SHA256Encoder encoder = new SHA256Encoder();
        return encoder.encodePassword(pw);
    }
}
