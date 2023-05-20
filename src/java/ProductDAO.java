

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.concurrent.Worker;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nuocm
 */
public class ProductDAO {
    ArrayList<Product> contactList = new ArrayList<>();
 Connection connection;
    PreparedStatement statement;
    ResultSet result;

     public ArrayList<Product> getListStudent() {
        contactList = new ArrayList<>();
        try {
            String q = "select * from Product";
            connection = new DBContext().getConnection();
            statement = connection.prepareStatement(q);
            result = statement.executeQuery();
            while (result.next()){
                Product product = new Product(result.getInt(1),
                                                result.getString(2),
                                                result.getString(3),
                                                result.getDouble(4) );
                contactList.add(product);
            }
            return contactList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ProductDAO() {
    }
    public List<Product> searchByName(String name) {
    ProductDAO workerDAO = new ProductDAO();
    List<Product> workers = workerDAO.getListStudent();
    List<Product> filteredWorkers = new ArrayList<>();
    for (Product product : workers) {
        if (product.getName().toLowerCase().contains(name.toLowerCase())) {
            filteredWorkers.add(product);
        }
    }
    return filteredWorkers;
}
    public List<Product> getListbyPage(List<Product> list,int start,int end){
    ArrayList<Product> arr=new ArrayList<>();
    for(int i=start;i<end;i++){
        arr.add(list.get(i));
}
   return arr;
}
}