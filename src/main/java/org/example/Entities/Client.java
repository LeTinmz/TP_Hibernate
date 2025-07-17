package org.example.Entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String email;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Sale> sales;
}
