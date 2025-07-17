package org.example.Entities;

import lombok.*;
import org.example.Utils.SaleStatusEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private Client client;
    @Column(nullable = false)
    private LocalDate date;
    @Column
    private List<Article> content;
    @Column
    private SaleStatusEnum saleStatus;
}
