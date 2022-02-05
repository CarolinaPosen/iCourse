package by.itacademy.mikhalevich.icourse.model.auth;

import by.itacademy.mikhalevich.icourse.model.*;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false, exclude = {"username", "password", "enabled"})
@Table(name="credential", schema = "public")
public class Credential extends AbstractEntity {

    private String username;

    private String password;

    private boolean enabled;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "credential_role",
            joinColumns = @JoinColumn(name = "credential_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "credential_authority",
            joinColumns = @JoinColumn(name = "credential_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Collection<Authority> authorities = new ArrayList<>();


    public Credential withId(Integer id){
        setId(id);
        return this;
    }

    public Credential withUsername(String username) {
        setUsername(username);
        return this;
    }

    public Credential withPassword(String password) {
        setPassword(password);
        return this;
    }

    public Credential withRole(Role role){
        Optional<Role> optionalRole = roles.stream().findFirst();
        optionalRole.ifPresent(value -> roles.remove(value));
        roles.add(role);
        return this;
    }

    public Credential withAuthority(Authority authority) {
        Optional<Authority> optionalCredential = authorities.stream().findFirst();
        optionalCredential.ifPresent(value -> authorities.remove(value));
            authorities.add(authority);
        return this;
    }

}



