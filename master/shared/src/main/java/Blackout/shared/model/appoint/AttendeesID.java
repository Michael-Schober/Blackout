package Blackout.shared.model.appoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AttendeesID implements Serializable
{
    private String at_id;
    private int ap_id;
    private int role;
}
