package Repository;

import java.util.List;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(collectionResourceRel = "BuddyInfo", path = "BuddyInfo")
public interface BuddyInfoRepository extends PagingAndSortingRepository<BuddyInfo, Long> {

    List<BuddyInfo> findByName(@Param("lastName") String lastName);
    List<BuddyInfo> findByAddress(@Param("address") String address);
    List<BuddyInfo> findByPhoneNum(@Param("num") long num);

    BuddyInfo findById(@Param("id") long id);
}