package br.mackenzie.projeto1.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome_time_A")
    private String nomeTimeA;

    @NotNull
    @Column(name = "gols_time_A")
    private int golsTimeA;

    @NotNull
    @Column(name = "nome_time_B")
    private String nomeTimeB;

    @NotNull
    @Column(name = "gols_time_B")
    private int golsTimeB;

}