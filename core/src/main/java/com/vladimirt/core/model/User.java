package com.vladimirt.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"email"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    /*
    На сколько я понял у нас у User может быть неколько ролей. У ролей будет отличаться функционал
    и возмонжно нужно будет чтобы пользователь обладал функционалом двух и более ролей. Поэтому мы храним Множество
    ролей.
    В тоже время у нас есть где-то класс Role - в котором хранятся роли. И там есть множество Users. Для того чтобы
    была возможность например сделать рассылку по всем юзерам заданной роли(хотя в принципе можно пробежать по множеству
    юзеров и проверить есть ли такая роль...странно).
    Таким образом при добавлении роли пользователю - эта роль добавляется в сножество ролей у пользователя, но в тоже
    время в объект role, который был передан - также добавляется Юзер, точнее в множество юзеров объекта role - добавляется
    этот юзер.
    Тоже самое с удаление
     */

    public void addRole(Role role){
        roles.add(role);
        role.getUsers().add(this);
    }

    public void removeRole(Role role){
        roles.remove(role);
        role.getUsers().remove(this);
    }




}
