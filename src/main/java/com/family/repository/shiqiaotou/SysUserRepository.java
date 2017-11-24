package com.family.repository.shiqiaotou;

import com.dongsport.entity.ds3.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cunxing on 2017/10/12.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUserNameAndStatus(String userName, int status);

}
