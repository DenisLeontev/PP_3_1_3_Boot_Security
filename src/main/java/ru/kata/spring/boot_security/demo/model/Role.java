package ru.kata.spring.boot_security.demo.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "role", nullable = false, length = 50)
    private String role;

    @Transient
    @ManyToMany(mappedBy = "roles")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    private Set<User> users;

    public Role() {
    }
    public Role(String role) {
        this.role = role;
    }
    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
     public String getRole() {
        return role;
    }
    public void setName(String role) {
        this.role = role;
    }
    @Override
    public String getAuthority() {
        return role;
    }
    public String toString() {
        return role;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return role != null ? role.equals(role.role) : role.role == null;
    }

    @Override
    public int hashCode() {
        return role != null ? role.hashCode() : 0;
    }
}
