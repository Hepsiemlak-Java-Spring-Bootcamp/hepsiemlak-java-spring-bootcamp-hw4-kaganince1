import java.util.List;

import com.emlakburada.dao.AdvertRepository;
import com.emlakburada.dao.UserRepository;
import com.emlakburada.entity.Advert;
import com.emlakburada.entity.User;

public class Main {

	public static void main(String[] args) {

		UserRepository userRepository = new UserRepository();
		/*userRepository.save(prepareUser(1, "cem"));
		userRepository.save(prepareUser(2, "emir"));
		userRepository.save(prepareUser(3, "nehir"));
		userRepository.save(prepareUser(4, "melike"));
		userRepository.save(prepareUser(5, "serra"));*/

		System.out.println("--find all user--");

		List<User> users = userRepository.findAll();

		users.stream().forEach(user -> System.out.println(user.toString()));

		System.out.println("--find user--");

		User foundUser = userRepository.findOne(2);

		System.out.println(foundUser.toString());
		
		
		AdvertRepository advertRepository = new AdvertRepository();
		advertRepository.save(prepareAdvert(1, "Sahibinden", 1000, "Antalya", 145));
		advertRepository.save(prepareAdvert(2, "Sahibinden degil", 1500, "Istanbul", 120));
		advertRepository.save(prepareAdvert(3, "Kelepir", 1250, "Ankara", 110));
		advertRepository.save(prepareAdvert(4, "Bekara gider", 500, "Van", 66));
		advertRepository.save(prepareAdvert(5, "Ogrenciye indirimli", 750, "Eskisehir", 55));

		System.out.println("--find all advert--");

		List<Advert> adverts = advertRepository.findAll();

		adverts.stream().forEach(advert -> System.out.println(advert.toString()));

		System.out.println("--find advert--");

		Advert foundAdvert = advertRepository.findOne(2);

		System.out.println(foundAdvert.toString());

	}

	private static User prepareUser(int id, String name) {
		User user = new User();
		user.id = id;
		user.name = name;
		user.email = "cemdrman@gmail.com";
		user.bio = "bio";
		return user;
	}
	
	private static Advert prepareAdvert(int id, String header, int price, String city, int area) {
		Advert advert = new Advert();
		advert.id = id;
		advert.header = header;
		advert.price = price;
		advert.city = city;
		advert.area = area;
		return advert;
	}

}
