package com.serhiy.edu.oms.data;

public class UrlRepository {
	public static enum Urls {
		LOCAL_HOST("http://10.7.1.16:7180/"),
		SSU_HOST("http://10.7.1.16:7180/");
		private String field;

		private Urls(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
//	public static String getClass86Url() {
//		return "http://class86:8080/OMS/login.htm";
//	}
//
//	public static String getSsuUrl() {
//		return "http://ssu-oms:8180/OMS/login.htm";
//	}
}
