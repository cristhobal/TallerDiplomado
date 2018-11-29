/**
 * 
 */
package cl.udechile.diplomado.tallerdeproyectos.service.impl;

import cl.udechile.diplomado.tallerdeproyectos.service.UserService;

import org.springframework.stereotype.Service;

import cl.udechile.diplomado.tallerdeproyectos.dao.UserDao;
import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.User;

/**
 * @author wiriarte
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	private UserDao userDao;

	public void register(User user) {
		
		userDao.register(user);
		
		return;
		
	}
	
	public User validateUser(Login login) {
		
		return userDao.validateUser(login);
		
	}
}
