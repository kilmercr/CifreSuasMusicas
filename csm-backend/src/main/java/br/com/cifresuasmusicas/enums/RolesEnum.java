package br.com.cifresuasmusicas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@AllArgsConstructor
public enum RolesEnum {

    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER"),
    ROLE_MODERATOR(3, "ROLE_MODERATOR");

    private final int id;
    private final String roleName;

    public static RolesEnum convert(String str) {
        for (RolesEnum roleEnum : RolesEnum.values()) {
            if (roleEnum.toString().equals(str)) {
                return roleEnum;
            }
        }
        return null;
    }

    public static Collection<String> strRoles() {
        Collection<String> lstRoles = new ArrayList<>();
        for (RolesEnum roleEnum : RolesEnum.values()) {
            lstRoles.add(roleEnum.name());
        }
        return lstRoles;
    }
}