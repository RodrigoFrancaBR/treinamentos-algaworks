package br.com.franca.appfood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Cozinha {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

}

/**
 * A representação de uma lista de cozinhas em XML fica assim:
 *
 * <List>
 *     <item>
 *         <id>1</id>
 *         <nome>Tailandesa</nome>
 *     </item>
 *     <item>
 *         <id>2</id>
 *         <nome>Indiana</nome>
 *     </item>
 * </List>
 *
 * A tag <List> é um embrulho</List>
 * A tag <item> é uma cozinha</item>
 * Se queremos customizar essa representação
 * precisamos criar um wrapper para representar uma lista de cozinhas
 *
 */
