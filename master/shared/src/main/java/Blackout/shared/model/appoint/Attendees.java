package Blackout.shared.model.appoint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @IdClass(AttendeesID.class)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendees
{
    @Id
    public String at_id;

    @Id
    public int role;

    @Id
    @ManyToOne
    @JoinColumn(name = "ap_id")
    @JsonBackReference
    public Appointment ap_id;
}
