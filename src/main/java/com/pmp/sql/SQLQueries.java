package com.pmp.sql;

public class SQLQueries {
	private SQLQueries() {
	}
	
	public static final String SELECT_FROM_DEALER_TABLE="select * from dealer;";
	public static final String INSERT_INTO_DEALER_DETAILS="insert into dealer_details (dealerId,name,area,email,mobile) values(?,?,?,?,?);";
	public static final String SELECT_FROM_USER_TABLE="select * from user;";
	public static final String INSERT_INTO_USER_DETAILS="insert into user (password,name,email,mobile,address) values(?,?,?,?,?);";
	public static final String GET_USER_ID="select max(userId) from user;";
	public static final String GET_REQUEST_ID="select max(requestId) from dealer_details;";
	public static final String GET_REQUESTS="select * from dealer_details where dealerId=-1;";
	public static final String DELETE_REQUEST="delete from dealer_details where requestId=?";
	public static final String INSERT_DEALER="insert into dealer (requestId,password) values (?,?)";
	public static final String GET_DEALER_MAIL="select email from dealer_details where dealerId=?;";
	public static final String UPDATE_DEALER_DETAILS="update dealer_details set dealerId=? where requestId=?;";
	public static final String GET_INSERTED_DEALER_RECORD="select dealerId,password from dealer where requestId=?;";
	public static final String GET_REQUEST_COUNT="select count(*) from dealer_details where dealerId=-1;";
	public static final String GET_DEALER="select * from dealer_details where dealerId=?;";
	public static final String UNREGISTER_DEALER="delete from dealer_details where dealerId=?;";
	public static final String GET_ALL_DEALER_IDS="select dealerId from dealer_details where dealerId!=-1;";
}
