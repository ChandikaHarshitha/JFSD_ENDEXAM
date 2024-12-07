package com.kled.jfsd.endexam;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="customers")
	public class Customer {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String Name;
		private String email;
		private int age;
		private String Location;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getLocation() {
			return Location;
		}
		public void setLocation(String location) {
			Location = location;
		}
	}
