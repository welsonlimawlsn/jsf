package br.com.wlsnprogramming.maratona.bean.viewexpired;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ViewExpiredTestBean implements Serializable {

    private String name;

    public void save() {
        System.out.println("Name: " + name);
    }

    public String invalidateSession() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
