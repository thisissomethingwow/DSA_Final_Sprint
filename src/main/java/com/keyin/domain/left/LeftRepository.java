package com.keyin.domain.left;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeftRepository extends CrudRepository<Left,Long> {
}
