package org.example.cafeweb.search;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSearch {
    private String productVendor;
    private String productName;
    private String productLine;
    private int limit;
    private int offset;
}
