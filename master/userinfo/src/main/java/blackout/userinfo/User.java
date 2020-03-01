package blackout.userinfo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Data
public class User
{
    @Id()

    public String u_id;

    public String u_empt;
}
