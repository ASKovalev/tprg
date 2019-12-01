package TPRG1.lab1.domain;

import org.springframework.security.core.GrantedAuthority;

//Интерфейс (перечисление) Role
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
