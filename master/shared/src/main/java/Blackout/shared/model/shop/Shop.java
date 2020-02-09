package Blackout.shared.model.shop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Shop
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String name;
    private String street;
}
