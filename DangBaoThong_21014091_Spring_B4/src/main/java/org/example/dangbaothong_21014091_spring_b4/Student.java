/*
 * @ (#) Student.java    1.0    14/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_spring_b4;/*
 * @description:
 * @author: Bao Thong
 * @date: 14/11/2024
 * @version: 1.0
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {
    private String firstName;

    private String lastName;

    private String country;

    private String favoriteLanguage;

    private String[] operatingSystems;

    private LinkedHashMap<String, String> countryOptions;

    private LinkedHashMap<String, String> favoriteLanguageOptions;

    private ArrayList<String> operatingSystemOptions;

    public Student() {
        // populate favorite language options
        favoriteLanguageOptions = new LinkedHashMap<String, String>();
        // parameter order: value, display label
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C#", "C#");
        favoriteLanguageOptions.put("PHP", "PHP");
        favoriteLanguageOptions.put("Ruby", "Ruby");
        operatingSystemOptions = new ArrayList<String>();
        operatingSystemOptions.add("Linux");
        operatingSystemOptions.add("Mac OS");
        operatingSystemOptions.add("Ms Windows");
        //populate country options: use ISO country code
        countryOptions = new LinkedHashMap<String, String>();
        countryOptions.put("BR", "Brazil");
        countryOptions.put("FR", "France");
        countryOptions.put("DE", "Germany");
        countryOptions.put("IN", "India");
        countryOptions.put("US", "United States");
    }

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;

    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;

    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
    //favoriteOperatings
    public ArrayList<String> getOperatingSystemOptions() {
        return operatingSystemOptions;
    }

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}