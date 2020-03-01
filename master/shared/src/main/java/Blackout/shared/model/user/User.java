package Blackout.shared.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User
{
    @Id
    private String u_id;
}
