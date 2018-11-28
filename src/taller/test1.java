package taller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class test1 {

		    public static void main(String args[]) {

		        String clientId = "fddf15f86fa046d04d559af678221897"; //Replace with your client ID
		        String clientSecret = "6c17b4a8f058860f5265b381309eb1e1eb96923be8e28b86ead5060695060912"; //Replace with your client Secret
		        String script = "print('hola mundo')";
		        String language = "python3";
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

		            OutputStream outputStream = connection.getOutputStream();
		            outputStream.write(input.getBytes());
		            outputStream.flush();

		            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
		                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
		            }

		            BufferedReader bufferedReader;
		            bufferedReader = new BufferedReader(new InputStreamReader(
		            (connection.getInputStream())));

		            String output;
		            System.out.println("Output from JDoodle .... \n");
		            while ((output = bufferedReader.readLine()) != null) {
		                System.out.println(output);
		            }

		            connection.disconnect();

		        } catch (MalformedURLException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		

		            
	}


