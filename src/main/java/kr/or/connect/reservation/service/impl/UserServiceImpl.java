package kr.or.connect.reservation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.dao.UserRoleDao;
import kr.or.connect.reservation.dto.User;
import kr.or.connect.reservation.dto.UserRole;
import kr.or.connect.reservation.service.UserService;
import kr.or.connect.reservation.service.security.UserEntity;
import kr.or.connect.reservation.service.security.UserRoleEntity;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	
	public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}

	@Override
	@Transactional
	public UserEntity getUser(String loginUserId) {
		User user = userDao.getUserByEmail(loginUserId);
		return new UserEntity(user.getEmail(), user.getPassword());
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<UserRole> userRoles = userRoleDao.getRolesByEmail(loginUserId);
		List<UserRoleEntity> list = new ArrayList<>();
		for(UserRole userRole : userRoles) {
			list.add(new UserRoleEntity(loginUserId,userRole.getRoleName()));
		}
		return list;
	}

}
