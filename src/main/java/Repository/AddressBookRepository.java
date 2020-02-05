package Repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource(collectionResourceRel = "AddressBook", path = "AddressBook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {
    AddressBook findById(@Param("id") long id);
}