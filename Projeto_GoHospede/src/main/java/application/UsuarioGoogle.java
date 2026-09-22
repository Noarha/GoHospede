package application;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
public class UsuarioGoogle extends GenericJson{
@Key
private String sub;
@Key
private String name;
@Key("email")
private String email;

@Key("email_verified")
private Boolean emailVerificado;
@Key
private String picture;

public String getIdGoogle() {
	return sub;
}
public String getNome() {
	return name;
}
public String getEmail() {
	return email;
}
public boolean getEmailVerificado() {
	return emailVerificado;
}
public String getFoto() {
	return picture;
}
}
