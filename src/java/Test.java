
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nuocm
 */
public class Test {
    public static void main(String[] args) {
        ProductDAO dao=new ProductDAO();
        List<Product> list=dao.getListStudent();
        for(Product o: list){
            System.out.println(o);
        }
    }
}
