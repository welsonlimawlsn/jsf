package br.com.wlsnprogramming.maratona.bean.comunicacao;

import br.com.wlsnprogramming.maratona.model.Estudante;
import org.omnifaces.util.Faces;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTesteSeteBean implements Serializable {

    private String key;
    private String value;

    @PostConstruct
    public void init(){
        Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
        System.out.println(requestCookieMap);
        for(Map.Entry<String, Object> entry : requestCookieMap.entrySet()){
            System.out.println(entry.getKey() + " - - - " + ((Cookie)requestCookieMap.get(entry.getKey())).getValue());
        }

        //Método dificil de recuperar um cookie
        Cookie cookie = (Cookie) requestCookieMap.get("FULLNAME");
        try {
            System.out.println(URLDecoder.decode(cookie.getValue(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Método fácil de recuperar um cookie
        System.out.println(Faces.getRequestCookie("FULLNAME"));


        //Teste
        try {
            System.out.println(URLEncoder.encode("O Welson é muito bonito", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public void salvarCookie(){
        Faces.addResponseCookie(key, value, -1);// MAXAGE: 0 remove o cookie
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
