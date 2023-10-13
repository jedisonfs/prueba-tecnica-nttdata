package com.prueba.pruebanttdata.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {


    private static final long serialVersionUID = 8153100060120095864L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = ("document_number"), length = 25)
    private String documentNumber;

    @Column(name = ("first_name"), length = 40, columnDefinition = "Jhon")
    private String firstName;

    @Column(name = ("second_name"), length = 40, columnDefinition = "Edison")
    private String secondName;

    @Column(name = ("first_surname"), length = 40, columnDefinition = "Feria")
    private String firstSurname;

    @Column(name = ("second_surname"), length = 20, columnDefinition = "Sanabria")
    private String secondSurname;

    @Column(name = "address", columnDefinition = "varchar(80) default 'Calle 127'")
    private String address;

    @Column(name = "phone", columnDefinition = "varchar(20) default '12345678'")
    private String phone;

    @Column(name = "city_of_residence", columnDefinition = "varchar(70) default 'Bogota,Colombia'")
    private String cityOfResidence;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_type_document_id")
    private TypeDocument typeDocumentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        this.cityOfResidence = cityOfResidence;
    }

    public TypeDocument getTypeDocumentId() {
        return typeDocumentId;
    }

    public void setTypeDocumentId(TypeDocument typeDocumentId) {
        this.typeDocumentId = typeDocumentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(documentNumber, client.documentNumber) && Objects.equals(firstName, client.firstName) && Objects.equals(secondName, client.secondName) && Objects.equals(firstSurname, client.firstSurname) && Objects.equals(secondSurname, client.secondSurname) && Objects.equals(address, client.address) && Objects.equals(phone, client.phone) && Objects.equals(cityOfResidence, client.cityOfResidence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentNumber, firstName, secondName, firstSurname, secondSurname, address, phone, cityOfResidence);
    }
}
