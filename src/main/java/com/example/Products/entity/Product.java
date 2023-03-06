package com.example.Products.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "PRODUCT_TBL")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String name;
    private String description;
    private Double prix;
    private Integer quantiteStock;

    @ManyToOne
    private Category category;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy="product")
     private List<LigneCommande> ligneCommandes;
*/
}
