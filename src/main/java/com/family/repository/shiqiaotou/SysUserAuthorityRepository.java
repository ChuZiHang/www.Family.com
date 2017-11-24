package com.family.repository.shiqiaotou;

import com.dongsport.entity.ds3.SysUserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cunxing on 2017/11/10.
 */
public interface SysUserAuthorityRepository extends JpaRepository<SysUserAuthority, Long> {

    List<SysUserAuthority> findByUserId(Long userId);
}
