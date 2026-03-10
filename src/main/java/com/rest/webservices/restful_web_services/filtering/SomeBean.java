package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@JsonIgnoreProperties("field2")

//@JsonIgnoreProperties(ignoreUnknown = true)
//In banking and microservices you constantly receive responses from external APIs with
// many fields you don't need. Without ignoreUnknown = true your app
// would throw an exception for every unknown field. This annotation
// prevents that
public class SomeBean {

    @JsonView(View.View1.class)
    private String fielf1;

    //Static filtering, password for example.

//    @JsonIgnore
    @JsonView(View.View2.class)
    private String fielf2;

    @JsonView({View.View1.class, View.View2.class})
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
