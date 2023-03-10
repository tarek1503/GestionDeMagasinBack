package com.example.products.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "COMMANDE_TBL")
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommande;
    private String statut;
    private Date dateCommande;
    private Double montantTotal;
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy="commande")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Client client;*/
}
