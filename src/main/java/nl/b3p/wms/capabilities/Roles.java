/*
 * B3P Commons GIS is a library with commonly used classes for OGC
 * reading and writing. Included are wms, wfs, gml, csv and other
 * general helper classes and extensions.
 *
 * Copyright 2005 - 2008 B3Partners BV
 * 
 * This file is part of B3P Commons GIS.
 * 
 * B3P Commons GIS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * B3P Commons GIS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with B3P Commons GIS.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.b3p.wms.capabilities;

public class Roles {

    public static final String ADMIN = "beheerder";
    public static final String ORG_ADMIN = "organisatiebeheerder";
    public static final String THEME_ADMIN = "themabeheerder";
    public static final String USER = "gebruiker";
    public static final String GUEST = "demogebruiker";

    private Integer id;
    private String role;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isProtectedRole() {
        if (role==null) {
            return false;
        }
        if (role.equalsIgnoreCase(Roles.ADMIN)) {
            return true;
        }
        if (role.equalsIgnoreCase(Roles.GUEST)) {
            return true;
        }
        if (role.equalsIgnoreCase(Roles.ORG_ADMIN)) {
            return true;
        }
        if (role.equalsIgnoreCase(Roles.THEME_ADMIN)) {
            return true;
        }
        if (role.equalsIgnoreCase(Roles.USER)) {
            return true;
        }
        return false;
    }

}