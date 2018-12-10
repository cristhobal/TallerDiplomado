package cl.udechile.diplomado.tallerdeproyectos.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.udechile.diplomado.tallerdeproyectos.model.Texto;
import cl.udechile.diplomado.tallerdeproyectos.model.User;
import cl.udechile.diplomado.tallerdeproyectos.service.UserService;

@Controller
public class RegistrationController {

	private final static Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("user") User user) {
		userService.register(user);
		return new ModelAndView("welcome", "firstname", user.getFirstname());
	}

	@RequestMapping(value = "/registerText", method = RequestMethod.GET)
	public ModelAndView showRegisterTexto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("registerText");
		mav.addObject("texto", new Texto());
		return mav;
	}
	
	@RequestMapping(value = "/registerTextProcess", method = RequestMethod.POST)
	public ModelAndView addTexto(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("texto") Texto texto) {
		userService.registerText(texto);
		
		ModelAndView mav = null;
		mav = new ModelAndView("index");
		mav.addObject("username", texto.getUsername());
		
		return mav;
	}

	@RequestMapping(value = "/conectionPython", method = RequestMethod.POST)
	public ModelAndView conectionPython(HttpServletRequest request, HttpServletResponse response,
								@ModelAttribute("texto") Texto texto) {
		
		
		String respuestaDeSalida = "";
		String escrituraCodigo = texto.getTexto().replaceAll("\r\n", "");
		//String respuestaAlumno = texto.getTexto2();
		
		
        String clientId 	= "fddf15f86fa046d04d559af678221897"; //Replace with your client ID
        String clientSecret = "6c17b4a8f058860f5265b381309eb1e1eb96923be8e28b86ead5060695060912"; //Replace with your client Secret
        String script 		= escrituraCodigo; //"sprint('hola mundo')";
        String language 	= "python3";
        String versionIndex = "2";

        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
            "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            System.out.println(input);
            
            logger.debug(input);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	
                logger.debug("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
                
                ModelAndView mav = null;
        		mav = new ModelAndView("index");
        		mav.addObject("respuesta", "Se ha producido un error con los valores enviados. Comuniquese con el administrador");
        		
        		return mav;
                
            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            JSONObject jObject = null;
            String varDePaso = "";
            
            logger.debug("Output from JDoodle .... \n");
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
                logger.debug(output);
                System.out.println(output);
                
                try {
					jObject = new JSONObject(output);
	            
					System.out.println("'" + jObject.get("output") + "'");
	                System.out.println("'" + texto.getTexto2() + "'");
	                varDePaso = (String) jObject.get("output");

                } catch (JSONException e) {
                	logger.debug("Please check your inputs : JSONException : "+ e.toString());
                	System.out.println("Please check your inputs : JSONException : "+ e.toString());
                    
                    ModelAndView mav = null;
            		mav = new ModelAndView("index");
            		mav.addObject("respuesta", "Se ha producido un error con JSON. Comuniquese con el administrador");
            		
				}
                
                
                if (texto.getTexto2().trim().equals(varDePaso.replaceAll("\r\n", "").trim())) {
                	
                	respuestaDeSalida = "Tu respuesta esta correcta";
                	
                } else {
                	
                	respuestaDeSalida = "Tu respuesta esta incorrecta, debió ser '" + varDePaso.replaceAll("\r\n", "") 
                	+ "' y tu respondiste '" + texto.getTexto2() + "'";
                }
                
                
                
            }

            logger.debug("connection.disconnect()");
            connection.disconnect();

        } catch (MalformedURLException e) {
        	
        	logger.debug("MalformedURLException : "+ e.toString());
        	System.out.println("MalformedURLException : "+ e.toString());
        	respuestaDeSalida = "Error en la formación de la URL. Comuniquese con su administrador";

        } catch (IOException e) {
        	
        	logger.debug("IOException : "+ e.toString());
        	System.out.println("IOException : "+ e.toString());
        	
        	respuestaDeSalida = "Error con la entrada de datos. Comuniquese con su administrador";
        }

		
		ModelAndView mav = null;
		mav = new ModelAndView("index");
		mav.addObject("respuesta", respuestaDeSalida);
		
		return mav;
	}

}