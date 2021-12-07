package learn.sfg.sfgtestjunit5.repositories;


import learn.sfg.sfgtestjunit5.model.Owner;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
}
