package com.example.tp3;

public class User {
		private String ID;
		private String name;
		private String age;
		private String email;
		private String password;

		public User() {
			super();
		}

		public User(String iD, String name, String age, String email, String password) {
			super();
			ID = iD;
			this.name = name;
			this.age = age;
			this.email = email;
			this.password = password;
		}

		public String getID() {
			return ID;
		}

		public void setID(String iD) {
			ID = iD;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "User [ID=" + ID + ", name=" + name + ", age=" + age + ", email=" + email + ", password=" + password + "]";
		}

	}


