package Blackout.shared.model.shop;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Shop
{
    @Id
    private long s_id;

    private String name;
    private String city;
    private String district;
    private String street;


    private Date opening;
    private Date closing;

    private String owner;
}
