package emlakburada.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import emlakburada.model.enums.KonutType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RealEstate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String il;
	private String ilce;
	private String acikAdres;
	@Enumerated(EnumType.STRING)
	private KonutType konutType;
	private String odaSayisi;
	private int alan;
	private int bulunduguKat;
	@OneToOne(mappedBy = "realEstate")
	private Advert advert;

}