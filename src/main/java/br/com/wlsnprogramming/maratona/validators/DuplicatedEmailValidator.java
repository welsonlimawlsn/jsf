package br.com.wlsnprogramming.maratona.validators;

import br.com.wlsnprogramming.maratona.bean.login.LoginBean;
import org.omnifaces.util.Faces;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

@FacesValidator
public class DuplicatedEmailValidator implements Validator {

    private List<String> emailsDB = Arrays.asList("welsonlimawlsn@gmail.com", "welsonlimawlt@gmail.com");

    @Inject
    private LoginBean loginBean;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = (String) o;
        if(emailsDB.contains(email)){
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este email já esta cadastrado", "");

            System.out.println(loginBean.getLanguage() + "Alguma coisa");

            throw new ValidatorException(message);
        }
    }
}
