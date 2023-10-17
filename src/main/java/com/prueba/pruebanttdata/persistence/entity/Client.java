package com.prueba.pruebanttdata.persistence.entity;

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
    private Long id = 1L;

    @NotNull
    @Column(name = ("document_number"), length = 25)
    private String documentNumber = "23445322";

    @Column(name = ("first_name"), length = 40, columnDefinition = "VARCHAR(50) DEFAULT 'Jhon'")
    private String firstName = "Jhon";

    @Column(name = ("second_name"), length = 40, columnDefinition = "varchar(50) DEFAULT 'Edison'")
    private String secondName = "Edison";

    @Column(name = ("first_surname"), length = 40, columnDefinition = "varchar(50) DEFAULT 'Feria'")
    private String firstSurname = "Feria";

    @Column(name = ("second_surname"), length = 20, columnDefinition = "varchar(50) DEFAULT  'Sanabria'")
    private String secondSurname = "Sanabria";

    @Column(name = "address", columnDefinition = "varchar(80) DEFAULT 'Calle 127'")
    private String address = "Calle 127";

    @Column(name = "phone", columnDefinition = "varchar(20) DEFAULT '12345678'")
    private String phone = "1234567";

    @Column(name = "city_of_residence", columnDefinition = "varchar(70) default 'Bogota,Colombia'")
    private String cityOfResidence = "Bogota";

    @Column(name = "typeDocument", columnDefinition = "varchar(70) default 'Bogota,Colombia'")
    private String typeDocument;

    @Column(name = "initial_type_document")
    private String initialTypeDocument;

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

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getInitialTypeDocument() {
        return initialTypeDocument;
    }

    public void setInitialTypeDocument(String initialTypeDocument) {
        this.initialTypeDocument = initialTypeDocument;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(documentNumber, client.documentNumber) && Objects.equals(firstName, client.firstName) && Objects.equals(secondName, client.secondName) && Objects.equals(firstSurname, client.firstSurname) && Objects.equals(secondSurname, client.secondSurname) && Objects.equals(address, client.address) && Objects.equals(phone, client.phone) && Objects.equals(cityOfResidence, client.cityOfResidence) && Objects.equals(typeDocument, client.typeDocument) && Objects.equals(initialTypeDocument, client.initialTypeDocument);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentNumber, firstName, secondName, firstSurname, secondSurname, address, phone, cityOfResidence, typeDocument, initialTypeDocument);
    }
}
