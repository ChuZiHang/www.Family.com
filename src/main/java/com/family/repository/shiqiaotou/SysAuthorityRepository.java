package com.family.repository.shiqiaotou;

import com.dongsport.entity.ds3.SysAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by cunxing on 2017/11/10.
 */
public interface SysAuthorityRepository extends JpaRepository<SysAuthority, Long> {

    List<SysAuthority> findByIdIn(Set<Long> ids);
}
