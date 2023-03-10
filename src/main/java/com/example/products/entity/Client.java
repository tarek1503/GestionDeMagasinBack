package com.example.products.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "CLIENT_TBL")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="FIRST_NAME")

    private String firstName;
    @Column(name ="LAST_NAME")

    private String lastName;
    @Column(name = "CONTACT")

    private String mobile;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy="client")
    private List<Commande> commandes;
*/
}
