package br.com.cifresuasmusicas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@AllArgsConstructor
public enum SexEnum {

    M(1, "Masculino"),
    F(2, "Feminino");

    private final int id;
    private final String sex;

    public static SexEnum convert(String str) {
        for (SexEnum sexEnum : SexEnum.values()) {
            if (sexEnum.toString().equals(str)) {
                return sexEnum;
            }
        }
        return null;
    }

    public static Collection<String> strRoles() {
        Collection<String> lstRoles = new ArrayList<>();
        for (SexEnum sexEnum : SexEnum.values()) {
            lstRoles.add(sexEnum.name());
        }
        return lstRoles;
    }
}