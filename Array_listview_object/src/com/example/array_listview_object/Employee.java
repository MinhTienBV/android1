package com.example.array_listview_object;



public abstract class Employee {

	/**
	 * @param args
	 */
	String id;
	String Ten;
	
	
	public String getid()
	{
		return id;
	}
	public void setId(String id) {
		 this.id = id;
		 }
		 
		public String getName() {
		 return Ten;
		 }
		 
		public void setTen(String Ten) {
		 this.Ten = Ten;
		 }
		 
		public abstract double TinhLuong();
		 @Override
		 public String toString() {
		 // TODO Auto-generated method stub
		 return this.id+" - "+this.Ten;
		 }

	
	
}
