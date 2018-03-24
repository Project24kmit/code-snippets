package com.pmp.sql;

public class SQLQueries {
	private SQLQueries() {
	}

	public static final String SELECT_FROM_DEALER_TABLE = "SELECT * FROM dealer;";
	public static final String INSERT_INTO_CATEGORY_TABLE = "INSERT INTO category(name,dealerId) VALUES(?,?);";
	public static final String INSERT_INTO_PRODUCT_TABLE = "INSERT INTO product(dealerId, name, categoryId, description, cost, stock, image) VALUES(?,?,?,?,?,?,?);";
	public static final String SELECT_CATEGORY_BY_CATEGORYNAME = "SELECT categoryId FROM category WHERE name=?;";
	public static final String SELECT_ALL_PRODUCTS_BY_DEALERID = "SELECT * FROM product WHERE dealerId=?;";
	public static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category;";
	public static final String SELECT_CATEGORY_BY_DEALERID="select * from category where dealerId=?;";
	public static final String DELETE_PRODUCT_BY_PRODUCTID = "DELETE FROM product WHERE productId=?;";
	public static final String UPDATE_PRODUCT_BY_PRODUCTID = "UPDATE product SET name=?, categoryId=?, description=?, cost=?, stock=? WHERE productId=?;";
	public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM product;";
	public static final String SELECT_DEALER_BY_DEALERID="SELECT * FROM dealer_details WHERE dealerId=?;";
	public static final String UPDATE_DEALER_BY_DEALERID = "UPDATE dealer_details SET name=?, area=?, email=?, mobile=? WHERE dealerId=?;";
	
	public static final String INSERT_INTO_DEALER_DETAILS="insert into dealer_details (dealerId,name,area,email,mobile,company) values(?,?,?,?,?,?);";
	public static final String GET_REQUEST_ID="select max(requestId) from dealer_details;";


	public static final String SELECT_FROM_USER_TABLE="select * from user;";
	public static final String INSERT_INTO_USER_DETAILS="insert into user (password,name,email,mobile,address) values(?,?,?,?,?);";
	public static final String GET_USER_ID="select max(userId) from user;";
	public static final String GET_REQUESTS="select * from dealer_details where dealerId=-1;";
	public static final String DELETE_REQUEST="delete from dealer_details where requestId=?";
	public static final String INSERT_DEALER="insert into dealer (requestId,password) values (?,?)";
	public static final String GET_DEALER_MAIL="select email from dealer_details where dealerId=?;";
	public static final String UPDATE_DEALER_DETAILS="update dealer_details set dealerId=? where requestId=?;";
	public static final String GET_INSERTED_DEALER_RECORD="select dealerId,password from dealer where requestId=?;";
	public static final String GET_DEALER="select * from dealer_details where dealerId=?;";
	public static final String UNREGISTER_DEALER="delete from dealer_details where dealerId=?;";
	public static final String GET_ALL_DEALER_IDS="select dealerId from dealer_details where dealerId!=-1;";

	public static final String STORE_EX_DEALER="insert into ex_dealer_details (dealerId,date,name,area,email,mobile,reason) values(?,?,?,?,?,?,?);";

	public static final String GET_USER_ORDERS="select * from order_details where userId=? and status='cart';";	
	public static final String GET_PRODUCT_DETAIL="select name,description,cost,image from product where productId=?;";

	public static final String DELETE_TRANSACTION="delete from order_details where transactionId=?;";
	public static final String UPDATE_TRANSACTION="update order_details set quantity=? where transactionId=?;";
	public static final String GET_DEALER_SALES_DATA="select (select name from product p where p.productId = o.productId),sum(o.quantity) from order_details o where dealerId = ? and o.status='bought' group by productId;";
	public static final String GET_DATEWISE_DEALER_SALES_DATA="select (select name from product p where p.productId = o.productId),sum(o.quantity) from order_details o where dealerId = ? and o.status='bought' and DATE_FORMAT(o.date, '%m-%Y')=? group by productId;";
	public static final String GET_ANNUAL_DEALER_SALES_DATA= "select date_format(date,'%m-%Y'),sum(o.quantity)  from order_details o where o.dealerId=? and o.productId=? and o.status='bought' and DATE_FORMAT(o.date, '%Y')=year(curdate()) group by date_format(date,'%m-%Y');";
	public static final String GET_OVERALL_SALES_FOR_ADMIN="select dealerId,count(o.quantity) from order_details o where o.status='bought' group by o.dealerId;";
	public static final String GET_DEALER_SALES_FOR_ADMIN="select date_format(date,'%m-%Y'),count(o.quantity)  from order_details o where o.dealerId=? and o.status='bought' and DATE_FORMAT(o.date, '%Y')=year(curdate()) group by date_format(date,'%m-%Y');";
}


	



