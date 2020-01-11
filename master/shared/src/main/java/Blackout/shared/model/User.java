package Blackout.shared.model;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User
{
    @Id
    public String u_id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "userSet")
    public Set<Role> roles;
}
