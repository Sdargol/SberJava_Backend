package com.sdargol.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_table")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purse_id")
    private PurseEntity purseEntity;

    public UserEntity() {
    }

    public UserEntity(Integer id, String login, String password, RoleEntity roleEntity, PurseEntity purseEntity) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleEntity = roleEntity;
        this.purseEntity = purseEntity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public PurseEntity getPurseEntity() {
        return purseEntity;
    }

    public void setPurseEntity(PurseEntity purseEntity) {
        this.purseEntity = purseEntity;
    }
}
