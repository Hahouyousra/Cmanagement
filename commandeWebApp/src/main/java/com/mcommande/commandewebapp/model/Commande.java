package com.mcommande.commandewebapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande {

    private Long      id;
    private String    description;
    private Integer   quantité;
    private LocalDate date;
    private Double    montant;


}
