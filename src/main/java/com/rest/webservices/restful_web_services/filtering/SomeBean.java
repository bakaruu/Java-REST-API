package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("field2")

//@JsonIgnoreProperties(ignoreUnknown = true)
//In banking and microservices you constantly receive responses from external APIs with
// many fields you don't need. Without ignoreUnknown = true your app
// would throw an exception for every unknown field. This annotation
// prevents that
public class SomeBean {

    private String fielf1;

    //Static filtering, password for example.
    @JsonIgnore
    private String fielf2;


    private String fielf3;

    public SomeBean(String fielf1, String fielf2, String fielf3) {
        this.fielf1 = fielf1;
        this.fielf2 = fielf2;
        this.fielf3 = fielf3;
    }

    public String getFielf1() {
        return fielf1;
    }

    public String getFielf2() {
        return fielf2;
    }

    public String getFielf3() {
        return fielf3;
    }


    @Override
    public String toString() {
        return "SomeBean{" +
                "fielf1='" + fielf1 + '\'' +
                ", fielf2='" + fielf2 + '\'' +
                ", fielf3='" + fielf3 + '\'' +
                '}';
    }
}
