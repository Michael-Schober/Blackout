package Blackout.shared.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int r_id;
    public String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "userRoles", joinColumns = {@JoinColumn(referencedColumnName = "r_id")}, inverseJoinColumns = {@JoinColumn(referencedColumnName = "u_id")})
    public Set<User> userSet = new HashSet<>();
}
