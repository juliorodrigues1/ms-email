package br.gov.ac.msemail.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class EmailModel implements Serializable {
    private static  final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailTo;

    private String subject;

    @Column(columnDefinition = "TEXT")
    private String body;

    private LocalDateTime sendDateEmail;

    private StatusEmail statusEmail;


}
