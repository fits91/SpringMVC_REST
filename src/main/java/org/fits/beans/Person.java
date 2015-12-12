package org.fits.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by developer on 12.12.2015.
 */
@XmlRootElement
public class Person {

    public int id;
    public String fName;
    public String sName;
    public int age;

    @Override
    public String toString() {
        return "Bean{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }
}
