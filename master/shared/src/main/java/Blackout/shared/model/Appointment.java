package Blackout.shared.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date date;
}
