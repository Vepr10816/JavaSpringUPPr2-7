package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Введите фамилию")
    @Size(min=2, message = "Фамилия не может быть меньше 2 букв")
    private String  lastName;
    @NotNull(message = "Заполните рост")
    @Min(value = 50, message = "Не меньше 50")
    @Max(value = 300, message = "Не больше 300")
    private float height;
    private boolean gender;
    @NotNull(message = "Заполните дату")
    private Date birthday;
    @NotNull(message = "Заполните вес")
    @Min(value = 20, message = "Не меньше 20")
    @Max(value = 300, message = "Не больше 300")
    private double weight;
    private int views;

    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="pasport_id")
    private Pasport pasport;

    @ManyToMany
    @JoinTable (name="student_university",
            joinColumns=@JoinColumn (name="student_id"),
            inverseJoinColumns=@JoinColumn(name="university_id"))
    private List<University> universities;

    public Human(String lastName, float height, boolean gender, Date birthday, double weight, Pasport pasport) {
        this.lastName = lastName;
        this.height = height;
        this.gender = gender;
        this.birthday = birthday;
        this.weight = weight;
        this.pasport = pasport;
    }

    public Human() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Pasport getPasport() {
        return pasport;
    }

    public void setPasport(Pasport pasport) {
        this.pasport = pasport;
    }

    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

}
