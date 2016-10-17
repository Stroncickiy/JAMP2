package com.epam.model;


import java.util.Date;

public class User {
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private Date birthDate;
        private boolean gender;

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
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

        public Date getBirthDate() {
                return birthDate;
        }

        public void setBirthDate(Date birthDate) {
                this.birthDate = birthDate;
        }

        public boolean isGender() {
                return gender;
        }

        public void setGender(boolean gender) {
                this.gender = gender;
        }
}
