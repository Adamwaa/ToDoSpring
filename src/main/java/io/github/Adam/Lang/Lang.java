package io.github.Adam.Lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "languages")
public class Lang {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")

    private Integer id;

    @Column(name = "welcomemsg")
    private String welcomemsg;
    private String code;

    /**
     * Hibernate need it
     */
    public Lang() {

    }

    public Lang(Integer id, String welcomeMsg, String code) {
        this.id = id;
        this.welcomemsg = welcomeMsg;
        this.code = code;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWelcomemsg() {
        return welcomemsg;
    }

    public void setWelcomemsg(String welcomeMsg) {
        this.welcomemsg = welcomeMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
