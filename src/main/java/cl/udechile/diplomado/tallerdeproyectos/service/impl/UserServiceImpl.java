/**
 * 
 */
package cl.udechile.diplomado.tallerdeproyectos.service.impl;

import cl.udechile.diplomado.tallerdeproyectos.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.udechile.diplomado.tallerdeproyectos.dao.UserDao;
import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.Texto;
import cl.udechile.diplomado.tallerdeproyectos.model.User;

/**
 * @author wiriarte
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public void register(User user) {
		
		userDao.register(user);
		
		return;
		
	}
	
	@Override
	public User validateUser(Login login) {
		
		return userDao.validateUser(login);
		
	}
	
	public void registerText(Texto txt) {
		
		userDao.registerText(txt);
		return;
		
	}

	@Override
	public Texto mostrarTexto(Login login) {
		
		return userDao.mostrarTexto(login);
		
	}
	
	public List<User> mostrarUser(User user) {
		
		return userDao.mostrarUser(user);
		
	}
}
