package com.example.survey.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "email",
        "age",
        "gender",
        "height",
        "weight",
        "answers",
        "mark"
})
public class Response {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("email")
    private String email;


    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("height")
    private String height;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("answers")
    private List<Answer> answers = null;
    @JsonProperty("mark")
    private Integer mark;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }


    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    @JsonProperty("gender")
    public void setGender(String gender) {
        this.gender = gender;
    }

    @JsonProperty("weight")
    public Double getWeight() {
        return weight;
    }

    @JsonProperty("weight")
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @JsonProperty("answers")
    public List<Answer> getAnswers() {
        return answers;
    }

    @JsonProperty("answers")
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @JsonProperty("mark")
    public Integer getMark() {
        return mark;
    }

    @JsonProperty("mark")
    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @JsonProperty("height")
    public String getHeight() {
        return height;
    }
    @JsonProperty("height")
    public void setHeight(String height) {
        this.height = height;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
