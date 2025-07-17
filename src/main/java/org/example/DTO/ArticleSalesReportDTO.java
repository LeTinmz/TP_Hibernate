package org.example.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ArticleSalesReportDTO {
    private String articleName;
    private int quantitySold;
    private double totalPrice;
    private int clientNumber;
}
