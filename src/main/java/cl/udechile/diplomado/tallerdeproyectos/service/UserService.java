/**
 * 
 */
package cl.udechile.diplomado.tallerdeproyectos.service;

import java.util.List;

import cl.udechile.diplomado.tallerdeproyectos.model.Login;
import cl.udechile.diplomado.tallerdeproyectos.model.Texto;
import cl.udechile.diplomado.tallerdeproyectos.model.User;

/**
 * @author wiriarte
 *
 */
public interface UserService {

	public abstract void register(User user);
	public abstract User validateUser(Login login);
	public abstract void registerText(Texto txt);
	public abstract Texto mostrarTexto(Login login);
	public abstract List<User> mostrarUser(User user);
}
