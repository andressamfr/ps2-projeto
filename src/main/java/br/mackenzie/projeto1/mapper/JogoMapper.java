package br.mackenzie.projeto1.mapper;

import br.mackenzie.projeto1.domain.JogoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class JogoMapper extends ModelMapper {

//    public List<JogoDTO>

//    private ModelMapper modelMapper;
//
//    final Converter<JogoDTO, Jogo> jogoMapper = new Converter<JogoDTO, Jogo>() {
//
//        @Override
//        public Jogo convert(MappingContext<JogoDTO, Jogo> context) {
//            JogoDTO jogoDTO = context.getSource();
//            Jogo jogo = new Jogo();
//            jogo.setNomeTimeA(jogoDTO.getNomeTimeA());
//            jogo.setNomeTimeB(jogoDTO.getNomeTimeB());
//            jogo.setGolsTimeA(jogoDTO.getGolsTimeA());
//            jogo.setGolsTimeB(jogoDTO.getGolsTimeB());
//            return jogo;
//        }
//    };
//
//    public JogoMapper() {
//        modelMapper = new ModelMapper();
//        modelMapper.addConverter(jogoMapper);
//    }
//
//    public Jogo mapTo(JogoDTO jogoDTO) {
//        return this.modelMapper.map(jogoDTO, Jogo.class);
//    }
}