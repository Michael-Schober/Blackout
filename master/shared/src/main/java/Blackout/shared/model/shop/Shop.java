package Blackout.shared.model.shop;

import Blackout.shared.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Shop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;

    private String name;
    private String city;
    private String district;
    private String street;

    @Temporal(TemporalType.TIME)
    private Date opening;
    @Temporal(TemporalType.TIME)
    private Date closing;

    private String owner;
}
