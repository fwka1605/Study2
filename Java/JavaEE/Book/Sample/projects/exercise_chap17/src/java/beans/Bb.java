package beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Bb {

    @EJB
    CommuteDb db;

    public String init() {
        
        Commute buss = new Commute(Transportation.BUS,15000,null);
        Employee employee1 = new Employee("田中 宏",buss);
        Employee employee2 = new Employee("鈴木 一郎",buss);
        List<Employee> listBuss = new ArrayList<>();
        listBuss.add(employee1);
        listBuss.add(employee2);
        buss.setEmployees(listBuss);
        create(buss);
        
        Commute car = new Commute(Transportation.CAR,12000,null);
        Employee employee3 = new Employee("佐藤 修",car);
        List<Employee> listCar = new ArrayList<Employee>();
        listCar.add(employee3);
        car.setEmployees(listCar);
        create(car);
        
        Commute train = new Commute(Transportation.TRAM,10000,null);
        Employee employee4 = new Employee("山田 花子",train);
        Employee employee5 = new Employee("中村 太郎",train);
        List<Employee> listTrain = new ArrayList<Employee>();
        listTrain.add(employee4);
        listTrain.add(employee5);
        train.setEmployees(listTrain);
        create(train);

        // 登録完了を表示する画面
        return "output";

    }

    // Commuteエンティティをデータベースに登録する
    public void create(Commute c) {
        try {
            db.create(c);
        } catch (Exception e) {
        }
    }

    // 全データを取得する
    public List<Commute> getAllCommute() {
        return db.getAll();
    }
}
