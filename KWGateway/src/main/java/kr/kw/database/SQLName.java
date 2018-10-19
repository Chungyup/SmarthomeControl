package kr.kw.database;

public interface SQLName {
	// name space
	public static String SQL_NAMESPACE = "KWGATEWAY";
	
	// insert
	public static String SQL_INSERT_GW = SQL_NAMESPACE + ".insert_gateway";
	public static String SQL_INSERT_HA = SQL_NAMESPACE + ".insert_homeappliance";
	public static String SQL_INSERT_SENSOR = SQL_NAMESPACE + ".insert_sensor";
	public static String SQL_INSERT_TAG = SQL_NAMESPACE + ".insert_tag";
	public static String SQL_INSERT_USER = SQL_NAMESPACE + ".insert_user";
	public static String SQL_INSERT_SERVICE = SQL_NAMESPACE + ".insert_service";
	public static String SQL_INSERT_SCHEDULE = SQL_NAMESPACE + ".insert_schedule";
	public static String SQL_INSERT_SMARTPHONE = SQL_NAMESPACE + ".insert_phone";
	
	// select
	public static String SQL_SELECT_GW = SQL_NAMESPACE + ".select_gateway";
	public static String SQL_SELECT_ALL_HA = SQL_NAMESPACE + ".select_all_homeappliance";
	public static String SQL_SELECT_SCHEDULE = SQL_NAMESPACE + ".select_schedule";
	public static String SQL_SELECT_LATEST_PHONE = SQL_NAMESPACE + ".select_latest_phone";
	
	// delete
	public static String SQL_DELETE_SCHEDULE = SQL_NAMESPACE + ".delete_schedule";
}
