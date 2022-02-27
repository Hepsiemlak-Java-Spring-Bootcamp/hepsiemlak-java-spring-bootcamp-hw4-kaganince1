package emlakburada.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Advert {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int advertNo;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "real_estate_id", referencedColumnName = "id")
	private RealEstate realEstate;
	private String baslik;
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "creator_user_id", referencedColumnName = "id")
	private User creatorUser; // hem bireysel & kurumsal
	//private String[] resimList = new String[5];
	private BigDecimal fiyat;
	private int suresi;
	private boolean oneCikarilsinMi = false;
	private boolean incelendiMi = false;
	private Date olusturulmaTarihi;
	private boolean aktifMi;

}
