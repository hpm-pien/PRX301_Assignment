/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prx301_xml;

import java.util.Date;


/**
 *
 * @author atbgl
 */

public class Employee {
    String ID, Fullname, Telephone, Address, Gender, DOB;
//    Date DOB; 

    public Employee(String ID, String Fullname, String DOB, String Telephone, String Address, String Gender) {
        this.ID = ID;
        this.Fullname = Fullname;
        this.Telephone = Telephone;
        this.Address = Address;
        this.Gender = Gender;
        this.DOB = DOB;
    }
    
    public Employee(){
        
    }

    public String getID() {
        return ID;
    }
    
    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    

//    public Date getDOB() {
//        return DOB;
//    }
//
//    public void setDOB(Date DOB) {
//        this.DOB = DOB;
//    }

    @Override
    public String toString() {
        return "Employee{" + "ID=" + ID + ", Fullname=" + Fullname + ", Telephone=" + Telephone + ", Address=" + Address + ", Gender=" + Gender + ", DOB=" + DOB + '}';
    }
    
    public String convertXMLString(){
        return "<Employee>\n" +
                "<ID>"+ID+"</ID>\n" +
                "<Fullname>"+Fullname+"</Fullname>\n" +
                "<DOB>"+DOB+"</DOB>\n" +
                "<Telephone>"+Telephone+"</Telephone>\n" +
                "<Address>"+Address+"</Address>\n" +
                "<Gender>"+Gender+"</Gender>\n" +
            "</Employee>";
    }
}
