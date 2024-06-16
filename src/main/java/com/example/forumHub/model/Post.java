package com.example.forumHub.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post", schema = "forum_hub")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String texto;

    private boolean deletado;


    @ManyToOne
    @JoinColumn(name = "fk_assunto_id", referencedColumnName = "id")
    @JsonIgnoreProperties("post")
    private Assunto assunto;
}
