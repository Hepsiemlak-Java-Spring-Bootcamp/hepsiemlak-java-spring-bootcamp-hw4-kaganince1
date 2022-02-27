package emlakburada.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emlakburada.model.Banner;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {

}
