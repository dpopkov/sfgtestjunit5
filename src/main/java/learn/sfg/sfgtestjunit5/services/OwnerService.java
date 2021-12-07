package learn.sfg.sfgtestjunit5.services;

import learn.sfg.sfgtestjunit5.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastNameLike(String lastName);
 }
