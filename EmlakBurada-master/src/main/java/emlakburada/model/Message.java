package emlakburada.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String baslik;
	private String icerigi;
	private Date gonderilenTarih;
	private Date okunduguTarihi;
	private boolean gorulduMu;
	@ManyToOne
	@JoinColumn(name = "sent_by", referencedColumnName = "id")
	private User gonderici;
	@ManyToOne
	@JoinColumn(name = "receive_by", referencedColumnName = "id")
	private User alici;

	public Message(String baslik) {
		super();
		this.baslik = baslik;
	}

}
