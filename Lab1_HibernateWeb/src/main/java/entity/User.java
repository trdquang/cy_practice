package entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@SuperBuilder
@Entity
@Table(name = "user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "pass_word")
    private String password;

    @Column(name = "full_name")
    private String fullname;

    private String email;
    private String avatar;
    private String role;
    private int active;
}
