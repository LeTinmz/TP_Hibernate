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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(nullable = false)
    private LocalDate date;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "sale_article",
            joinColumns = @JoinColumn(name = "sale_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> content;
    @Column
    private SaleStatusEnum saleStatus;
}
