package com.example.Products.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "LIGNECOMMANDE_TBL")
public class LigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommande;
    private int quantity;
  /* @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCommande", nullable = false)
    private Commande commande;
*/
}
