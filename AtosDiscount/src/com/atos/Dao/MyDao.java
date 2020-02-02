package com.atos.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atos.model.Discounts;

public class MyDao {

	public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  

	public static int save(Discounts d){  
        int status=0;  
        try{  
            Connection con=MyDao.getConnection();
            PreparedStatement ps=con.prepareStatement(  
                         "insert into Discounts(product_id,product_price,product_discount,Discount_valid) values (?,?,?,?)");  
            ps.setInt(1,d.getProduct_discount());
            ps.setInt(2,d.getProduct_price());
            ps.setInt(3,d.getProduct_discount());
            ps.setString(4,d.getDiscount_valid());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	
	public Discounts getProductById(int id) throws ClassNotFoundException,SQLException
	{  
		Discounts ds = new Discounts();
		ds.setProduct_id(-1);
			try {

				
            Connection con=MyDao.getConnection();
            
            PreparedStatement ps=con.prepareStatement("select * from Discounts where product_id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
            	ds = new Discounts(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
                return ds;
            }
            else {
            	ds.setProduct_id(-1);
            	return ds;
            }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ds;
    }  
	
	
}
