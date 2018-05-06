package br.com.wlsnprogramming.maratona.bean.taglibfunction;

import org.apache.commons.text.WordUtils;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class TaglibFunctionTestBean implements Serializable {

    private List<String> names = Arrays.asList("welson lima", "wilson", "maria", "iraldo", "miguel");

    public void init() {
        names.forEach(name -> System.out.println(WordUtils.capitalizeFully(name)));
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
