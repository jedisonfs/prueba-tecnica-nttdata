package com.prueba.pruebanttdata.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "type_document")
public class TypeDocument implements Serializable {


    private static final long serialVersionUID = 7182856498786225400L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = ("initial"), length = 6, nullable = false)
    private String initial;

    @NotNull
    @Column(name = ("document_name"), length = 30, nullable = false)
    private String documentName;

    @OneToMany(mappedBy = ("typeDocumentId"), cascade = CascadeType.ALL)
    private Set<Client> clientList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Set<Client> getClientList() {
        return clientList;
    }

    public void setClientList(Set<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDocument that = (TypeDocument) o;
        return Objects.equals(id, that.id) && Objects.equals(initial, that.initial) && Objects.equals(documentName, that.documentName) && Objects.equals(clientList, that.clientList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initial, documentName, clientList);
    }
}
