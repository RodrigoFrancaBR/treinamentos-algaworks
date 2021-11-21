package br.com.franca.appfood.domain.dtos;

import br.com.franca.appfood.domain.model.Cozinha;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonRootName("Cozinhas")
public class CozinhasXmlWrapper {

    @JsonProperty("cozinha")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Cozinha> cozinhas;
}

/**
 * Lombok
 * @Data + @NonNull obriga o atributo a ser definido no construtor.
 * @AllArgsConstructor faz com que todos os atributos sejam definidos no construtor
 */

/** Alterar o nome da propriedade do XML
 * @JsonProperty("cozinha")
 * @JacksonXmlProperty(localName = "cozinha")
 *
 * Resultado:
 * <Cozinhas>
 *     <cozinha>
 *         <id>1</id>
 *         <nome>Tailandesa</nome>
 *     </cozinha>
 *     <cozinha>
 *         <id>2</id>
 *         <nome>Indiana</nome>
 *     </cozinha>
 * </Cozinhas>
 */

/**
 * Desabilitar um embrulho, o embrulho List<Cozinha> cozinhas
 * @JacksonXmlElementWrapper(useWrapping = false)
 *
 * resultado:
 * <Cozinhas>
 *     <cozinhas>
 *         <id>1</id>
 *         <nome>Tailandesa</nome>
 *     </cozinhas>
 *     <cozinhas>
 *         <id>2</id>
 *         <nome>Indiana</nome>
 *     </cozinhas>
 * </Cozinhas>
 *
 */

/**
 * Alterar o nome (root) da classe Pode-se usar uma das anotações
 * @JacksonXmlRootElement(localName = "Cozinhas")
 * @JsonRootName("Cozinhas")
 * resultado:
 *
 * <Cozinhas>
 *     <cozinhas>
 *         <cozinhas>
 *             <id>1</id>
 *             <nome>Tailandesa</nome>
 *         </cozinhas>
 *         <cozinhas>
 *             <id>2</id>
 *             <nome>Indiana</nome>
 *         </cozinhas>
 *     </cozinhas>
 * </Cozinhas>
 *
 */

/**
 * Com a construção de um embrulho para a lista de cozinhas temos o seguinte resultado:
 *
 * <CozinhasXmlWrapper>
 *     <cozinhas>
 *         <cozinhas>
 *             <id>1</id>
 *             <nome>Tailandesa</nome>
 *         </cozinhas>
 *         <cozinhas>
 *             <id>2</id>
 *             <nome>Indiana</nome>
 *         </cozinhas>
 *     </cozinhas>
 * </CozinhasXmlWrapper>
 */