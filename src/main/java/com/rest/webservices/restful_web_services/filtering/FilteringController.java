package com.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("value 1","value 2","value 3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList( new SomeBean("value 1","value 2","value 3"),
        new SomeBean("value 4","value 5","value 6"));
    }



    @GetMapping("/filtering-with-view") //return field1 and field3
    @JsonView(View.View1.class)
    public SomeBean filteringWithView(){
        return new SomeBean("value 1","value 2","value 3");
    }

    @GetMapping("/filtering-list-with-view") //return field2 and field3
    @JsonView(View.View2.class)
    public List<SomeBean> filteringListWithView(){
        return Arrays.asList( new SomeBean("value 1","value 2","value 3"),
                new SomeBean("value 4","value 5","value 6"));
    }

}
