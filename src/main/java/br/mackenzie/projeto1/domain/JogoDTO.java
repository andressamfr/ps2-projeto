package br.mackenzie.projeto1.domain;

import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JogoDTO {

    @NotNull
    private String nomeTimeA;

    @NotNull
    private int golsTimeA;

    @NotNull
    private String nomeTimeB;

    @NotNull
    private int golsTimeB;


}
