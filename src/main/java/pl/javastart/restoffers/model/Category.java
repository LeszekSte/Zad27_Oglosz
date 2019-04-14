package pl.javastart.restoffers.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.util.List;


@Entity
public class Category {

    //lombok
    // BeanUtils.coptproperties(offer

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @Column(name = "ds_cat")
    private  String description;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Offer>  offers;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }
}
