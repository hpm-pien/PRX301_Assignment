/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prx301_xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author atbgl
 */
public class EmpHandler extends DefaultHandler{
    List<Employee> empList = new ArrayList<>();
    Employee CurrentEmp = null;
    
    boolean isID = false , isFullname = false, isDOB = false, isTelephone= false, isAddress = false, isGender = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Employee")){
            CurrentEmp = new Employee();
        } else if(qName.equalsIgnoreCase("ID")) {
            isID = true;
        } else if(qName.equalsIgnoreCase("Fullname")) {
            isFullname = true;
        } else if(qName.equalsIgnoreCase("DOB")) {
            isDOB = true;
        } else if(qName.equalsIgnoreCase("Telephone")) {
            isTelephone = true;
        } else if(qName.equalsIgnoreCase("Address")) {
            isAddress = true;
        } else if(qName.equalsIgnoreCase("Gender")) {
            isGender = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("employee")){
            empList.add(CurrentEmp);
            CurrentEmp = null;
        } else if(qName.equalsIgnoreCase("ID")) {
            isID = false;
        } else if(qName.equalsIgnoreCase("Fullname")) {
            isFullname = false;
        } else if(qName.equalsIgnoreCase("DOB")) {
            isDOB = false;
        } else if(qName.equalsIgnoreCase("Telephone")) {
            isTelephone = false;
        } else if(qName.equalsIgnoreCase("Address")) {
            isAddress = false;
        } else if(qName.equalsIgnoreCase("Gender")) {
            isGender = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length);
        
        if(isID){
            CurrentEmp.setID(value);
        } else if(isFullname){
            CurrentEmp.setFullname(value);
        } else if(isDOB){
            CurrentEmp.setDOB(value);
        } else if(isTelephone){
            CurrentEmp.setTelephone(value);
        } else if(isAddress){
            CurrentEmp.setAddress(value);
        } else if(isGender){
            CurrentEmp.setGender(value);
        }
    }

    public List<Employee> getEmpList() {
        return empList;
    }
}
