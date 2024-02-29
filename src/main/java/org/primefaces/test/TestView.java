package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Data;
import org.primefaces.component.tabview.TabView;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;
    private List<OpenTabObject> openTabObjects = new ArrayList<>();
    private int activeTabIndex = 0;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        list = new ArrayList<>(Arrays.asList(
                new TestObject("Thriller", "Michael Jackson", 1982),
                new TestObject("Back in Black", "AC/DC", 1980),
                new TestObject("The Bodyguard", "Whitney Houston", 1992),
                new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973)
        ));
        openTabObjects.add(new OpenTabObject("Search", "search", null));
    }

    public void showDetails(TabEntity entity) {
        String header = entity.getIdentityField();
        String view = entity.getDetailViewName();
        OpenTabObject openTabObject = new OpenTabObject(header,view, entity);
        openTabObjects.add(openTabObject);
    }

    public void onTabClose(TabCloseEvent<?> event) {
        TabView tv = (TabView) event.getComponent();
        int activeIndex = tv.getActiveIndex();

        FacesMessage msg = new FacesMessage("Closed", "Closed Tab. Active Tab " + activeIndex);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onTabChange(TabChangeEvent<?> event) {
        FacesMessage msg = new FacesMessage("Closed", "Changed to Tab No " + activeTabIndex);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
